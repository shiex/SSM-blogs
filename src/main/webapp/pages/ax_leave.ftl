<!DOCTYPE html>
<html lang="en">
<head>
    <title></title>
    <base href="${ctxPath}">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <script type="text/javascript" src="static/js/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="static/js/template-web.js"></script>
    <script type="text/javascript" src="static/js/afquery.js"></script>
    <link rel="stylesheet" href="static/css/index_top.css">

    <style>
        .leave-index {
            width: 1100px;
            margin: 0px auto;
            margin-top: 2px;
        }

        .leave-index #leave-top {
            height: 160px;
            width: 1100px;
        }

        #leave-top .top-img {
            width: 100%;
            height: 150px;
            z-index: 1000;
        }

        .top-img img {
            width: 100%;
            height: 100%;
        }
        #leave-top .leave-bt{
            text-align: right;
            padding-right: 40px;
            margin-top: 20px;
            width: 100%;
        }
        #leave-top .leave-bt button{
            border-radius: 4px;
            padding: 8px 4px;
            width: 90px;
            border: 1px solid #998eaf;
            cursor: pointer;
            background-color: #eeeeee;
            box-shadow: 1px 1px 1px #C2BE9E;
            color: #444;
        }
        #leave-top .leave-bt button:hover{
            background-color: #ced657;
        }
        .leave-index .leave-con {
            width: 900px;
            margin: 0px auto;
            margin-top: 10px;
            padding-bottom: 50px;
            min-height: 550px;
        }

        .leave-con .cont {
            padding: 10px 30px;
            min-height: 50px;
            position: relative;
            border-bottom: 1px dashed #C2BE9E;
        }

        .cont .cont-img {
            display: inline-block;
            position: absolute;
            top: 5px;
            left: 35px;
            margin-top: 5px;
            width: 50px;
            height: 50px;
        }

        .cont-img img {
            width: 100%;
            vertical-align: middle;
            height: 100%;
        }

        .cont .cont-text {
            display: inline-block;
            margin-left: 70px;
            display: tabel-cell;
            vertical-align: middle;
            line-height: 25px;
        }

        .cont .cont-bottom {
            margin-top: 10px;
            text-align: right;
        }
        .leave-dig{
            position: fixed;
            top: 0px;
            bottom: 0px;
            left: 0px;
            right: 0px;
            background:rgba(0,0,0,0.5);
            z-index: 1000;
            display: none;
        }
        .leave-dig .form{
            background-color: #ffffff;
            width: 800px;
            padding: 30px 18px;
            height: 330px;
            margin: 0px auto;
            margin-top: 130px;
        }
        .form textarea{
            width: 780px;
            height: 280px;
            padding: 10px 10px;
            font-size: 18px;
        }
        .leave-dig .form-bt{
            text-align: center;
            margin-top: 10px;
        }
        .leave-dig .form-bt button{
            background-color: #C2BE9E;
            border: 1px solid #7b7b71;
            cursor: pointer;
            width: 70px;
            padding: 4px 8px;
            border-radius: 8px;
            color: #ffffff;
        }
        .leave-dig .form-bt button:hover{
            background-color: #6b77b9;
        }
        .leave-index .load-text{
            width: 100%;
            text-align: center;
            font-size: 22px;
            color: #b3ae86;
            border-top: 1px solid #C2BE9E;
            padding-top: 40px;
            padding-bottom: 60px;
            display: none;
        }
        .leave-index .load-text .text{
            cursor: pointer;
        }
        .leave-index .load-text .text:hover{
            color: #7aa4a9;
        }
    </style>
</head>
<body>

<#include "index_top.ftl">

<div class="leave-index">
    <div id="leave-top">
        <div class="top-img">
            <span>
                <img src="static/img/t1.jpg">
            </span>
        </div>
        <div class="leave-bt">
            <button onclick="M.showLeaveDig()">点击留言</button>
        </div>
    </div>
    <div class="leave-con">

    </div>
    <div class="load-text text1">
        <label class="text" onclick="M.loadLeave()" id="0">加载更多留言</label>
    </div>
    <div class="load-text text2">
        <label class="text">已加载完所有留言</label>
    </div>
