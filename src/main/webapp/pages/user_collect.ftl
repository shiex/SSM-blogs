
<style>
    .load-content .user-article{
        height: 100%;
        background-color: #ffffff;
        width: 100%;
    }
    .user-article .a-top{
        height: 50px;
        font-size: .75em;
        color: #333;
        line-height: 1.5em;
        background: #fff;
        box-shadow: 0 2px 4px 0 rgba(0,0,0,.05);
        width: 100%;
        padding: 0 28px 0 27px;
        box-sizing: border-box;
        -moz-box-sizing: border-box;
        -webkit-box-sizing: border-box;
        padding-top: 4px;
    }
    .user-article .a-top .my-blog{
        font-family: "楷体";
        font-size: 28px;
        display: inline-block;
        line-height: 40px;
    }
    .a-top .in-but{
        width: 400px;
        position: absolute;
        right: 10px;
        display: inline-block;

    }
    .user-article .a-top .in-but input{
        border-radius: 4px;
        border: 1px solid #888888;
        height: 30px;
        margin-top: 5px;
        padding-left: 5px;
        width: 300px;
        background-color: #ffffff;
    }
    .user-article .a-top .in-but button{
        padding: 4px 4px;
        width: 50px;
        background-color: #eeeeee;
        border: 1px solid #888888;
        cursor: pointer;
    }
    .user-article .article{
        width: 100%;
        height: 480px;
        margin-top: 10px;
    }
    .article .u-article{
        position: relative;
        border-bottom: 1px solid #d8cfcf;
        margin: 0px 10px;
        padding: 6px 0px;
        padding-left: 22px;
    }
    .u-article .title{
        height: 30px;
        line-height: 30px;
        font-size: 16px;
    }
    .u-article .title h3{
        cursor: pointer;
        display: inline-block;
        width: 800px;
        height: 100%;
    }
    .u-article .button{
        width: 200px;
        position: absolute;
        right: 15px;
        display: inline-block;
        top: 13px;
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
    }
    .u-article .u-time label{
        color: #8D8D8D;
    }
    .user-article #paging{
        position: absolute;
        bottom: 10px;
        width: 100%;
        padding-left: 35px;
        margin-top: 10px;
    }
    #paging .layui-laypage{
        margin: 0px;
    }
</style>

<div class="user-article">
    <div class="a-top">
        <div class="my-blog">我的收藏</div>
    </div>
    <div class="article">

    </div>
    <div id="paging">
    </div>
</div>

<script type="text/html" id="tmp-collect">
    {{each articles as article}}
    <div class='u-article'>
        <div class='title'>
            <h3 onclick="M.readArticle({{article.id}})">{{article.title}}</h3>
        </div>
        <div class='button'>
            <button style="width: 70px;" onclick='M.removeCollect(this,{{article.id}})'>取消收藏</button>
        </div>
    </div>
    {{/each}}
</script>

<script>

    var pagingData = {};  // 记录博客数据

    // 取消收藏博客
    M.removeCollect = function(e, id){
        $(e).parent().parent().remove();
        Af.rest("collect/remove.do", id, function (data) {
            for(var i=0; i<pagingData.length; i++){
                if(pagingData[i].id == id){
                    pagingData.splice(i,1);
                }
            }
        });
    }

    // 跳转到阅读
    M.readArticle = function(articleId){
        location.href = "article/read/" + articleId + ".html";
    }

    // 初始化加载博客数据
    M.initArticle = function () {
        Af.rest("collect/all.do", user.id, function (data) {
            pagingData = data;
            M.initPaggin(pagingData.length);
        });
    }

    M.initArticle();    // 初始化加载用户发表个人博客
    M.selectCalss('我的收藏');

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
                    var articleHtml = template('tmp-collect',articleData);
                    $('.article').append(articleHtml);
                }
            });
        });
    }
    //# sourceURL=user_article.js
</script>


