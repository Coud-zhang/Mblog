var testEditor;
$(function() {
    testEditor =editormd("insert", {
        width:"73%",
        height:"400px",
        syncScrolling : "single",
        path: "../editormd/lib/",
        saveHTMLToTextarea : true,//后端要想获得第二个textarea中的值，首先需要打开editor.md的saveHTMLToTextarea : true设置
        flowChart : true,
        /**上传图片相关配置如下*/
        imageUpload : true,
        imageFormats : ["jpg", "jpeg", "gif", "png", "bmp", "webp"],
        imageUploadURL : "../upload",//注意你后端的上传图片服务地址即服务器的映射

    });
});