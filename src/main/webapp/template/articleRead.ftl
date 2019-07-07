<!DOCTYPE html>
<html lang="en">
<head>
    <base href="${ctxPath}">
    <script type="text/javascript" src="static/js/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="static/js/afquery.js"></script>
    <link rel="stylesheet" href="static/css/index_top.css">
    <link rel="stylesheet" href="kindeditor/plugins/code/prettify.css">
    <script type="text/javascript" src="kindeditor/plugins/code/prettify.js"></script>

    <style>
        body{
            margin: 0px;
            background-color: #eeeeee;
        }
        .index{
            width: 1250px;
            position: relative;
            margin: 0px auto;
            min-height: 540px;
            padding-bottom: 30px;
        }
        .index .content{
            width: 910px;
            padding: 0px 24px;
            min-height: 200px;
            display: inline-block;
            position: absolute;
            left: 300px;
            top: 10px;
            background-color: #FFFFFF;
            margin-bottom: 30px;
        }
        .content .article-top{
            padding: 10px 0px;
            border-bottom: 1px solid #C2BE9E;
        }
        .content .article-title{
            min-height: 30px;
        }
        .content .article-title .title{
            display: inline-block;
        }
        .content .article-title .title h2{
            margin: 10px 0px;
        }

        .content .userData{
            margin-bottom: 10px;
        }
        .userData .issue_time,.username2,.original,.read_count{
            display: inline-block;
            margin-right: 15px;
            font-size: 14px;
        }
        .userData .original{
            color: #CC5522;
        }
        .userData .issue_time,.read_count{
            color: #8a8a8a;
        }
        .userData .collect{
            display: inline-block;
            color: #6495ED;
            cursor: pointer;
        }
        .username2 a{
            text-decoration: none;
            color: #6495ED;
        }
        .content .article-text{
            width: 100%;
            padding: 30px 0px;
            word-wrap: break-word;
            border-bottom: 1px dashed #C2BE9E;
            font-size: 17px;
        }
        .article-text pre.prettyprint{
            overflow-x:auto;
            border: 0px;
            background-color: #E7EAED;
            margin: 10px 0px;
        }
        .content .comment{
            width: 100%;
            padding: 10px 0px;
            word-wrap: break-word;
            margin: 20px 0px;
        }
        .comment .leave {
            width: 100%;
        }

        .comment .leave textarea {
            display: block;
            width: 100%;
            padding: 7px 8px;
            background: #fff;
            border: 1px solid #c1c1c1;
            border-radius: 4px;
            resize: none;
            font-size: 14px;
            line-height: 22px;
            -webkit-box-sizing: border-box;
            box-sizing: border-box;
            -webkit-transition: height .3s ease-in-out;
            transition: height .3s ease-in-out;
            height: 100px;
            vertical-align: top;
            outline: none;
        }

        .comment .leave button {
            padding: 4px 6px;
            border-radius: 4px;
            background-color: #6aca6e;
            border: 0px;
            color: #FFFFFF;
            margin-top: 10px;
            cursor: pointer;
        }

        .comment .leave .fb-button {
            width: 100%;
            text-align: right;
        }

        .comment .leave .fb-button label {
            margin-right: 10px;
            color: #7db797;
        }

        .content .comment-reply {
            width: 100%;
        }
        .comment-reply .ct {
            padding-bottom: 40px;
        }

        .ct .button button {
            border: 1px solid #968686;
            padding: 4px;
            border-radius: 4px;
            background-color: #FFFFFF;
            cursor: pointer;
        }

        .ct .item-comt {
            padding-top: 10px;
            padding-bottom: 5px;
            width: 100%;
            display: inline-block;
            border-bottom: 1px solid #C1C1C1;
            position: relative;
        }
        .content .reply_hf{
            margin-top: 10px;
            margin-left: 31px;
            width: 700px;
            text-align: right;
            display: none;
            margin-bottom: 5px;
        }
        .reply_hf .reply-text{
            display: block;
            width: 100%;
            padding: 7px 8px;
            background: #fff;
            border: 1px solid #c1c1c1;
            border-radius: 4px;
            resize: none;
            font-size: 14px;
            line-height: 22px;
            -webkit-box-sizing: border-box;
            box-sizing: border-box;
            -webkit-transition: height .3s ease-in-out;
            transition: height .3s ease-in-out;
            height: 70px;
            vertical-align: top;
            outline: none;
        }
        .reply_hf .hf-button{
            margin-top: 5px;
            height: 20px;
        }
        .reply_hf .hf-button button{
            border: 1px solid #6aca6e;
            padding: 2px 6px;
            background-color: #FFFFFF;
            cursor: pointer;
        }
        .reply_hf .text-r{
            font-size: 14px;
        }
        .ct .zw {
            width: 100%;
            height: 400px;
            text-align: center;
            line-height: 400px;
        }
        .ct .img_applaud {
            position: absolute;
            top: 25px;
            right: 5px;
            text-align: center;
            width: 60px;
            height: 30px;
        }

        .ct .img_applaud img {
            width: 20px;
            height: 20px;
            cursor: pointer;
        }
        .img_applaud .appld{
            font-size: 14px;
        }
        .item-comt .comt-t {
            margin-top: 5px;
            width: 820px;
            position: relative;
            padding: 0px 33px;
        }

        .comt-t button {
            border: 1px solid #CCD2D8;
            padding: 4px 10px;
            background-color: #7db797;
            margin-left: 20px;
            border-radius: 4px;
            color: #FFFFFF;
            cursor: pointer;
        }
        .comt-t .addReply{
            margin-left: 10px;
            color: #6495ED;
            cursor: pointer;
        }
        .comt-t .isFindR{
            margin-left: 10px;
            color: #6495ED;
            cursor: pointer;
        }
        .comt-t .comt-x{
            border-left: 2px solid #888888;
            font-size: 14px;
            margin-left: 33px;
            margin-bottom: 3px;
            display: none;
        }
        .comt-t .comt-img{
            position: absolute;
            height: 30px;
            width: 30px;
            top: 0px;
            left: 0px;
            line-height: 10px;
        }
        .comt-img img{
            height: 30px;
            width: 30px;
            border-radius: 30px;
            cursor: pointer;
        }
        .comt-t .comt-con{
            display: inline-block;
            margin-left: 35px;
            line-height: 30px;
            height: 30px;
        }
        .comt-con .user{
            display: inline-block;
        }
        .comt-con .user .lable-name{
            color: #444;
            cursor: pointer;
        }
        .comt-con .user .lable-name:hover{
            color: #8a71b7;
        }
        .comt-t .comt-x .comt-text {
            width: 800px;
            margin-left: 5px;
            margin-top: 10px;
            padding: 3px 30px;
            position: relative;
        }
        .comt-x .comt-text .text-img{
            width: 25px;
            height: 25px;
            position: absolute;
            top: 0px;
            left: 2px;
        }
        .comt-x .comt-text img{
            width: 25px;
            height: 25px;
            border-radius: 50px;
        }
        .article-text img{
            max-height: 700px;
            max-width: 700px;
        }
        .left{
            width: 300px;
            display: inline-block;
            position: absolute;
            top: 10px;
            bottom: 0px;
        }
        .left .userItem{
            width: 280px;
            padding: 20px 5px;
            height: 130px;
            border-radius: 20px;
            background-color: #FFFFFF;
            box-shadow: 1px 1px 2px #d4c975;
        }
        .left .userItem .user-photo{
            width: 100%;
            height: 50px;
            position: relative;
            padding-bottom: 10px;
        }
        .user-photo .u-name{
            position: absolute;
            left: 70px;
            top: 12px;
            font-size: 18px;
            overflow: hidden;
            word-wrap: break-word;
        }
        .user-photo .u-name a{
            text-decoration: none;
            font-family: 'Microsoft YaHei','SF Pro Display',Roboto,Noto,Arial,'PingFang SC',sans-serif;
            cursor: pointer;
            color: #3d3d3d;
        }
        .user-photo .photo{
            width: 40px;
            height: 40px;
            border-radius: 50px;
            position: absolute;
            left: 23px;
            top: 5px;
            display: inline-block;
        }
        .user-photo .photo img{
            width: 40px;
            height: 40px;
            cursor: pointer;
        }
        .user-photo .gz{
            display: inline-block;
            cursor: pointer;
            width: 60px;
            padding: 2px 2px;
            border-radius: 6px;
            position: absolute;
            right: 18px;
            top: 12px;
            text-align: center;
            border: 1px solid #8a71b7;
            color: #444;
        }
        .userItem .user-text{
            height: 50px;
            padding-top: 15px;
            border-top: 1px solid #eeeeee;
            margin-top: 10px;
        }
        .user-text .u-text{
            display: inline-block;
            text-align: center;
            width: 85px;
        }
        .user-text .u-text .u-lable{
        }
        .left .advertising{
            width: 280px;
            padding: 10px 5px;
            min-height: 300px;
            border-radius: 20px;
            background-color: #FFFFFF;
            box-shadow: 1px 1px 2px #C2BE9E;
            margin-top: 10px;
            margin-bottom: 15px;
        }
        .advertising .hot-title{
            height: 30px;
            border-bottom: 1px solid #debfbf;
            width: 100%;
            padding: 7px 0px;
            text-align: center;
            color: #d48665;
        }
        .advertising .hot-article{
            width: 100%;
            margin-top: 20px;
        }
        .hot-article .arcl{
            margin-top: 12px;
            padding: 0px 10px;
            border-bottom: 1px dashed #C2BE9E;
            padding-bottom: 10px;
        }
        .hot-article .arcl a{
            text-decoration:none;
            font-size: 16px;
        }
        .reply .reply-name{
            color: #444;
            cursor: pointer;
        }
        .reply .reply-name:hover{
            color: #8a71b7;
        }
    </style>
