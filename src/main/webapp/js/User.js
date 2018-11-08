function opertacheckbox() {
    document.getElementById("selectallUser").addEventListener("click",()=>{
        Array.from(document.getElementsByClassName("user")).forEach((item)=>{
            if(item.checked==false){
                item.checked=true;
                document.getElementById("selectallUser").innerHTML="全不选";
            }else{
                item.checked=false;
                document.getElementById("selectallUser").innerHTML="全选";
            }
        });
    });
}
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
function search(keyword) {
    twoajax("../SelectPageServlet","../html/selectUser.html",1,keyword,(c)=>{
        console.log(c);
        var str ="";
        for(var j=0;j<c.selectPage.list.length;j++){
            str +="<tr>" +
                "<td>"+"<input type='checkbox'>"+ "</td>" +
                "<td>" +c.selectPage.list[j].username +"</td>" +
                "<td>" +c.selectPage.list[j].password+"</td>" +
                "<td>"+c.selectPage.list[j].email +"</td>" +
                "<td>" +c.selectPage.list[j].path+"</td>" +
                "</tr>";
        }
        str+="<tr><td colspan='5'>"+"第"+c.selectPage.currentPage+"页"+"&nbsp;"+"共"+c.selectPage.totalPage+"页"
        $("#ta").append(str);
        $("body").on("click","#selectUsernextpage",function () {
            if(c.selectPage.currentPage!=c.selectPage.totalPage){
                search(c.selectPage.currentPage+1);
            }
        });
        $("body").on("click","#selectUserforward",function () {
            if(c.selectPage.currentPage!=1){
                search(c.selectPage.currentPage-1);
            }
        });
        $("body").on("click","#selectUserfirst",function () {
            if(c.selectPage.currentPage!=1){
                search(1);
            }
        });
        $("body").on("click","#selectUsertotal",function () {
            if(c.selectPage.currentPage!=c.selectPage.totalPage){
                search(c.selectPage.totalPage);
            }
        });
    })
}
$(document).ready(function () {
    opertacheckbox();
    $("body").on("click","#search_button",function () {
        let text=$("#search_text").val();
        search(text);
    })
})
