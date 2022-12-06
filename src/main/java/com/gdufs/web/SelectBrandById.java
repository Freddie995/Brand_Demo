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

@WebServlet("/selectById")
public class SelectBrandById extends HttpServlet {
    private BrandService service = new BrandService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        Brand brand = service.selectById(Integer.parseInt(id));
        req.setAttribute("brand",brand);
        req.getRequestDispatcher("/updateBrand.jsp").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
