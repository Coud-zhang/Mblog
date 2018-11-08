package com.zkq.controller;

import com.zkq.domain.User;
import com.zkq.pageutils.Page;
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

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
    private Logger log=Logger.getLogger(UserServlet.class);
     selectservice selectservice=new selectServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");                                                                            //设置浏览器发送的请求编码方式为utf-8
        response.setCharacterEncoding("utf-8");                                                                         //设置服务器发挥的响应编码方式为utf-8
        response.setContentType("text/html;charset=utf-8");
        String currentPage=null==request.getParameter("currentPage")?"1":request.getParameter("currentPage");
        Page<User> page=new Page<>(Integer.valueOf(currentPage),2);
       log.debug(page.getCurrentPage());
        selectservice.getUserBypage(page);
        selectservice.getUserRows(page);
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("page",page);
        response.getWriter().write(jsonObject.toString());
    }
}
