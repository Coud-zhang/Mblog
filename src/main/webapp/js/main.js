function operationLi(){
    let img=document.getElementById("header_img");
    let search=document.getElementById("header_search");
    window.addEventListener("click",(event)=>{
        let node=event.target;
        if(node==img){
            search.style.cssText="width: 200px;";
            search.focus();
        }
        else if(!(search==document.activeElement)){
            search.style.cssText="width: 0px;";
        }
    },false);
}
function init() {
    operationLi();
}
window.addEventListener("load",init,false);