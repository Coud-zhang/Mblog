<%--
  Created by IntelliJ IDEA.
  User: zkq15
  Date: 2018/5/18
  Time: 21:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>管理界面</title>
    <script src="../js/jquery-3.3.1.min.js" type="text/javascript" charset="UTF-8"></script>
    <link href="../css/admain.css" type="text/css" rel="stylesheet">
    <script src="../js/admain.js" type="text/javascript" charset="utf-8"></script>
</head>
<body>
<c:if test="${empty sessionScope.name}">
    <script type="text/javascript">
        window.location.href="../login.jsp";
    </script>
</c:if>
<c:if test="${not empty sessionScope.name}">
    <nav id="daohang">
        <div class="daohang_text">
            Mblog后台管理界面
        </div>
        <div id="daohang_photo">

        </div>
    </nav>
    <div style="overflow: hidden">
        <nav id="dh">
            <div id="dh_photo">
                <img src="../image/no_photo.png" style="width: 90px;height: 90px;" class="dh_photo">
            </div>
            <div style="font-size: 16px;color: white;margin-left: 45px;margin-top: 15px;">${requestScope.rights.quanxian}</div>
            <div id="dh_guanli">
                <ul class="level1_ul">
                    <li class="level1_li">用户管理</li>
                    <ul class="level2_ul" hidden>
                        <li><a href="#" class="level2_li" id="User">用户列表</a></li>
                        <li><a href="#" class="level2_li" id="addUser">添加用户</a></li>
                    </ul>
                    <li class="level1_li">文章管理  </li>
                    <ul class="level2_ul" hidden>
                        <li><a href="#" class="level2_li" id="writeblog">添加文章</a></li>
                        <li><a href="#" class="level2_li" id="bloglist">文章列表</a></li>
                    </ul>
                    <li class="level1_li">评论管理</li>
                    <ul class="level2_ul" hidden>
                        <li><a href="#" class="level2_li">添加评论</a></li>
                        <li><a href="#" class="level2_li">删除评论</a></li>
                    </ul>
                    <li style="margin-top: 15px;"><a href="../index.jsp" class="level1_li">退&nbsp;&nbsp;出</a></li>
                </ul>
            </div>
        </nav>
        <div id="article1">
            <h1 style="text-align: center; margin-top: 200px;">欢迎使用本博客系统</h1>
        </div>
    </div>
    <c:if test="${requestScope.a}">
        <script type="text/javascript">
            alert("增加成功");
        </script>
    </c:if>
