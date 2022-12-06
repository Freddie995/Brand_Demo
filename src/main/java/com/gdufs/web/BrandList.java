package com.gdufs.web;

import com.alibaba.fastjson.JSON;
import com.gdufs.pojo.Brand;
import com.gdufs.service.BrandService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Description:
 * Param:
 * return:
 * Author:Freddie
 * Date: 2022/6/28
 */

@WebServlet("/brandlist")
public class BrandList extends HttpServlet {
    private BrandService service = new BrandService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        //1.调用BrandService完成查询
        List<Brand> brands = service.selectAll();
        //2.将集合转换为JSON数据 序列化
        String jsonString = JSON.toJSONString(brands);
        //3.响应数据 application/json text/json
        resp.setHeader("Access-Control-Allow-Origin", "*");
        resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().write(jsonString);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
