package com.gdufs.web;

import com.alibaba.fastjson.JSON;
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
 * Date: 2022/6/30
 */

@WebServlet("/deleteByIds")
public class DeleteByIds extends HttpServlet {
    private BrandService service = new BrandService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.接收json数据
        BufferedReader br = req.getReader();
        String params = br.readLine();
        //转为int[]
        int[] ids = JSON.parseObject(params,int[].class);
        //2.调用service添加
        service.deleteByIds(ids);
        //3.响应成功的标识
//        System.out.println("hello");
        resp.setHeader("Access-Control-Allow-Origin", "*");
        resp.getWriter().write("success");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