</div>
<div class="leave-dig">
    <div class="form">
        <div>
            <textarea placeholder="想对作者说些什么呢" class="textarea"></textarea>
        </div>
        <div class="form-bt">
            <button onclick="M.leaveAdd()">确定</button>
            <button onclick="M.hideLeaveDig()">取消</button>
        </div>
    </div>
</div>
</body>
<script type="text/html" id="tmp-leave">
    {{each leaves as leave i}}
    <div class="cont">
        <div class="cont-img">
            <img src="{{leave.head_portrait}}">
        </div>
        <div class="cont-text">
            {{leave.content}}
        </div>
        <div class="cont-bottom">
            <label style="margin-right: 15px;color: #908e82;">
                #   {{leave.id}}楼
            </label>
            <label style="color: #297fa0; margin-right: 10px">
                {{leave.username}}
            </label>
            <label style="color: #908e82;">
                留言时间：{{leave.leave_time}}
            </label>
        </div>
    </div>
    {{/each}}
</script>
<script>

    var M = {};

    M.showLeaveDig = function(){
        $('.leave-dig .textarea').val('');
        $('.leave-dig').show();
    }

    M.hideLeaveDig = function(){
        $('.leave-dig').hide();
    }

    M.leaveAdd = function(){
        var req = {};
        req.content = $('.leave-dig .textarea').val();
        if(req.content.length < 1 || req.content == null){
            layer.msg('请先输入留言内容');
            return;
        }
        if(req.content.length > 1000){
            layer.msg('留言内容字数上限为1000哦');
            return;
        }
        Af.rest('ax/leave.add', req, function (data) {
            var text = $('.leave-index .text1 .text');
            var id = $(text).attr('id');
            if(id <= 0){
                data.forEach(function (e) {
                    e.leave_time = timestampToTime(e.leave_time);
                });
                var leaveData = {
                    leaves:data
                };
                var leaveHtml = template('tmp-leave',leaveData);
                $('.leave-con').append(leaveHtml);
            }
            layer.msg('叮咚!作者已收到你的留言');
            M.hideLeaveDig();
        });
    }

    M.loadLeave = function(){
        var text = $('.leave-index .text1 .text');
        var id = $(text).attr('id');
        Af.rest('ax/leave.load', Number(id), function (data) {
            if(data.leaves.length > 0){
                data.leaves.forEach(function (e) {
                    e.leave_time = timestampToTime(e.leave_time); // 将时间戳转日期
                });
                if(data.leaves.length >= 50){
                    $(text).attr('id',data.endId);
                    $('.text1').show();
                    $('.text2').hide();
                }else {
                    $(text).attr('id',0);
                    $('.text2').show();
                    $('.text1').hide();
                }
            }
            var leaveData = {
                leaves:data.leaves
            };
            var leaveHtml = template('tmp-leave',leaveData);
            $('.leave-con').append(leaveHtml);
        });
    }

    M.loadLeave();

    window.onload = function () {
            var oDiv = document.getElementById("leave-top"),
                H = 0,
                Y = oDiv
            while (Y) {
                H += Y.offsetTop;
                Y = Y.offsetParent;
            }
            window.onscroll = function () {
                var s = document.body.scrollTop || document.documentElement.scrollTop
                if (s > H) {
                    oDiv.style = "position:fixed; top:0;z-index: 100;"
                } else {
                    oDiv.style = ""
                }
            }
        }

    // 时间戳转日期
    function timestampToTime(timestamp) {
        var date = new Date(timestamp);//时间戳为10位需*1000，时间戳为13位的话不需乘1000
        if(timestamp.length == 10){
            date = new Date(timestamp * 1000);
        }
        var Y = date.getFullYear() + '-';
        var M = (date.getMonth()+1 < 10 ? '0'+(date.getMonth()+1) : date.getMonth()+1) + '-';
        var D = (date.getDate() < 10 ? '0'+date.getDate() : date.getDate()) + ' ';
        var h = (date.getHours() < 10 ? '0'+date.getHours() : date.getHours()) + ':';
        var m = (date.getMinutes() < 10 ? '0'+date.getMinutes() : date.getMinutes()) + ':';
        var s = (date.getSeconds()< 10 ? '0'+date.getSeconds() : date.getSeconds());
        return Y+M+D+h+m+s;
    }
</script>
</html>
