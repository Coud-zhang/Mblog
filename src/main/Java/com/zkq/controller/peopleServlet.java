package com.zkq.controller;

import com.zkq.domain.User;
import com.zkq.service.selectServiceImpl;
import com.zkq.serviceiface.selectservice;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/peopleServlet")
public class peopleServlet extends HttpServlet {
    selectservice selectservice=new selectServiceImpl();
    private Logger log=Logger.getLogger(peopleServlet.class);
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");                                                                            //设置浏览器发送的请求编码方式为utf-8
        response.setCharacterEncoding("utf-8");                                                                         //设置服务器发挥的响应编码方式为utf-8
        response.setContentType("text/html;charset=utf-8");
        String username=request.getParameter("keyword");
        User user= selectservice.getUserRights(username);
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("people",user);
        response.getWriter().write(jsonObject.toString());
    }
}
