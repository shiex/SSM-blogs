
<style>
    .load-content .user-article{
        min-height: 545px;
        background-color: #ffffff;
        width: 100%;
        padding-bottom: 45px;
        position: relative;
        margin-bottom: 15px;
    }
    .user-article .a-top{
        height: 50px;
        font-size: .75em;
        color: #333;
        line-height: 1.5em;
        background: #fff;
        box-shadow: 0 2px 4px 0 rgba(0,0,0,.05);
        width: 100%;
        box-sizing: border-box;
        -moz-box-sizing: border-box;
        -webkit-box-sizing: border-box;
        padding-top: 4px;
        padding-left: 27px;
    }
    .user-article .a-top .my-blog{
        font-family: "楷体";
        font-size: 28px;
        display: inline-block;
        line-height: 40px;
    }
    .a-top .in-but{
        width: 500px;
        position: absolute;
        right: 25px;
        display: inline-block;
        text-align: right;
    }
    .a-top .in-but input{
        border-radius: 4px;
        border: 1px solid #888888;
        height: 30px;
        margin-top: 5px;
        padding-left: 5px;
        width: 300px;
        background-color: #ffffff;
    }
    .a-top .in-but button{
        padding: 4px 4px;
        width: 50px;
        background-color: #eeeeee;
        border: 1px solid #888888;
        cursor: pointer;
    }
    .user-article .article{
        width: 100%;
        min-width: 545px;
        margin-top: 10px;
    }
    .article .u-article{
        position: relative;
        border-bottom: 1px solid #ceaeae;
        padding-bottom: 10px;
        padding-left: 20px;
        margin: 0px 10px;
        margin-top: 1px;
        padding-top: 3px;
        margin-bottom: 10px;
    }
    .u-article .title{
        height: 35px;
        line-height: 40px;
        font-size: 16px;
        margin-bottom: 3px;
    }
    .u-article .title h3{
        cursor: pointer;
        display: inline-block;
        width: 700px;
    }
    .u-article .title .st{
        line-height: 30px;
        display: inline-block;
    }
    .u-article .title .st .stick{
        line-height: 30px;
        color: #127ca5;
        font-size: 20px;
        border-right: 1px solid #8a71b7;
        display: inline-block;
        padding-right: 10px;
        margin-right: 5px;
        padding-left: 4px;
    }
    .u-article .button{
        width: 200px;
        position: absolute;
        right: 15px;
        display: inline-block;
        top: 15px;
        text-align: right;
    }
    .u-article .button button{
        border: 1px solid #888888;
        background-color: #eeeeee;
        padding: 2px 4px;
        cursor: pointer;
        border-radius: 4px;
    }
    .u-article .u-time{
        width: 100%;
        margin-left: 5px;
    }
    .u-article .u-time label{
        color: #8D8D8D;
    }
    .user-article #paging{
        position: absolute;
        bottom: 8px;
        width: 100%;
        padding-left: 35px;
    }
    #paging .layui-laypage{
        margin: 0px;
    }
</style>

<div class="user-article">
    <div class="a-top">
        <div class="my-blog">我的博客</div>
        <div class="in-but">
            <input type="text" class="findInput" placeholder="搜索我的博客"/>
            <button onclick="M.findUserArticle()"> 搜索</button>
            <button onclick="M.initArticle()" style="width: 80px; margin-left: 10px">显示全部</button>
        </div>
    </div>
    <div class="article">

    </div>
    <div id="paging">
    </div>
</div>

<script type="text/html" id="tmp-article">
    {{each articles as article}}
    <div class='u-article'>
        <div class='title'>
            <div class="st">
                {{if article.stick}}
                    <div class="stick">置顶</div>
                {{/if}}
            </div>
            <h3 onclick="M.readArticle({{article.id}})">{{article.title}}</h3>
        </div>
        <div class='button'>
            <button onclick='M.editArticle({{article.id}})'>编辑</button>
            <button onclick='M.removeArticle(this,{{article.id}})'>删除</button>
            {{if article.stick}}
                 <button onclick='M.stick(this,{{article.id}})' isStick="1"
                    style="width: 70px;">取消置顶</button>
            {{else}}
                 <button onclick='M.stick(this,{{article.id}})' isStick="0" style="width: 70px">置顶</button>
            {{/if}}
        </div>
        <div class='u-time'>
            <label>{{article.issue_time}}</label>
            <label style='margin-left: 15px;'>阅读数：{{article.read_count}}</label>
        </div>
    </div>
    {{/each}}
</script>

<script>

    var pagingData = {};  // 记录博客数据

    // 搜索用户发布博客
    M.findUserArticle = function(){
        var antistop = $('.user-article .findInput').val();
        Af.rest('article/find/user', antistop, function (data) {
            pagingData = data;
            M.initPaggin(pagingData.length);
        });
    }

    // 修改博客
    M.editArticle = function(id){
        location.href = "article/edit/" + id + ".html";
    }

    // 删除博客
    M.removeArticle = function(e, id){
        $(e).parent().parent().remove();
        Af.rest("article/remove.do", id, function (data) {
            for(var i=0; i<pagingData.length; i++){
                if(pagingData[i].id == id){
                    pagingData.splice(i,1);
                }
            }
        });
    }

    // 是否置顶
    M.stick = function(e, articleId){
        var isStick = $(e).attr('isStick'); // 判断是否为置顶
        var u_article = $(e).parent().parent();  // 获取父元素，设置置顶显示状态
        var req = {};
        req.id = articleId;
        if(isStick == 0){
            $(e).attr('isStick', 1);  // 取消置顶
            $(e).text('取消置顶');
            $('.st', u_article).html('<div class="stick">置顶</div>');
            req.stick = 1;
        }else {
            $(e).attr('isStick', 0);  // 置顶
            $(e).text('置顶');
            $('.st', u_article).html('');
            req.stick = 0;
        }
        Af.rest("article/stick",req, function (data) {

        });
    }

    // 跳转到阅读
    M.readArticle = function(articleId){
        location.href = "article/read/" + articleId + ".html";
    }

    // 初始化加载博客数据
    M.initArticle = function () {
        Af.rest("article/init", user.id, function (data) {
            data.forEach(function (e) {
                e.issue_time = timestampToTime(e.issue_time);
            });
            pagingData = data;
            M.initPaggin(pagingData.length);
        });
    }

    M.initPaggin = function (DataSize) {
        layui.use(['laypage', 'layer'], function(){
            var laypage = layui.laypage
                ,layer = layui.layer;

            //完整功能
            laypage.render({
                elem: 'paging'
                ,count: DataSize
                ,limit:10
                ,layout: ['count', 'prev', 'page', 'next', 'skip']
                ,jump: function(obj){
                    // 计算出当前页对应数据
                    var pageCount = obj.curr - 1;
                    var dataCount = 10;
                    if(pageCount > 0){
                        pageCount = pageCount * 10;
                        dataCount = pageCount + 10;
                    }
                    var data = pagingData.slice(pageCount, dataCount);
                    var articleData = {
                        articles:data
                    };
                    $('.article').empty();
                    var articleHtml = template('tmp-article',articleData);
                    $('.article').append(articleHtml);
                }
            });
        });
    }

    M.initArticle();    // 初始化加载用户发表个人博客
    M.selectCalss('博客管理');

    // 时间戳转换
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
    //# sourceURL=user_article.js
</script>


