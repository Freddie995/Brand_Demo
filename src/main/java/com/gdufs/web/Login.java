package com.gdufs.web;

import com.alibaba.fastjson.JSON;
import com.gdufs.mapper.UserMapper;
import com.gdufs.pojo.Brand;
import com.gdufs.pojo.User;
import com.gdufs.service.UserService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

/**
 * Description:
 * Param:
 * return:
 * Author:Freddie
 * Date: 2022/6/28
 */
@WebServlet("/login")
public class Login extends HttpServlet {
    private UserService service = new UserService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.接收数据，request.getParameter不能接收json数据
        //获取请求体数据
        BufferedReader br = req.getReader();
        String params = br.readLine();
//        System.out.println(params);
        //将JSON字符串转为Java对象
        User user = JSON.parseObject(params,User.class);
//        System.out.println(user);


        //2.调用service添加
        boolean flag = service.login(user);
        //3.响应成功标识
        resp.setHeader("Access-Control-Allow-Origin", "*");
        resp.setContentType("text/json;charset=utf-8");

        //3.判断
        if (flag){

            //登录成功
            Cookie cookie = new Cookie("username", user.getUsername());
            cookie.setMaxAge(60*60*24*7);
            resp.addCookie(cookie);
            resp.getWriter().write("success");

        }else{
            //登录失败
            resp.getWriter().write("error");

        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }

}
