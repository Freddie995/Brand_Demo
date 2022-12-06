package com.gdufs.web;

import com.alibaba.fastjson.JSON;
import com.gdufs.pojo.Brand;
import com.gdufs.service.BrandService;

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
 * Date: 2022/6/29
 */

@WebServlet("/updateBrand")
public class UpdateBrand extends HttpServlet {
    private BrandService service = new BrandService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        //1.接收数据，request.getParameter不能接收json数据
        //获取请求体数据
        BufferedReader br = req.getReader();
        String params = br.readLine();
//        System.out.println(params);
        //将JSON字符串转为Java对象
        Brand brand = JSON.parseObject(params,Brand.class);
        System.out.println(brand);

        //2.调用service添加
        service.update(brand);
        //3.响应成功标识
        resp.setHeader("Access-Control-Allow-Origin", "*");
        resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().write("success");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