</head>
<body>
<#include "indexTop.ftl">
<#--<#setting datetime_format="yyyy-MM-dd HH:mm:ss"/>-->
<div class="index">
    <div class="left">
        <div class="userItem">
            <div class="user-photo">
                <div class="photo">
                    <img src="${user.headPhoto}" onclick="M.loadUserPage(${user.id})"/>
                </div>
                <div class="u-name"><a href="u/index/${user.id}.html">${user.username}</a></div>
                <#if article.isAttention ??>
                        <div class="gz" isFollow="1" onclick="M.follow(this)">已关注</div>
                    <#else>
                        <div class="gz" isFollow="0" onclick="M.follow(this)">关注</div>
                </#if>
            </div>
            <div class="user-text">
                <div class="u-text">
                    <label class="u-lable">原创</label><br>
                    <label> ${user.originalCount} </label>
                </div>
                <div class="u-text">
                    <label class="u-lable">关注</label><br>
                    <label> ${user.followCount} </label>
                </div>
                <div class="u-text">
                    <label class="u-lable">粉丝</label><br>
                    <label> ${user.fansCount} </label>
                </div>
            </div>
        </div>
        <div class="advertising">
            <div class="hot-title">
                热门博客
            </div>
            <div class="hot-article">
                <#if user.articleList??>
                    <#list user.articleList as art>
                        <div class="arcl">
                            <a href="article/read/${art.id}.html">${art.titleShow}</a>
                            <label style="margin-left: 10px; color: #aba5a5;">阅读量：${art.readCount}</label>
                        </div>
                    </#list>
                </#if>
            </div>
        </div>
    </div>
