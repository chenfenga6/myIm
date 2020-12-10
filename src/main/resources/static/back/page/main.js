layui.config({base:"../js/"}).extend({"myApi":"myApi"});
layui.use(['form','layer','table','laytpl','element','myApi','layim'],function(){
    var form = layui.form, layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery, laytpl = layui.laytpl, table = layui.table, element = layui.element,myApi=layui.myApi,layim=layui.layim;
    /*********************初始化*********************/
    let tim;
    let global_sdkAppID = null;
    let global_userSig = null;
    let global_userId  = window.sessionStorage.getItem("session_userId");

    let MyMethod = function() {};   //声明对象
    MyMethod.prototype={
      getUserSign:function(userId){
        myApi.postAjax(serverPath+"/tx/getUserSig",false,{userId:userId},function(res){   
          console.log(res);
          if(res.code === response_success_code){
            global_sdkAppID = res.data.sdkAppID;
            global_userSig = res.data.userSig;
          }        
        },null);
      }
    };
    let my = new MyMethod();        //实例化对象


    // my.getUserSign(global_userId);
    // if(global_sdkAppID != null && global_userSig!=null){
    //   let options = { SDKAppID:global_sdkAppID };
    //   tim = TIM.create(options);
    //   tim.setLogLevel(0);
    //   tim.registerPlugin({'cos-js-sdk': COS});
    //   tim.on(TIM.EVENT.SDK_READY, function(event) {
    //     // 收到离线消息和会话列表同步完毕通知，接入侧可以调用 sendMessage 等需要鉴权的接口
    //     // event.name - TIM.EVENT.SDK_READY
    //   });
    //
    //   tim.on(TIM.EVENT.MESSAGE_RECEIVED, function(event) {
    //     // 收到推送的单聊、群聊、群提示、群系统通知的新消息，可通过遍历 event.data 获取消息列表数据并渲染到页面
    //     // event.name - TIM.EVENT.MESSAGE_RECEIVED
    //     // event.data - 存储 Message 对象的数组 - [Message]
    //   });
    //
    //   tim.on(TIM.EVENT.MESSAGE_REVOKED, function(event) {
    //     // 收到消息被撤回的通知。使用前需要将SDK版本升级至v2.4.0或以上。
    //     // event.name - TIM.EVENT.MESSAGE_REVOKED
    //     // event.data - 存储 Message 对象的数组 - [Message] - 每个 Message 对象的 isRevoked 属性值为 true
    //   });
    //
    //   tim.on(TIM.EVENT.MESSAGE_READ_BY_PEER, function(event) {
    //     // SDK 收到对端已读消息的通知，即已读回执。使用前需要将SDK版本升级至v2.7.0或以上。仅支持单聊会话。
    //     // event.name - TIM.EVENT.MESSAGE_READ_BY_PEER
    //     // event.data - event.data - 存储 Message 对象的数组 - [Message] - 每个 Message 对象的 isPeerRead 属性值为 true
    //   });
    //
    //   tim.on(TIM.EVENT.CONVERSATION_LIST_UPDATED, function(event) {
    //     // 收到会话列表更新通知，可通过遍历 event.data 获取会话列表数据并渲染到页面
    //     // event.name - TIM.EVENT.CONVERSATION_LIST_UPDATED
    //     // event.data - 存储 Conversation 对象的数组 - [Conversation]
    //   });
    //
    //   tim.on(TIM.EVENT.GROUP_LIST_UPDATED, function(event) {
    //     // 收到群组列表更新通知，可通过遍历 event.data 获取群组列表数据并渲染到页面
    //     // event.name - TIM.EVENT.GROUP_LIST_UPDATED
    //     // event.data - 存储 Group 对象的数组 - [Group]
    //   });
    //
    //   tim.on(TIM.EVENT.PROFILE_UPDATED, function(event) {
    //     // 收到自己或好友的资料变更通知
    //     // event.name - TIM.EVENT.PROFILE_UPDATED
    //     // event.data - 存储 Profile 对象的数组 - [Profile]
    //   });
    //
    //   tim.on(TIM.EVENT.BLACKLIST_UPDATED, function(event) {
    //     // 收到黑名单列表更新通知
    //     // event.name - TIM.EVENT.BLACKLIST_UPDATED
    //     // event.data - 存储 userID 的数组 - [userID]
    //   });
    //
    //   tim.on(TIM.EVENT.ERROR, function(event) {
    //     // 收到 SDK 发生错误通知，可以获取错误码和错误信息
    //     // event.name - TIM.EVENT.ERROR
    //     // event.data.code - 错误码
    //     // event.data.message - 错误信息
    //   });
    //
    //   tim.on(TIM.EVENT.SDK_NOT_READY, function(event) {
    //     // 收到 SDK 进入 not ready 状态通知，此时 SDK 无法正常工作
    //     // event.name - TIM.EVENT.SDK_NOT_READY
    //   });
    //
    //   tim.on(TIM.EVENT.KICKED_OUT, function(event) {
    //     // 收到被踢下线通知
    //     // event.name - TIM.EVENT.KICKED_OUT
    //     // event.data.type - 被踢下线的原因，例如 :
    //     //   - TIM.TYPES.KICKED_OUT_MULT_ACCOUNT 多实例登录被踢
    //     //   - TIM.TYPES.KICKED_OUT_MULT_DEVICE 多终端登录被踢
    //     //   - TIM.TYPES.KICKED_OUT_USERSIG_EXPIRED 签名过期被踢（v2.4.0起支持）。
    //   });
    //
    //   tim.on(TIM.EVENT.NET_STATE_CHANGE, function(event) {
    //     // 网络状态发生改变（v2.5.0 起支持）。
    //     // event.name - TIM.EVENT.NET_STATE_CHANGE
    //     // event.data.state 当前网络状态，枚举值及说明如下：
    //     //   - TIM.TYPES.NET_STATE_CONNECTED - 已接入网络
    //     //   - TIM.TYPES.NET_STATE_CONNECTING - 连接中。很可能遇到网络抖动，SDK 在重试。接入侧可根据此状态提示“当前网络不稳定”或“连接中”
    //     //   - TIM.TYPES.NET_STATE_DISCONNECTED - 未接入网络。接入侧可根据此状态提示“当前网络不可用”。SDK 仍会继续重试，若用户网络恢复，SDK 会自动同步消息
    //   });
    //   // 开始登录
    //   tim.login({userID:global_userId, userSig:global_userSig});
    // }
    


    layim.config({
        //获取主面板列表信息
        init: {
            url:serverPath+'/layim/init'
            ,type:'post'
            //额外参数
            ,data:{userId:global_userId}
        } 
        //获取群员接口（返回的数据格式见下文）
        ,members: {
          url: '' //接口地址（返回的数据格式见下文）
          ,type: 'get' //默认get，一般可不填
          ,data: {} //额外参数
        }
        //上传图片接口（返回的数据格式见下文），若不开启图片上传，剔除该项即可
        ,uploadImage: {
          url: '' //接口地址
          ,type: 'post' //默认post
        } 
        //上传文件接口（返回的数据格式见下文），若不开启文件上传，剔除该项即可
        ,uploadFile: {
          url: '' //接口地址
          ,type: 'post' //默认post
        }
        //扩展工具栏，下文会做进一步介绍（如果无需扩展，剔除该项即可）
        ,tool: [{
          alias: 'code' //工具别名
          ,title: '代码' //工具名称
          ,icon: '&#xe64e;' //工具图标，参考图标文档
        }]
        ,msgbox: layui.cache.dir + 'css/modules/layim/html/msgbox.html' //消息盒子页面地址，若不开启，剔除该项即可
        ,find: layui.cache.dir + 'css/modules/layim/html/find.html' //发现页面地址，若不开启，剔除该项即可
        ,chatLog: layui.cache.dir + 'css/modules/layim/html/chatlog.html' //聊天记录页面地址，若不开启，剔除该项即可
        ,title: "即时通讯"
        ,minRight: '200px'
        ,right:'300px'
        ,bottom:'300px'
        ,copyright:true
    })
});
