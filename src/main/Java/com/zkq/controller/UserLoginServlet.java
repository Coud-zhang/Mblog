package com.zkq.controller;

import com.zkq.domain.User;
import com.zkq.pageutils.Page;
import com.zkq.service.selectServiceImpl;
import com.zkq.serviceiface.selectservice;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Objects;

@WebServlet("/UserLoginServlet")
public class UserLoginServlet extends HttpServlet {
    selectservice selectservice=new selectServiceImpl();
    private Logger logger=Logger.getLogger(UserLoginServlet.class);
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");                                                                            //设置浏览器发送的请求编码方式为utf-8
        response.setCharacterEncoding("utf-8");                                                                         //设置服务器发挥的响应编码方式为utf-8
        response.setContentType("text/html;charset=utf-8");
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        HttpSession session=request.getSession();
        session.setAttribute("name", username);
            if(selectservice.checkpassWord(username,password)){
                User user=selectservice.getUserRights(username);
                request.setAttribute("rights",user);
                request.getRequestDispatcher("jsp/admain.jsp").forward(request,response);
            }else {
                request.setAttribute("message","用户名或密码错误，请重新输入");
                request.getRequestDispatcher("login.jsp").forward(request,response);
            }
    }
}
