package com.zkq.controller;

import com.zkq.domain.Blog;
import com.zkq.pageutils.Page;
import com.zkq.service.selectServiceImpl;
import com.zkq.serviceiface.selectservice;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

@WebServlet("/InitPageServlet")
public class InitPageServlet extends HttpServlet {
    selectservice selectservice=new selectServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");                                                                            //设置浏览器发送的请求编码方式为utf-8
        response.setCharacterEncoding("utf-8");                                                                         //设置服务器发挥的响应编码方式为utf-8
        response.setContentType("text/html;charset=utf-8");
        String method=request.getParameter("method");
        String currentPage=null==request.getParameter("currentPage")?"1":request.getParameter("currentPage");
        Page<Blog> page=new Page<Blog>(Integer.valueOf(currentPage),3);
        selectservice.getBlogBypage(page);
        selectservice.getBlogRows(page);
        if(Objects.equals(method,"init")){
            request.setAttribute("all",page);
            request.getRequestDispatcher("jsp/main.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doPost(request,response);
    }
}
