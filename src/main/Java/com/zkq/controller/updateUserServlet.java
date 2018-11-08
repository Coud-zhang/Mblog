package com.zkq.controller;

import com.zkq.domain.User;
import com.zkq.service.selectServiceImpl;
import com.zkq.service.updateServiceImpl;
import com.zkq.serviceiface.selectservice;
import com.zkq.serviceiface.updateService;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updateUserServlet")
public class updateUserServlet extends HttpServlet {
    updateService updateservice=new updateServiceImpl();
    selectservice selectservice=new selectServiceImpl();
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
        boolean flag= updateservice.updateUser(username,password,email,"1111");
        JSONObject js=new JSONObject();
        js.put("flag",flag);
        System.out.print(flag);
        response.getWriter().write(js.toString());

    }
}
