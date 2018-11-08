<%--
  Created by IntelliJ IDEA.
  User: zkq15
  Date: 2018/5/18
  Time: 15:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="../css/main.css" type="text/css" rel="stylesheet">
    <script src="../js/main.js" type="text/javascript" charset="utf-8"></script>
</head>
<body>
<nav class="top_nav">
    <ul class="top_menu">
        <li class="level1_li" style="margin-left: 30px;">
            <a href="../index.jsp"><div id="level1_li_div1"></div>首页</a>
        </li>
        <li class="level1_li">
            <a href="#"><div id="level1_li_div2"></div>分类</a>
        </li>
        <li class="level1_li">
            <a href=""><div id="level1_li_div3"></div>归档</a>
        </li>
        <li class="level1_li">
            <a href=""><div id="level1_li_div4"></div>论坛</a>
        </li>
        <li class="level1_li">
            <a href=""><div id="level1_li_div5"></div>留言</a>
        </li>
        <li class="level1_li">
            <a href="jsp/about.jsp"><div id="level1_li_div6"></div>关于</a>
        </li>
    </ul>
    <div style="float: right;margin-right: 8px;margin-top: 24px;" id="tubiao">
        <form>
            <div id="header_transtion">
                <div id="header_img"></div>
                <label for="header_search"></label>
                <input type="text" id="header_search"placeholder="Search..." />
            </div>
        </form>
    </div>
</nav>
</body>
</html>
