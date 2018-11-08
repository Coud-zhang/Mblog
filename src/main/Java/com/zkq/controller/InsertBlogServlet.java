package com.zkq.controller;

import com.zkq.daoiface.InsertDao;
import com.zkq.service.insertServiceImpl;
import com.zkq.service.selectServiceImpl;
import com.zkq.serviceiface.insertservice;
import com.zkq.serviceiface.selectservice;
import lombok.extern.log4j.Log4j;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/InsertBlogServlet")
@Log4j//lombok用于在编译阶段生成log对象
public class InsertBlogServlet extends HttpServlet {
   insertservice insertservice=new insertServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");                                                                            //设置浏览器发送的请求编码方式为utf-8
        response.setCharacterEncoding("utf-8");                                                                         //设置服务器发挥的响应编码方式为utf-8
        response.setContentType("text/html;charset=utf-8");
       String bt=request.getParameter("bt");
       String context=request.getParameter("test-editormd-markdown-doc");
       String gaishu=context.substring(0,30);
       Date date=new Date();
       SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
       boolean a=insertservice.insertBlog(bt,gaishu,context,sdf.format(date),"java");
       request.setAttribute("a",a);
       request.getRequestDispatcher("jsp/admain.jsp").forward(request,response);

    }
}
