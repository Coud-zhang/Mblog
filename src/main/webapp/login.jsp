<%--
  Created by IntelliJ IDEA.
  User: zkq15
  Date: 2018/5/18
  Time: 16:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib  prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>登录</title>
    <link href="css/login.css" rel="stylesheet">
    <script src="js/login.js" type="text/javascript" charset="utf-8"></script>
</head>
<body>
    <div class="login">
        <h2> Login to my blog</h2>
        <h3>
            Enter your username and password to log on:
        </h3>
        <div class="login_form">
            <form action="UserLoginServlet" method="post">
                <input type="text" id="username" name="username" placeholder="&nbsp;用户名"><br>
                <div id="tishi"></div>
                <input type="password" name="password" id="password" placeholder="&nbsp;密码" style="margin-top: 20px;"><br>
                <input type="submit" value="LogIn" id="submit" style="margin-top: 20px;background-color: brown;color: white;">
            </form>
        </div>
    </div>
<c:if test="${not empty requestScope.message}">
    <script type="text/javascript">
        document.getElementById("tishi").style.cssText="display: block";
        document.getElementById("tishi").innerText="${requestScope.message}";
    </script>
</c:if>
</body>
</html>
