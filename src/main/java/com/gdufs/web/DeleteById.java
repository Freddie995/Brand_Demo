package com.gdufs.web;

import com.gdufs.pojo.Brand;
import com.gdufs.service.BrandService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Description:
 * Param:
 * return:
 * Author:Freddie
 * Date: 2022/6/29
 */

@WebServlet("/deleteById")
public class DeleteById extends HttpServlet {
    private BrandService service = new BrandService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        service.deleteById(Integer.parseInt(id));
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
