package com.zkq.controller;

import com.zkq.service.insertServiceImpl;
import com.zkq.serviceiface.insertservice;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addUserServlet")
public class addUserServlet extends HttpServlet {
   insertservice insertService=new insertServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");                                                                            //设置浏览器发送的请求编码方式为utf-8
        response.setCharacterEncoding("utf-8");                                                                         //设置服务器发挥的响应编码方式为utf-8
        response.setContentType("text/html;charset=utf-8");
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        String email=request.getParameter("email");
        String quanxian=request.getParameter("quanxian");
        String path=request.getParameter("path");
        boolean flag=insertService.insertUser(username,password,email,path,quanxian);
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("flag",flag);
        response.getWriter().write(jsonObject.toString());
    }
}
