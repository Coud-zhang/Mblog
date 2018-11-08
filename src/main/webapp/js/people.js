function check(){
    $(".tjxg").click(function () {
        var testpassword= /^[a-zA-Z0-9_-]{4,16}$/;
        var testemail=/^([a-zA-Z0-9._-])+@([a-zA-Z0-9_-])+(\.[a-zA-Z0-9_-])+/;
        let password= $("#password").val();
        let email=$("#email").val();
        if(testpassword.test(password)&&testemail.test(email)){
            $.ajax({
                url:"../updateUserServlet",
                data:{"username":$("#username").html(),"password": password,"email": email},
                type:"post",
                datatype:"json",
                async:true,
                success:function (data) {
                    let c=JSON.parse(data);
                    if(c.flag==true){
                        alert("修改成功");
                    }else{
                        console.log("修改失败")
                    }
                }
            })
        }else{
            $(".Testpassword").html("密码至少6-12位且必须包含字母数字");
            $(".Testemail").html("请检查邮箱格式");
        }
    })
}
$(document).ready(function () {
   check();
})
