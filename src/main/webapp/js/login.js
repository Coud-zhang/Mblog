function checkNameAndPassWord(){
    let submit=document.getElementById("submit");
    submit.addEventListener("click",(event)=>{
        let name=document.getElementById("username").value;
        let password=document.getElementById("password").value;
        let tishi=document.getElementById("tishi");
        var re= /^[a-zA-Z0-9_-]{4,16}$/;
        if(re.test(name)&&re.test(password)){
                     console.log("登录成功");
        }else {
            tishi.style.cssText="display : block";
            tishi.innerText="用户名或密码错误,请重新输入"
            event.preventDefault();
        }
    },false);
}
function  init() {
    checkNameAndPassWord();
}
window.addEventListener("load",init,false);