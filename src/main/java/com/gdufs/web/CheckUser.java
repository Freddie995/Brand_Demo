package com.gdufs.web;

import com.alibaba.fastjson.JSON;
import com.gdufs.pojo.User;
import com.gdufs.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * Description:
 * Param:
 * return:
 * Author:Freddie
 * Date: 2022/7/1
 */

@WebServlet("/checkUser")
public class CheckUser extends HttpServlet {
    private UserService service = new UserService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.接收数据，request.getParameter不能接收json数据
        //获取请求体数据
        req.setCharacterEncoding("utf-8");
        BufferedReader br = req.getReader();
        String params = br.readLine();
        System.out.println(params);

        resp.setHeader("Access-Control-Allow-Origin", "*");
        resp.setContentType("text/json;charset=utf-8");

        boolean flag = service.checkUser(params);
        System.out.println("flag="+flag);

        if (flag){
            //存在
            resp.getWriter().write("existed");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