</c:if>
</body>
<script type="text/javascript">
    var currentpage;
    var totalpage;
    function twoajax(url1,url2,nowpage,keywords,callback) {
        $.ajax({
            url:url1,
            data:{"currentPage":nowpage,"keyword":keywords},
            type:"post",
            datatype:"json",
            async:true,
            success:function (adata) {
                $.ajax({
                    url:url2,
                    type:"post",
                    dataType:"html",
                    success:function (data) {
                        var c= JSON.parse(adata);
                        $("#article1").html(data);
                        callback(c);
                    },
                    error:function () {
                        alert("error");
                    }
                });
            },
            error:function () {
            }
        });
    }
    function addUsertable(currentUser) {
        twoajax("../UserServlet","../html/User.html",currentUser,null,(c)=>{
            var str ="";
            for(var j=0;j<c.page.list.length;j++){
                str +="<tr class='content'>" +
                    "<td>"+"<input type='checkbox'class='userContent'>"+ "</td>" +
                    "<td>" +c.page.list[j].username +"</td>" +
                    "<td>" +c.page.list[j].password+"</td>" +
                    "<td>"+c.page.list[j].email +"</td>" +
                    "<td>" +c.page.list[j].path+"</td>" +
                    "<td><a href='#'>编辑</a></td>" +
                    "<td><a href='#'>删除</a></td>" +
                    "</tr>";
            }
            str+="<tr><td colspan='7'>"+"第"+c.page.currentPage+"页"+"&nbsp;"+"共"+c.page.totalPage+"页"
            $("#ta").append(str);
            var Us="${requestScope.rights.quanxian}";
            var arr=new Array();
            var arr1=new Array();
            Array.from(document.getElementsByClassName("content")).forEach((item)=>{
                var arr1=item.getElementsByTagName("td");
                for(let i=0;i<arr1.length;i++){
                    arr.push(arr1[i]);
                }
            })
            bianjiUser(Us,arr,arr1);//调用bianjiUser方法
            deleteUser(Us,arr,arr1);
            currentpage=c.page.currentPage;
            totalpage=c.page.totalPage;
        },false);
    }
    function bianjiUser(Us,arr,arr1) {
        for(let i=0;i<arr.length;i++){
            for(let j=1;j<arr.length/7+1;j++){
                if(i==(7*j-2)){
                    arr[i].addEventListener("click",()=>{
                        console.log(555)
                        if(Us=="超级管理员"){
                            console.log(666)
                            let username=arr[i].parentNode.firstChild.nextSibling.innerHTML;
                            twoajax("../peopleServlet","../html/people.html",1,username,(c)=>{
                                $("#username").html(c.people.username);
                                $("#password").val(c.people.password);
                                $("#email").val(c.people.email);
                                $("#pto").val(c.people.path);
                            })
                        }else{
                            alert("您不是超级管理员，无权进行修改操作")
                        }
                    });
                }
            }
        }
    }
    function deleteUser(Us,arr,arr1){
        for (let i=0;i<arr.length;i++){
            for(let j=1;j<arr.length/7+1;j++){
                if(i==(7*j-1)){
                    arr[i].addEventListener("click",()=>{
                        if(Us=="超级管理员"){
                            if(confirm("确定要删除该用户吗？")){
                                let username=arr[i].parentNode.firstChild.nextSibling.innerHTML;
                                $.ajax({
                                    url:"../deleteUserServlet",
                                    type:"post",
                                    datatype:"json",
                                    data:{"username":username},
                                    async:true,
                                    success:function (data) {
                                        let c=JSON.parse(data);
                                        if(c.deleteUser==true){
                                            alert("删除成功");
                                            addUsertable(1);
                                        }else{
                                            console.log("删除失败");
                                        }
                                    }
                                })
                            }
                        }else{
                            alert("您不是超级管理员，无权进行修改操作")
                        }
                    })
                }
            }
        }
    }
    function opertaUserPage() {
        $("body").on("click","#nextpage",function () {
            if(currentpage!=totalpage){
                addUsertable(currentpage+1);
            }
        });
        $("body").on("click","#forward",function () {
            if(currentpage!=1){
                addUsertable(currentpage-1);
            }
        });
        $("body").on("click","#first",function () {
            if(currentpage!=1){
                addUsertable(1);
            }
        });
        $("body").on("click","#total",function () {
            if(currentpage!=totalpage){
                addUsertable(totalpage);
            }
        });
    }
    function addBlogtable(currentBlog) {
        twoajax("../PageMangerServlet","../html/Page.html",currentBlog,null,(c)=>{
            var str ="";
            for(var j=0;j<c.pageManger.list.length;j++){
                str +="<tr class='pageContent'>" +
                    "<td><input type='checkbox' class='Page'></td>" +
                    "<td>" +c.pageManger.list[j].id+"</td>" +
                    "<td>" +c.pageManger.list[j].biaoTi +"</td>" +
                    "<td>"+c.pageManger.list[j].data +"</td>" +
                    "<td><a href='#'>编辑</a></td>" +
                    "<td><a href='#'>删除</a></td>" +
                    "</tr>";
            }
            str+="<tr><td colspan='6'>"+"第"+c.pageManger.currentPage+"页"+"&nbsp;"+"共"+c.pageManger.totalPage+"页"
            $("#ta").append(str);
            var us="${requestScope.rights.quanxian}";
            var arr=new Array();
            var arr1=new Array();
            Array.from(document.getElementsByClassName("pageContent")).forEach((item)=>{
                var arr1=item.getElementsByTagName("td");
                for(let i=0;i<arr1.length;i++){
                    arr.push(arr1[i]);
                }
            })
            bianjiBlog(us,arr,arr1,c.pageManger.currentPage);
            deleteBlog(us,arr,arr1);
            currentpage=c.pageManger.currentPage;
            totalpage=c.pageManger.totalPage;
        },false);
    }
    function opertaBlogPage(){
        $("body").on("click","#nextBlogPage",function () {
            if(currentpage!=totalpage){
                addBlogtable(currentpage+1);
            }
        });
        $("body").on("click","#forwardBlog",function () {
            if(currentpage!=1){
                addBlogtable(currentpage-1);
            }
        });
        $("body").on("click","#firstBlog",function () {
            if(currentpage!=1){
                addBlogtable(1);
            }
        });
        $("body").on("click","#totalBlog",function () {
            if(currentpage!=totalpage){
                addBlogtable(totalpage);
            }
        });
    }
    function bianjiBlog(us,arr,arr1,current) {
        for(let i=0;i<arr.length;i++){
            for(let j=1;j<arr.length/6+1;j++){
                if(i==(6*j-2)){
                    arr[i].addEventListener("click",()=>{
                        twoajax("../PageMangerServlet","../html/WriteBlog.html",current,null,(c)=>{
                            $("#bt").val(c.pageManger.list[j-1].biaoTi);
                            $(".editormd-markdown-textarea").html(c.pageManger.list[j-1].context)
                        })
                    })
                }
            }
        }
    }
    function deleteBlog(us,arr,arr1) {
        for(let i=0;i<arr.length;i++){
            for(let j=1;j<arr.length/6+1;j++){
                if(i==(6*j-1)){
                    arr[i].addEventListener("click",()=>{
                        if(us=="超级管理员"){
                            if(confirm("确定要删除该文章吗？")){
                                let id=arr[i].parentNode.firstChild.nextSibling.innerHTML;
                                console.log(id)
                                $.ajax({
                                    url:"../deleteBlogServlet",
                                    type:"post",
                                    datatype:"json",
                                    data:{"id":id},
                                    async:true,
                                    success:function (data) {
                                        let c=JSON.parse(data);
                                        console.log(c)
                                        if(c.deleteBlog==true){
                                            alert("删除成功");
                                            addBlogtable(1);
                                        }else{
                                            console.log("删除失败");
                                        }
                                    }
                                })
                            }
                        }else{
                            alert("您不是超级管理员，没有权限删除博客")
                        }
                    })
                }
            }
        }
    }
    $(document).ready(function () {
        opertaUserPage();
        opertaBlogPage();
        $("#User").click(function () {
            addUsertable(1);
        });
        $("#writeblog").click(function () {
            $.ajax({
                url:"../html/WriteBlog.html",
                type:"post",
                dataType:"html",
                success:function (data) {
                    $("#article1").html(data);
                }
            });
        });
        $("#bloglist").click(function () {
            addBlogtable(1);
        });
        $(".dh_photo").click(function () {
            let username="${requestScope.rights.username}";
            twoajax("../peopleServlet","../html/people.html",1,username,(c)=>{
                $("#username").html(c.people.username);
                $("#password").val(c.people.password);
                $("#email").val(c.people.email);
                $("#pto").src=c.people.path;
            })
        })
        $("#addUser").click(function () {
            var Us="${requestScope.rights.quanxian}";
            if(Us=="超级管理员"){
                $.ajax({
                    url:"../html/addUser.html",
                    type:"post",
                    dataType:"html",
                    success:function (data) {
                        $("#article1").html(data);
                    }
                });
            }else{alert("您不是超级管理员，没有权限进行该操作")}

        })
    });
</script>
</html>
