package com.gdufs.web;

import com.alibaba.fastjson.JSON;
import com.gdufs.pojo.Brand;
import com.gdufs.pojo.PageBean;
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
 * Date: 2022/7/1
 */

@WebServlet("/selectByPageAndCondition")
public class SelectByPageAndCondition extends HttpServlet {
    private BrandService brandService = new BrandService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1. 接收 当前页码 和 每页展示条数 url?currentPage=1&pageSize=5
        String _currentPage =
                req.getParameter("currentPage");
        String _pageSize =
                req.getParameter("pageSize");
        int currentPage =
                Integer.parseInt(_currentPage);
        int pageSize = Integer.parseInt(_pageSize);
        // 获取查询条件对象
        BufferedReader br = req.getReader();
        String params = br.readLine();//json字符串
        //转为 Brand
        Brand brand = JSON.parseObject(params, Brand.class);
        //2. 调用service查询
        PageBean<Brand> pageBean =
                brandService.selectByPageAndCondition(currentPage,pageSize,brand);
        //2. 转为JSON
        String jsonString = JSON.toJSONString(pageBean);
        //3. 写数据
        resp.setContentType("text/json;charset=utf-8");
        resp.setHeader("Access-Control-Allow-Origin", "*");

        resp.getWriter().write(jsonString);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
