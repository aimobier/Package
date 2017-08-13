// 对Date的扩展，将 Date 转化为指定格式的String
// 月(M)、日(d)、小时(h)、分(m)、秒(s)、季度(q) 可以用 1-2 个占位符，
// 年(y)可以用 1-4 个占位符，毫秒(S)只能用 1 个占位符(是 1-3 位的数字)
// 例子：
// (new Date()).Format("yyyy-MM-dd hh:mm:ss.S") ==> 2006-07-02 08:09:04.423
// (new Date()).Format("yyyy-M-d h:m:s.S")      ==> 2006-7-2 8:9:4.18
Date.prototype.Format = function (fmt) { //author: meizz
    var o = {
        "M+": this.getMonth() + 1, //月份
        "d+": this.getDate(), //日
        "h+": this.getHours(), //小时
        "m+": this.getMinutes(), //分
        "s+": this.getSeconds(), //秒
        "q+": Math.floor((this.getMonth() + 3) / 3), //季度
        "S": this.getMilliseconds() //毫秒
    };
    if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    for (var k in o)
        if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
    return fmt;
}


/// 创建一个 连接器对象
var stompClient = null;


// create connection successful block
function connectionSuccess(info) {
    sendMessage("连接成功"+info);

    $("a").remove();

    stompClient.subscribe('/topic/greetings', function (greeting) {
        sendMessage(greeting);
    });
}

// create connection faillful block
function connectionFail(error) {

    var alinkString = "<a href=\"javascript:void(0);\" onclick=\"connect()\">点击重连</a>";

    sendMessage("连接失败"+error+alinkString);
}

// connection to service socket
function connect() {
    var socket = new SockJS('/gs-guide-websocket');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, connectionSuccess,connectionFail);
}


$(document).ready(function () {

    connect(); // 链接 Socker

    sendMessage("欢迎来到 IOS 一键式 应用控制台");
});

/// dis connection by self
function selfdisconnect() {
    if (stompClient != null) {
        stompClient.disconnect();
    }
}

function sendMessage(message) {

    var head = "root@"+new Date().Format("yy/MM/dd hh:mm:ss")+":~$  ";

    var headStrin = "<span style='color: #1cc09f;'>" + head + "</span>";

    $('#screen').append("<p class=\"font\">" + headStrin + message + "</p>");

    $('#screen').animate({scrollTop: $('#screen').prop("scrollHeight")}, 10);
}