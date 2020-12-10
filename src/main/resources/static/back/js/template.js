layui.config({base:"../../js/"}).extend({"myApi":"myApi"});
layui.use(['form','layer','table','laytpl','element','myApi'],function(){
    var form = layui.form, layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery, laytpl = layui.laytpl, table = layui.table, element = layui.element,myApi=layui.myApi;
    /*********************初始化*********************/

    let MyMethod = function() {};   //声明对象
    MyMethod.prototype={
    };
    let my = new MyMethod();        //实例化对象
});