<div class="content">
    <div class="article-top">
        <div class="article-title">
            <div class="title">
                <h1 style="margin-bottom: 10px">${article.title}</h1>
            </div>
        </div>
        <div class="userData">
            <div class="issue_time">发布时间：${article.issueTime?datetime}</div>
            <div class="username2">
                <a href="u/index/${user.id}.html"> ${user.username} </a>
            </div>
            <div class="original">${article.original?then('原创','转载')}</div>
            <div class="read_count">阅读量：${article.readCount}</div>
            <#if article.isCollect ??>
                    <div class="collect" onclick="M.collect(this,${article.id})" isCollect="1">取消收藏</div>
                <#else>
                    <div class="collect" onclick="M.collect(this,${article.id})" isCollect="0">点击收藏</div>
            </#if>
        </div>
    </div>
    <div class="article-text">
        ${article.content}
    </div>
    <div class="comment">
        <div class="leave">
            <textarea type="text" placeholder="最多可输入500字符" class="leave-text"></textarea>
            <div class="fb-button">
                <label class="text-size"></label>
                <button onclick="M.addComment()"> 发表评论 </button>
            </div>
        </div>
    </div>
    <div class="comment-reply">
        <#if article.commentList ??>
        <div class="ct">
            <#list article.commentList as comment>
            <div class="item-comt">
                <div class="comt-t" style="padding: 0px;">
                    <div class="comt-img">
                        <img src='${comment.user.headPhoto}' onclick="M.loadUserPage(${comment.user.id})"/>
                    </div>
                    <div class="comt-con">
                        <div>
                            <div class="show">
                                <div class="user" by_userId="${comment.user.id}" by_username="${comment.user.username}">
                                    <label class="lable-name" onclick="M.loadUserPage(${comment.user.id})">${comment.user.username}</label>
                                    <label>：${comment.comment}</label>
                                </div>
                                <label class="addReply" isReply='1' onclick="M.showReplyDig(this)">回复</label>
                                <#if (comment.replyCount > 0)>
                                    <label class="isFindR" onclick="M.findReply(this,${comment.id})" isFindR="0">
                                        查看回复<${comment.replyCount}> </label>
                                </#if>
                            </div>
                        </div>
                        <div>
                            <label style="color: #7db797;"> ${comment.commentTime?datetime} </label>
                        </div>
                    </div>
                    <div class="comt-x">
                        <!-- 回复内容区 -->
                    </div>
                </div>

                <div class='reply_hf' by_userId='' by_username=''>
                    <textarea type='text' placeholder='最多可输入300字符' class='reply-text'></textarea>
                    <div class='hf-button'>
                        <label class="r-text"></label>
                        <button onclick='M.addReply(this, ${comment.id})'> 确定 </button>
                        <button onclick='M.callReply(this)'> 取消 </button>
                    </div>
                </div>

                <div class="img_applaud">
                <#if comment.status ??>
                    <img src="static/img/appluad.png" class="imgUrl" sta="1" onclick="M.addAppluad(this, ${comment.id})" />
                    <div class="appld"> ${comment.appluadCount} </div>
                <#else>
                    <img src="static/img/appluad2.png" class="imgUrl" sta="0" onclick="M.addAppluad(this, ${comment.id})" />
                    <div class="appld"> ${comment.appluadCount} </div>
                </#if>
                </div>

            </div>
                </#list>
        </div>
        </#if>
    </div>
