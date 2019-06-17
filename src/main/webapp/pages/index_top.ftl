<script type="text/javascript" src="user.jsx"></script>
<script type="text/javascript" src="layui/layui.all.js"></script>
<link rel="stylesheet" href="layui/css/layui.css" media="all"/>
<link rel="stylesheet" href="static/css/index_top.css"/>

<div class="top">
    <ul class="layui-nav" lay-filter="demo">
        <li class="layui-nav-item" style="position: absolute; left: 140px">
            <a href="index.html">首页</a>
        </li>
        <li class="layui-nav-item" style="margin-right: 15px">
            <input type="text" placeholder="在此处搜索博客" class="antistop">
            <button onclick="T.findArticle()"> 搜索 </button>
        </li>
        <li class="layui-nav-item">
            <a href="article/issue.html">写博客</a>
        </li>
        <li class="layui-nav-item">
            <a href="ax/leave.html">留言</a>
        </li>
        <li class="layui-nav-item">
            <a>关于</a>
        </li>
        <li class="layui-nav-item">
            <a href="user/index">个人中心<span class="layui-badge-dot"></span></a>
        </li>
        <li class="layui-nav-item login" style="display: none" lay-unselect="">
            <a>
                <img src="static/img/ph.png" class="layui-nav-img">
                <label class="top-username"></label>
            </a>
            <dl class="layui-nav-child">
                <dd style="text-align: center"><a href="login.out">退出</a></dd>
            </dl>
        </li>

        <li class="layui-nav-item loginOut" lay-unselect="">
            <a style="padding-right: 10px; padding-left: 10px; cursor: pointer" href="login.html">登录</a>
        </li>
        <li class="layui-nav-item loginOut" lay-unselect="">
            <a style="padding-right: 10px; padding-left: 10px; cursor: pointer" href="register.html">注册</a>
        </li>
    </ul>
</div>

<script>
    var T = {};
    T.findArticle = function () {
        var antistop = $('.top .antistop').val().trim();
        if(antistop == null || antistop.length < 1){
            layer.msg('请输入关键词');
            return;
        }
        location.href = "article/find/top/" + antistop;
    }
    if(user != null)
    {
        $('.top .loginOut').hide();
        $('.top .login').show();
        $('.top .layui-nav-img').attr("src", user.head_portrait);
        $('.top .top-username').text(user.username);
    }
    else
    {
        $('.top .loginOut').show();
        $('.top .login').hide();
    }
    layui.use('element', function(){
        var element = layui.element;

        //一些事件监听
        element.on('tab(demo)', function(data){
            console.log(data);
        });
        element.init();
        element.render('nav');
    });
</script>