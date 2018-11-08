function  operationphoto() {
    let photo=document.getElementById("daohang_photo");
    photo.addEventListener("click",()=>{
        window.location.href="../index.jsp";
    },false);
}
function operationLi(event){
    let node=event.target;
    if(node.className=='level1_li'){
        let o=node.nextElementSibling;
        if(o.hidden==true){
            o.hidden=false;
        }else{
            o.hidden=true;
        }
    }
}

function init() {
    operationphoto();
    let ul=document.querySelectorAll(".level1_ul")[0];		//获取第一级ul，获取时返回的是数组，由于确定只有一个，所以直接取第一个。
    ul.addEventListener("click",operationLi,false);
}
window.addEventListener("load",init,false);
