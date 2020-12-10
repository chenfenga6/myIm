layui.config({base:"./js/"}).extend({"myApi":"myApi"});
layui.use(['form','layer','table','laytpl','element','myApi'],function(){
    var form = layui.form, layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery, laytpl = layui.laytpl, table = layui.table, element = layui.element,myApi=layui.myApi;
    /*********************初始化*********************/

    let MyMethod = function() {};   //声明对象
    MyMethod.prototype={
        login:function (loginId,pwd) {
            myApi.postAjax(serverPath+"/user/login",true,{loginId:loginId,pwd:pwd},function (res) {
                if (res.code === response_success_code){
                    layer.msg("登录成功！");
                    window.sessionStorage.setItem("session_userId",res.data.userId);
                    setTimeout(function () {
                        window.location.href="./page/main.html";
                    },1000);
                }else {
                    layer.msg(res.msg);
                }
            },null);
        }
    };
    let my = new MyMethod();        //实例化对象


    /**
     *  监听：登录按钮
     */
    form.on('submit(loginBtn)',function(data){
        my.login(data.field.loginName,data.field.loginPwd);
        return false;
    });
});
