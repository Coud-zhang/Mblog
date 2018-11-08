package com.zkq.controller;

import com.zkq.service.deleteServiceImpl;
import com.zkq.serviceiface.deleteService;
import lombok.extern.log4j.Log4j;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@Log4j
@WebServlet("/deleteBlogServlet")
public class deleteBlogServlet extends HttpServlet {
    deleteService deleteService=new deleteServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");                                                                            //设置浏览器发送的请求编码方式为utf-8
        response.setCharacterEncoding("utf-8");                                                                         //设置服务器发挥的响应编码方式为utf-8
        response.setContentType("text/html;charset=utf-8");
        String id=request.getParameter("id");
        boolean flag=deleteService.deleteBlog(Integer.valueOf(id));
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("deleteBlog",flag);
        response.getWriter().write(jsonObject.toString());

    }
}
