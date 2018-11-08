<%--
  Created by IntelliJ IDEA.
  User: zkq15
  Date: 2018/5/17
  Time: 12:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib  prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>会开车的喵</title>
    <link href="../css/main.css" type="text/css" rel="stylesheet">
    <script src="../js/main.js" type="text/javascript" charset="utf-8"></script>
    <script src="../editormd/js/jquery.min.js"></script>
    <script src="../editormd/lib/marked.min.js"></script>
    <script src="../editormd/lib/prettify.min.js"></script>
    <script src="../editormd/lib/raphael.min.js"></script>
    <script src="../editormd/lib/underscore.min.js"></script>
    <script src="../editormd/lib/sequence-diagram.min.js"></script>
    <script src="../editormd/lib/flowchart.min.js"></script>
    <script src="../editormd/lib/jquery.flowchart.min.js"></script>
    <script src="../editormd/src/editormd.js"></script>
</head>
<body>
<c:import url="nav.jsp"></c:import>
<div class="context_div" id="context_div">
<table>
    <thead></thead>
        <tbody>
        <c:forEach items="${requestScope.all.list}" var="ems">
        <tr>
            <td>
                <div class="article1" style="margin-top: 35px;">
                    <div class="article_title">${ems.biaoTi}</div>
                    <div class="article_image">&nbsp;<span style="color: brown;">:${ems.data}</span></div>
                    <div class="article_zan">&nbsp;<span style="color: brown; margin-left: 5px;">:${ems.zan}</span></div>
                    <div class="article_biaoqian"><a href="#" style="color: brown;margin-left: 25px">${ems.biqoqian}</a></div>
                    <div class="div_arctile">
                       ${ems.gaishu}
                    </div>
                    <div class="article_read">
                        <input type="button" value="阅读全文" class="article_read_input">
                    </div>
                </div>
            </td>
        </tr>
        </c:forEach>
        </tbody>
</table>
    <div id="zh">
        <c:if test="${requestScope.all.currentPage==1}">
            首页&nbsp;上一页
        </c:if>
        <c:if test="${requestScope.all.currentPage!=1}">
            <a href="InitPageServlet?method=init&currentPage=1">首页</a>
            <a href="InitPageServlet?method=init&currentPage=${requestScope.all.currentPage-1}">上一页</a>
        </c:if>
        <c:if test="${requestScope.all.currentPage==requestScope.all.totalPage}">
            下一页&nbsp;尾页
        </c:if>
        <c:if test="${requestScope.all.currentPage!=requestScope.all.totalPage}">
            <a href="InitPageServlet?method=init&currentPage=${requestScope.all.currentPage+1}">下一页</a>
            <a href="InitPageServlet?method=init&currentPage=${requestScope.all.totalPage}">尾页</a>
        </c:if>
    </div>
</div>
<div class="top_footer">
    &nbsp;&nbsp;author:zkq<br>
    Contact To Me:
    <address style="display: inline-block;">
        <a href="mailto:zkq15263874326@outlook.com">zkq15263874326@outlook.com</a>
    </address>
</div>
</body>
<script type="text/javascript">
    editormd.markdownToHTML("chuli", {
        htmlDecode: "style,script,iframe",
        emoji: true,
        taskList: true,
        tex: true,  // 默认不解析
        flowChart: true,  // 默认不解析
        sequenceDiagram:true  // 默认不解析
    });
</script>
</html>
