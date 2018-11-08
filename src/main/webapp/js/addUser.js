function checkNameAndPassWord(){
    let submit=document.getElementById("submit");
    submit.addEventListener("click",()=>{
        console.log(111)
        let name=document.getElementById("username").value;
        let password=document.getElementById("password").value;
        let repassword=document.getElementById("repassword").value;
        let email=document.getElementById("email").value;
        let quanxian=document.getElementById("quanxian").value;
        var re= /^[a-zA-Z0-9_-]{4,16}$/;
        var re1=/^(\w-*\.*)+@(\w-?)+(\.\w{2,})+$/;
        let usernameFlag=false;
        let passwordFlag=false;
        let repasswordFlag=false;
        let emailFlag=false;
        if(re.test(name)){
            usernameFlag=true;
        }else{
            document.getElementById("testUserName").innerText="用户名至少4-16位且包含数字和字母,请重新输入";
        }
        if(re.test(password)){
            passwordFlag=true;
        }else{
            document.getElementById("testPassword").innerText="密码至少4-16位且包含数字和字母,请重新输入";
        }
        if(password==repassword){
            repasswordFlag=true;
        }else{
            document.getElementById("reTestpassword").innerText="两次密码不一致";
        }
        if(re1.test(email)){
            emailFlag=true
        }else{
            document.getElementById("Testemail").innerText="请检查邮箱格式";
        }
        if(usernameFlag&&passwordFlag&&repasswordFlag&&emailFlag){
            $.ajax({
                url:"../addUserServlet",
                type:"post",
                async:true,
                data:{"username":name,"password":password,"email":email,"quanxian":quanxian,"path":""},
                dataType:"json",
                success:function (data) {
                    if(data.flag==true){
                        alert("增加成功")
                    }else{
                        alert("增加失败");
                    }
                },
                error:function () {
                    alert("增加失败");
                }
            })
        }
    },false)

}
(function init() {
    checkNameAndPassWord();
})()