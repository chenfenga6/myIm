layui.define(['form','layer','table','laytpl','element','jquery'],function (exports) {
    let form = layui.form, layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery, laytpl = layui.laytpl, table = layui.table, element = layui.element;
    // 表格渲染格式
    // var dataObj={
    //         url		:	serverContentPath+"",
    //         type	:	'get',
    //         where	: {
    //             userType:global_userType,
    //             companyId:global_companyId,
    //             recipesName :global_keyword //
    //         },
    //         cols	:	[[
    //             {field: 'recipesName', title: '食谱名称', minWidth:100, align:"center"},
    //             {field: 'publishOrgan', title: '发布机构', minWidth:100, align:"center"},
    //             {field: 'productCode', title: '用料介绍', minWidth:100, align:"center"},
    //             {field: 'publishTime', title: '发布时间', minWidth:100, align:"center"}
    //         ]]
    // }

    MyApi={
        //生成表格 render
        getTable:function(elem,tabaId,dataObj){
            return table.render({
                elem: '#'+elem,
                method:dataObj.type,
                url : dataObj.url,
                request:{pageName:"start", limitName:"limit"},
                where:dataObj.where,
                headers: {'token': getCookie("token")},
                parseData:dataObj.parseData,
                // function(res){
                //     // console.log(res);
                //     return{"code":0, "msg":"", "count":res.count, "data":res.useDefPara}
                // },
                page :{layout: ['limit', 'count', 'prev', 'page', 'next']
                    ,groups: 3,first: '首页',prev: '上一页',next: '下一页',last: '尾页'
                    ,limit:5,limits:[5,10,15,20]
                },
                height : dataObj.full?dataObj.full:'full-110',
                id : tabaId,
                cols : dataObj.cols,
                done: function (res, curr, count) {
                    if (curr > 1 && res.data.length === 0) {
                        curr = curr - 1;
                        table.reload(tabaId, {
                            page: {
                                curr: curr
                            },
                            where: {
                            },
                        }, 'data');
                    }
                }
            });
        },
        skipTo : function(title,content,area,isfull,id) {
            let index = layui.layer.open({
                title: title,
                type : 2,
                shade: 0,
                content:content,
                id : id?id:null,
                area: area?area:['100%','80%'],
                success:function(layero,index){
                    layui.layer.setTop(layero); //重点2
                    setTimeout(function(){
                        layui.layer.tips('点击此处返回', '.layui-layer-setwin .layui-layer-close', {tips: 3});
                    },500)
                },
                end: function(){
                    window.sessionStorage.setItem("layerIndex","none");
                }
            });

            isfull == false?false:true;
            if (isfull){layui.layer.full(index);}
            window.sessionStorage.setItem("layerIndex",index);
            $(window).on("resize",function(){
                var aa = window.sessionStorage.getItem("layerIndex");
                if(aa =="none"){}else{layui.layer.full(aa);}
            });
        },
        skipToNotFull:function(title,content,area,successFunction){
            let index = layui.layer.open({
                title: title,
                type : 2,
                shade: 0,
                content:content,
                area: area?area:['100%','80%'],
                success:successFunction
            });
        },
        getNoAjaxTable:function(elem,tabaId,dataObj){
            return table.render({
                elem: '#'+elem,
                request:{pageName:"start", limitName:"limit"},
                // page :{layout: ['limit', 'count', 'prev', 'page', 'next']
                //     ,groups: 3,first: '首页',prev: '上一页',next: '下一页',last: '尾页'
                //     ,limit:17,limits:[5,10,17,25]
                // },
                // height : 'full-110',
                id : tabaId,
                cols : dataObj.cols,
                data: dataObj.data,
                done:function (res,curr,count) {
                    console.log("表格结束");
                    merge(res);
                }
            });
        },
       getQueryVariable: function (variable){
            var query = window.location.search.substring(1);
            var vars = query.split("&");
            for(var i = 0 ; i < vars.length ; i++){
                var pair = vars[i].split("=");
                if(pair[0] == variable){
                    return pair[1];
                }
            }
            return null;
        },
        getCookie:function(userName){
            if (document.cookie.length>0){
                c_start=document.cookie.indexOf(userName+ "=");
                if (c_start!=-1){
                  c_start=c_start + userName.length+1;
                  c_end=document.cookie.indexOf(";",c_start);
                  if (c_end==-1){ 
                      c_end=document.cookie.length;
                  }
                  return unescape(document.cookie.substring(c_start,c_end));
                }
             }
            return "";
        },
        setCookie:function(c_name,value,expiredays){
            let exdate=new Date();
            exdate.setDate(exdate.getDate()+expiredays);
            document.cookie=c_name+ "=" +escape(value)+
            ((expiredays==null) ? "" : ";expires="+exdate.toGMTString())
        },
        setCookie2:function(name,value,time,domain,path){
            let str=name+"="+escape(value);
            if(time != ""){
                let exdate=new Date();
                    exdate.setDate(exdate.getDate()+time);
                let date = exdate.toGMTString();
                str+=";expires="+date;
            }
            str=domain?str+";domain="+domain : str;
            str=path?str+';path='+serverContentPath+path :str;
            document.cookie=str;
        },
        btnClose:function (id) {
            $(id).addClass("layui-btn-disabled");
            $(id).attr('disabled', 'disabled');
        },
        btnOpen:function (id) {
            $(id).removeClass("layui-btn-disabled");
            $(id).removeAttr('disabled');
        },
        /**
         * 日期 转换为 Unix时间戳
         * @param <string> 2014-01-01 20:20:20  日期格式
         * @return <int>        unix时间戳(毫秒)
         */
        DateToUnix: function(string) {
            var f = string.split(' ', 2);
            var d = (f[0] ? f[0] : '').split('-', 3);
            var t = (f[1] ? f[1] : '').split(':', 3);
            return (new Date(
                parseInt(d[0], 10) || null,
                (parseInt(d[1], 10) || 1) - 1,
                parseInt(d[2], 10) || null,
                parseInt(t[0], 10) || null,
                parseInt(t[1], 10) || null,
                parseInt(t[2], 10) || null
            )).getTime();
        },
        postJsonAjax:function(url,isAsync,params,successFunction,token){
            if (token != null && token != ""){
                $.ajax({url:url, type:"post", async:isAsync, data:params, dataType:"json",contentType:"application/json", beforeSend: function(request) {request.setRequestHeader("token", token);}, success:successFunction});
            }else {
                $.ajax({url:url, type:"post", async:isAsync, data:params, dataType:"json",contentType:"application/json",success:successFunction});
            }
        },
        postAjax:function(url,isAsync,params,successFunction,token){
            if (token != null && token != ""){
                $.ajax({url:url, type:"post", async:isAsync, data:params, dataType:"json", beforeSend: function(request) {request.setRequestHeader("token", token);}, success:successFunction});
            }else {
                $.ajax({url:url, type:"post", async:isAsync, data:params, dataType:"json", success:successFunction});
            }
        },
        renderTableMergeNoAjax:function(elem,tableId,dataObj){
            return table.render({
                elem: '#'+elem,
                request:{pageName:"start", limitName:"limit"},
                // page :{layout: ['limit', 'count', 'prev', 'page', 'next']
                //     ,groups: 3,first: '首页',prev: '上一页',next: '下一页',last: '尾页'
                //     ,limit:17,limits:[5,10,17,25]
                // },
                // height : 'full-110',
                id : tableId,
                cols : dataObj.cols,
                data: dataObj.data,
                done:function (res,curr,count) {
                    merge(res);
                }
            });
        },
        renderTableTotalNoAjax:function(elem,tableId,dataObj){
            return table.render({
                elem: '#'+elem,
                request:{pageName:"start", limitName:"limit"},
                totalRow:true,
                id : tableId,
                cols : dataObj.cols,
                data: dataObj.data,
                done:function (res,curr,count) {}
            });
        },
        /*****************************************基础数据获取***************************************/
        /**
         * 获取所有种植标准
         */
        getAllPlantStandard:function (token,successFunction) {
            MyApi.postAjax(serverContentPathPlant+"/plantStandard/getAll",true,"",successFunction,token);
        },
        /**
         * 获取所有物料
         */
        getAllFarmMaterial:function (farmId,token,successFunction) {
            MyApi.postAjax(serverContentPathPlant+"/material/getFarmMaterial",true,{farmId:farmId},successFunction,token);
        },
        getAllFarmVarietyOrRule:function (materialId,type,token,successFunction) {
            MyApi.postAjax(serverContentPathPlant+"/material/getFarmVariety",true,{materialId:materialId,type:type},successFunction,token);
        }
    };

    /**
     * 全局拦截AJAX（判断是否登录过期）
     */
    $.ajaxSetup({
        contentType:"application/x-www-form-urlencoded;charset=utf-8",
        complete:function(XMLHttpRequest,textStatus){
            //通过XMLHttpRequest取得响应结果
            let res = XMLHttpRequest.responseText;
            try{
                let jsonData = JSON.parse(res);
                if (jsonData.hasOwnProperty("code")){
                    if (jsonData.code=="NF501"){
                        top.layer.open({
                            content: "登录过期,请重新登录！", anim: 3, btn: ['确定'], yes: function (index, layero) {
                                window.top.location.href = 'page/login/login.html';
                            }
                        });
                    }
                }
            }catch(e){
            }
        }
    });
    function merge(res) {
        var data = res.data;
        var mergeIndex = 0;//定位需要添加合并属性的行数
        var mark = 1; //这里涉及到简单的运算，mark是计算每次需要合并的格子数
        var columsName = ['costType'];//需要合并的列名称
        var columsIndex = [0];//需要合并的列索引值

        for (var k = 0; k < columsName.length; k++) { //这里循环所有要合并的列
            var trArr = $(".layui-table-body>.layui-table").find("tr");//所有行
            for (var i = 1; i < res.data.length; i++) { //这里循环表格当前的数据
                var tdCurArr = trArr.eq(i).find("td").eq(columsIndex[k]);//获取当前行的当前列
                var tdPreArr = trArr.eq(mergeIndex).find("td").eq(columsIndex[k]);//获取相同列的第一列

                if (data[i][columsName[k]] === data[i-1][columsName[k]]) { //后一行的值与前一行的值做比较，相同就需要合并
                    mark += 1;
                    tdPreArr.each(function () {//相同列的第一列增加rowspan属性
                        $(this).attr("rowspan", mark);
                    });
                    tdCurArr.each(function () {//当前行隐藏
                        $(this).css("display", "none");
                    });
                }else {
                    mergeIndex = i;
                    mark = 1;//一旦前后两行的值不一样了，那么需要合并的格子数mark就需要重新计算
                }
            }
            mergeIndex = 0;
            mark = 1;
        }
    }
    exports("myApi",MyApi);
});
