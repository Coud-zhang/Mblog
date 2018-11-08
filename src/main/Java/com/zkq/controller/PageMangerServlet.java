package com.zkq.controller;

import com.zkq.domain.Blog;
import com.zkq.pageutils.Page;
import com.zkq.service.selectServiceImpl;
import com.zkq.serviceiface.selectservice;
import lombok.extern.log4j.Log4j;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/PageMangerServlet")
@Log4j
public class PageMangerServlet extends HttpServlet {
    private selectservice selectservice=new selectServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");                                                                            //设置浏览器发送的请求编码方式为utf-8
        response.setCharacterEncoding("utf-8");                                                                         //设置服务器发挥的响应编码方式为utf-8
        response.setContentType("text/html;charset=utf-8");
        String currentPage=null==request.getParameter("currentPage")?"1":request.getParameter("currentPage");
        Page<Blog> blogPage=new Page<>(Integer.valueOf(currentPage),3);
        selectservice.getBlogBypage(blogPage);
        selectservice.getBlogRows(blogPage);
       JSONObject jsonObject=new JSONObject();
        jsonObject.put("pageManger",blogPage);
        response.getWriter().write(jsonObject.toString());
    }
}