</div>
</div>
<script type="text/javascript">
    prettyPrint();
</script>
</body>

<script>

    var M = {};

    // 添加评论
    M.addComment = function() {

        var req = {};
        req.comment = $('.leave-text').val();
        req.articleId = ${article.id};
        if(req.comment.length <= 0) {
            layer.msg('请先输入内容');
            return;
        }
        if(req.comment.length > 500){
            layer.msg('超出字符范围：共输入<' + req.content.length + '>字符');
            return;
        }
        Af.rest('comment.add', req, function(read_url) {
            window.location.reload(true);
        });
    }

    // 显示回复框
    M.showReplyDig = function(e) {
        var item = $(e).parent().parent().parent().parent().parent();
        var reply_hf = $('.reply_hf', item);
        if($(e).attr('isReply') == 1){
            var by_userId = $('.user',item).attr('by_userId');
            var by_username = $('.user',item).attr('by_username');
            $(reply_hf).attr('by_userId', by_userId);
            $(reply_hf).attr('by_username', by_username);
            var text = '[正在回复' + by_username + '...最多可输入300字符]';
            $('.reply-text', reply_hf).attr('placeholder',text);
            $(reply_hf).show();
        } else{
            var reply = $(e).parent();
            var by_userId = $('.reply-name', reply).attr('user_id');
            var by_username = $('.reply-name', reply).text().trim();
            $(reply_hf).attr('by_userId', by_userId);
            $(reply_hf).attr('by_username', by_username);
            var text = '[正在回复' + by_username + '...最多可输入300字符]';
            $('.reply-text', reply_hf).attr('placeholder',text);
            $(reply_hf).show();
        }
    }

    // 添加回复
    M.addReply = function(e, comment_id) {
        var reply_hf = $(e).parent().parent();
        var req = {};
        req.content = $('.reply-text',reply_hf).val();
        if(req.content.length <= 0){
            layer.msg('请先输入内容');
            return;
        }
        if(req.content.length > 300){
            layer.msg('超出字符范围：共输入<' + req.content.length + '>字符');
            return;
        }
        req.commentId = comment_id;
        req.byUserId = $(reply_hf).attr('by_userId');
        req.byUsername = $(reply_hf).attr('by_username');
        Af.rest("reply/add.do", req, function (data) {
            window.location.reload(true);
        });
    }

    // 取消回复
    M.callReply = function(e) {
        var comt = $(e).parent().parent().parent().parent().parent();
        $(comt).attr('by_userId','');
        $(comt).attr('by_username', '');
        var reply_hf = $(e).parent().parent();
        $('.reply-text', reply_hf).val('');
        $(reply_hf).hide();
    }

    // 查看回复
    M.findReply = function(e, comtId) {
        // 清空内容
        var item_comt = $(e).parent().parent().parent().parent().parent();
        var comt_x = $('.comt-x',item_comt);
        $(comt_x).empty();

        // 判断是否加载数据，isFindR属性为0时获取数据
        var isFindR = $(e).attr('isFindR');
        if(isFindR == 0) {
            $(e).attr('isFindR',1);
            $(comt_x).show();
            var req = {};
            req.id = comtId;
            Af.rest("reply/query.all", req, function (data) {
                M.showReply(comt_x, data);
            });
        } else {
            $(e).attr('isFindR',0);
            $(comt_x).hide();
        }
    }

      // 加载回复，模板替换
      M.showReply = function(cx, data) {
        var tmp = new AfTemplate(
              "<div class='comt-text'>"
            +	"<div class='text-img'>"
            +		"<img src='{#headPhoto}' style='cursor: pointer' onclick='M.loadUserPage({#userId})'/>"
            +	"</div>"
            +   "<div class='reply'>"
            +		"<label class='reply-name' user_id={#userId} onclick='M.loadUserPage({#userId})'> {#username} </label>"
            +		"<label> 回复 {#byUsername}：</label>"
            +		"<label> {#content} </label>"
            +		"<label class='addReply' isReply='0' onclick='M.showReplyDig(this)'>回复</label>"
            + 	"</div>"
            + "</div>");

            data.forEach(function (e) {
                $(cx).append(tmp.replace(e));
            });
     }

    // 当前用户点赞
    M.addAppluad = function(e, comment_id){
        var req = {};
        req.commentId = comment_id;
        req.articleId = ${article.id};
        req.id = $(e).attr('sta');
        Af.rest("appluad.add", req, function (data) {
            // 控制点赞数量以及图片的变化
            var img_applaud = $(e).parent();
            var appld = $('.appld',img_applaud);
            var count = (appld).text().trim();
            // sta为1时表示取消点赞
            if($(e).attr('sta') == 1){
                $(appld).text(Number(count)-1);
                $(e).attr('src','static/img/appluad2.png');
                $(e).attr('sta', '0');
            } else {
                $(appld).text(Number(count)+1);
                $(e).attr('src','static/img/appluad.png');
                $(e).attr('sta', '1');
            }
        });
    }

    // 点击关注
    M.follow = function(e){
        var req = {};
        req.id = $(e).attr('isFollow');
        req.followId = ${user.id};
       Af.rest("follow.add", req, function (data) {
           var isFollow = $(e).attr('isFollow');
           if(isFollow == 1){
               $(e).attr('isFollow', 0);
               $(e).text('关注');
           }else {
               $(e).attr('isFollow', 1);
               $(e).text('已关注');
           }
       }) ;
    }

    // 点击收藏
    M.collect = function(e,articleId){
        var req = {};
        req.isCollect = $(e).attr('isCollect');
        req.articleId = articleId;
        Af.rest("collect/add.do", req, function (data) {
            if(req.isCollect == 0){
                $(e).text('取消收藏');
                $(e).attr('isCollect', 1);
            }else {
                $(e).text('点击收藏');
                $(e).attr('isCollect', 0);
            }
        });
    }

    // 进入用户个人主页
    M.loadUserPage = function(userId){
        location.href = "u/index/" + userId + ".html";
    }

    // 实时监控 textarea 内容长度
    $('.leave-text').bind('input propertychange', 'textarea', function() {
        var text = $(this).val();
        if(text.length > 500){
            $('.text-size').text('字符数量已达到上限');
        }else{
            $('.text-size').text('已输入：' + text.length + '字符');
        }
    });

</script>
</html>