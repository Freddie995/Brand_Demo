package com.gdufs.web;

import com.alibaba.fastjson.JSON;
import com.gdufs.mapper.UserMapper;
import com.gdufs.pojo.User;
import com.gdufs.service.UserService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;

/**
 * Description:
 * Param:
 * return:
 * Author:Freddie
 * Date: 2022/6/28
 */

@WebServlet("/register")
public class Register extends HttpServlet {
    private UserService service = new UserService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        BufferedReader bf = req.getReader();
        String params = bf.readLine();
//        System.out.println(params);
        User user = JSON.parseObject(params,User.class);
//        System.out.println(user);


//        //获取用户输入的验证码
//        String checkCode = req.getParameter("checkCode");
//
//        //程序生成的验证码，从Session获取
//        HttpSession session = req.getSession();
//        String checkCodeGen = (String)session.getAttribute("checkCodeGen");
//        //比对
//        if (!checkCodeGen.equalsIgnoreCase(checkCode)){
//            resp.getWriter().write("codeError");
//            return;
//        }


        boolean flag = service.register(user);
        resp.setHeader("Access-Control-Allow-Origin", "*");
        resp.setContentType("text/json;charset=utf-8");


        if (flag){
            resp.getWriter().write("success");

        }else{
            resp.getWriter().write("success");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
