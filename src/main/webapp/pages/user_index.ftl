<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
        "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title></title>
    <base href="${ctxPath}">
    <script type="text/javascript" src="static/js/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="static/js/template-web.js"></script>
    <script type="text/javascript" src="static/js/afquery.js"></script>

    <style>
        html,body{
            -webkit-font-smoothing: antialiased;
        }
        body{
            padding: 0;
            margin: 0;
            position: relative;
            font-family: "SF Pro Display",Roboto,Noto,Arial,"PingFang SC","Hiragino Sans GB","Microsoft YaHei",sans-serif;
            font-size: 14px;
            line-height: 1.57142857;
            background-color: #f5f6f7;
            color: #333;
            min-height: 600px;
            min-width: 1200px;
        }
        .index{
            position: relative;
            margin: 0px auto;
            margin-top: 10px;
            width: 1250px;
            min-height: 545px;
        }
        .index .left {
            position: relative;
            width: 200px;
            height: 450px;
            display: inline-block;
            margin-left: 20px;
        }
        .left .layui-nav{
            position: absolute;
            width: 100%;
            height: 100%;
            display: inline-block;
        }
        .index .load-content{
            position: absolute;
            left: 230px;
            height: 100%;
            width: 1000px;
            display: inline-block;
        }
        .left .layui-nav-item{
            cursor: pointer;
        }
        .layui-nav-item-class{
            background-color: #8a71b7;
        }
    </style>
</head>
<body>
<#include "index_top.ftl">

<div class="index">
<div class="left">
    <ul class="layui-nav layui-nav-tree layui-nav-tree layui-nav-side"
        lay-filter="test">
        <li class="layui-nav-item">
            <a page="pages/user_data.ftl" class="u-a">个人资料</a>
        </li>
        <li class="layui-nav-item">
            <a page="pages/user_article.ftl" class="u-a">博客管理</a>
        </li>
        <li class="layui-nav-item">
            <a page="pages/user_collect.ftl" class="u-a">我的收藏</a>
        </li>
        <li class="layui-nav-item">
            <a page="pages/user_follow.ftl" class="u-a">查看关注</a>
        </li>
        <li class="layui-nav-item">
            <a page="pages/user_fans.ftl" class="u-a">查看粉丝</a>
        </li>
        <li class="layui-nav-item">
            <a page="pages/user_page.ftl" class="u-a">编辑主页</a>
        </li>
    </ul>
</div>
<div class="load-content">

</div>
</div>
<script>
    var M = {};
    M.loadContent = function (page) {
        Af.loadPage('.load-content',page);
        window.location.hash = "#" + page;
    }

    // 默认为加载用户个人资料页面
    if(location.hash != null && location.hash.length > 0){
        var page = location.hash.substr(1);
        M.loadContent(page);
    }else {
        M.loadContent("pages/user_data.ftl");
    }

    $('.left .u-a').click(function () {
        var page = $(this).attr('page');
        M.loadContent(page);
    });

    M.selectCalss = function (text) {
        var item_a = $('.u-a');
        $(item_a).each(function () {
           var aText = $(this).text();
           if(aText == text){
               $(this).parent().addClass('layui-nav-item-class');
           }else {
               $(this).parent().removeClass('layui-nav-item-class');
           }
        });
    }
</script>
</body>
</html>