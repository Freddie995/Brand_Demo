<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.zr.pojo.Brand" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/6/28/0028
  Time: 9:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
</head>
<h1>${user.username}，欢迎您</h1><br>
<input type="button" value="新增" id="add"><br>
<hr>
<%--<table border="1" cellspacing="0" width="800">--%>
<%--    <tr>--%>
<%--    <th>序号</th>--%>
<%--    <th>品牌名称</th>--%>
<%--    <th>企业名称</th>--%>
<%--    <th>排序</th>--%>
<%--    <th>品牌介绍</th>--%>
<%--    <th>状态</th>--%>
<%--    <th>操作</th>--%>
<%--    </tr>--%>
<%--    <c:forEach items="${brands}" var="brand" varStatus="status">--%>
<%--        <tr align="center">--%>
<%--            <td>${status.count}</td>--%>
<%--            <td>${brand.brandName}</td>--%>
<%--            <td>${brand.companyName}</td>--%>
<%--            <td>${brand.ordered}</td>--%>
<%--            <td>${brand.description}</td>--%>
<%--            <c:if test="${brand.status == 1}">--%>
<%--                <td>启用</td>--%>
<%--            </c:if>--%>
<%--            <c:if test="${brand.status != 1}">--%>
<%--                <td>禁用</td>--%>
<%--            </c:if>--%>
<%--            <td><a href="selectById?id=${brand.id}">修改</a><a href="deleteById?id=${brand.id}">删除</a> </td>--%>
<%--        </tr>--%>
<%--    </c:forEach>--%>
<%--    </table>--%>
<table id="brandTable" border="1" cellspacing="0"
       width="100%"></table>
<script src="js/axios-0.18.0.js"></script>
<script>
    axios({
        method:"get",
        url:"http://localhost/brandlist"
    }).then(function (resp){
        //获取数据
        let brands = resp.data;
        let tableData = " <tr>\n" +
            " <th>序号</th>\n" +
            " <th>品牌名称</th>\n" +
            " <th>企业名称</th>\n" +
            " <th>排序</th>\n" +
            " <th>品牌介绍</th>\n" +
            " <th>状态</th>\n" +
            " <th>操作</th>\n" +
            " </tr>";
        for (let i = 0; i < brands.length ; i++)
        {
            let brand = brands[i];
            tableData += "\n" +
                " <tr align=\"center\">\n" +
                " <td>"+(i+1)+"</td>\n" +
                " <td>"+brand.brandName+"</td>\n" +
            "<td>"+brand.companyName+"</td>\n" +
            "<td>"+brand.ordered+"</td>\n" +
                "<td>"+brand.description+"</td>\n" +
            "<td>"+brand.status+"</td>\n" +
            "\n" + "<td><a href=\"selectById?id=" + brand.id + "\">修改</a> <a href=\"deleteById?id=" + brand.id + "\">删除</a></td>\n" +
            "</tr>";
        }
        // 设置表格数据

        document.getElementById("brandTable").innerHTML =
            tableData;
    })
    document.getElementById("add").onclick = function (){
        location.href = "addBrand.html"
    }
</script>
</body>
</html>
