<script type="text/javascript" src="user.jsx"></script>
<style>
    .load-content .u-homePage {
        height: 100%;
        background-color: #ffffff;
        width: 100%;
    }

    .u-homePage .homePage-top {
        height: 50px;
        font-size: .75em;
        color: #333;
        line-height: 50px;
        background: #fff;
        box-shadow: 0 2px 4px 0 rgba(0, 0, 0, .05);
        width: 100%;
        box-sizing: border-box;
        -moz-box-sizing: border-box;
        -webkit-box-sizing: border-box;
        position: relative;
        padding: 0 28px 0 27px;
    }

    .homePage-top .my-homePage {
        font-family: "楷体";
        font-size: 28px;
        display: inline-block;
        line-height: 40px;
        margin-top: 4px;
        display: inline-block;
    }

    .user-page .user-top {
        position: relative;
        margin-top: 10px;
    }

    .user-top {
        position: relative;
        width: 100%;
        margin: 0px auto;
    }

    .user-page .home-img {
        position: relative;
        width: 700px;
        height: 240px;
        left: 30px;
        display: inline-block;
    }

    .home-img img {
        width: 100%;
        height: 100%;
    }

    .user-top .user-data {
        position: absolute;
        right: 30px;
        height: 340px;
        width: 200px;
        display: inline-block;
        background-color: #ffffff;
    }

    .user-data .data-img {
        width: 100%;
        height: 100px;
        background-color: #444444;
    }

    .user-data .data-img img {
        width: 100%;
        height: 100px;
    }

    .user-data .user-photo {
        height: 60px;
        width: 60px;
        border-radius: 50%;
        width: 360px;
        overflow: hidden;
        margin: 0 auto;
        text-align: center;
        margin-bottom: -180px;
        position: absolute;
        left: 50%;
        top: 65px;
        margin-left: -180px;
    }

    .user-data .user-photo img {
        height: 60px;
        width: 60px;
        border-radius: 50%;
    }

    .user-data .user-item {
        height: 50px;
        background-color: #7aa4a9;
        width: 100%;
        position: absolute;
        bottom: 0px;
        text-align: center;
    }

    .user-data .user-item .item-lable {
        color: #ffffff;
        font-family: "微软雅黑";
        font-size: 14px;
        display: inline-block;
        margin-top: 5px;
    }

    .user-data .user-name {
        height: 70px;
        border-bottom: 1px solid #968686;
        margin-top: 10px;
        position: relative;
        width: 180px;
        margin-left: 10px;
    }

    .user-data .user-name .name-lable {
        height: 60px;
        width: 60px;
        border-radius: 50%;
        width: 360px;
        overflow: hidden;
        margin: 0 auto;
        text-align: center;
        margin-bottom: -180px;
        font-size: 18px;
        position: absolute;
        font-family: "楷体";
        left: 50%;
        top: 40px;
        margin-left: -180px;
    }

    .user-data .user-signature {
        position: absolute;
        bottom: 65px;
        height: 80px;
        left: 10px;
        right: 10px;
        text-align: left;
    }

    .user-top .user-text {
        font-size: 32px;
        font-family: "楷体";
        position: absolute;
        left: 5%;
        top: 10%;
    }

    .user-page .article-con {
        width: 1050px;
        min-height: 200px;
        margin: 10px auto;
        position: relative;
        margin-bottom: 30px;
    }

    .u-homePage .home-bt {
        width: 700px;
        height: 30px;
        padding-bottom: 15px;
        margin: 0px auto;
        margin-top: 10px;
        margin-left: 30px;
    }

    .u-homePage .home-bt button {
        width: 150px;
        padding: 8px 8px;
        cursor: pointer;
        border: 1px solid #9F9F9F;
        background-color: #e8dcdc;
        border-radius: 6px;
        margin-right: 25px;
    }

    .u-homePage .home-bt button:hover {
        background-color: #6FA5DB;
        border-radius: 6px;
        border: 1px solid #9F9F9F;
    }

    .u-homePage .home-notice {
        width: 710px;
        position: relative;
        margin-left: 30px;
    }
    .home-notice .notice-con{
        width: 635px;
        height: 180px;
        display: inline-block;
        margin-left: 70px;
    }
    .home-notice .notice-left{
        width: 70px;
        display: inline-block;
        position: absolute;
        top: 14px;
        font-size: 17px;
        color: #bf8f1f;
        padding-left: 2px;
    }
    .notice-con .notice{
        margin-bottom: 5px;
        width: 100%;
        border-bottom: 1px dotted #7aa4a9;
        margin-top: 15px;
        padding-bottom: 5px;
    }
    .notice .notice-title{
        width: 540px;
        display: inline-block;
        font-size: 17px;
    }
    .notice .notice-bt{
        width: 90px;
        display: inline-block;
        text-align: right;
    }
    .notice .notice-bt button{
        background-color: #C2BE9E;
        border:1px solid #9F9F9F;
        padding: 2px 4px;
        border-radius: 4px;
        margin-left: 5px;
        cursor: pointer;
    }
    .dig{
        position: fixed;
        top: 0px;
        bottom: 0px;
        left: 0px;
        right: 0px;
        background:rgba(0,0,0,0.5);
        z-index: 1000;
        display: none;
    }
    .dig .layui-form{
        margin-left: 300px;
        margin-top: 90px;
        background-color: #ffffff;
        width: 800px;
        height: 350px;
        text-align: center;
        padding: 30px 0px;
        padding-right: 70px;
    }
    .layui-form-item{
        margin-left: 25px;
    }
</style>

<div class="u-homePage">
    <div class="homePage-top">
        <div class="my-homePage">编辑主页界面</div>
    </div>

    <div class="user-page">
        <div class="user-top">
            <div class="home-img">
                <img src='static/img/shanfeng.jpg' class="h-img">
            </div>
            <div class="user-data">
                <div class="data-img">
                    <img src='static/img/timg.jpg' class="d-img">
                </div>
                <div class="user-photo">
                    <img src='static/img/ph.png' class="p-img">
                </div>
                <div class="user-name">
                    <label class="name-lable"></label>
                </div>
                <div class="user-item">
                </div>
            </div>
            <div class="user-text">

            </div>
        </div>
    </div>

    <div class="home-bt">
        <button onclick="U.upImgPhoto('1')">编辑主页背景图</button>
        <button onclick="U.upImgPhoto('2')">编辑资料背景图</button>
        <button onclick="M.showNoticeDig('0')" style="width: 170px">添加公告 - 上限为4条</button>
    </div>

    <div class="home-notice">
        <div class="notice-left">公告区：</div>
        <div class="notice-con"></div>
    </div>
</div>
<div class="dig">
    <input type="file" class="filebutton" style="display: none;"/>
    <div id='info' class="layui-form" lay-filter="formTest">
        <div class="notice-id" noticeId="0"></div>
        <div class="layui-form-item">
            <label class="layui-form-label" name="id">公告标题</label>
            <div class="layui-input-block">
                <input type="text" name="title" required  lay-verify="required" placeholder="标题可输入25个字" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item layui-form-text">
            <label class="layui-form-label">编辑内容</label>
            <div class="layui-input-block" >
                <textarea name="content" placeholder="内容可输入1000个字" class="layui-textarea" style="height: 250px"></textarea>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label" ></label>
            <button class='layui-btn layui-btn-normal' lay-submit lay-filter="formDemo"> 提交 </button>
            <button class='layui-btn layui-btn-normal' onclick='M.do_call()'> 取消 </button>
        </div>
    </div>
</div>
<script type="text/html" id="tmp-notice">
    {{each notices as notice}}
    <div class="notice">
        <div class="notice-title">
            <label class="title">{{notice.title}}</label>
            <label class="content" style="display: none;">{{notice.content}}</label>
        </div>
        <div class="notice-bt">
            <button onclick="M.showNoticeDig(this, {{notice.id}})">编辑</button>
            <button onclick="M.removeNotice(this, {{notice.id}})">删除</button>
        </div>
    </div>
    {{/each}}
</script>

<script>

    M.showNoticeDig = function (e,noticeId) {
        // 0：添加公告，反之为编辑公告
        $('.dig .notice-id').attr('noticeId',0);
        if(noticeId == '0'){
            layui.use('form', function(){
                var notice = $(e).parent().parent();
                var form = layui.form;
                form.val("formTest", {
                    "title":'',
                    "content":''
                })
            });
        }else {
            layui.use('form', function(){
                $('.dig .notice-id').attr('noticeId',noticeId);
                var notice = $(e).parent().parent();
                var form = layui.form;
                form.val("formTest", {
                    "title":$('.title',notice).text().trim(),
                    "content":$('.content',notice).text().trim()
                })
            });
        }
        $('.dig').show();
    }
    M.do_call = function () {
        $('.dig').hide();
    }

    // 当点击提交时触发事件，data.field自动提取name属性数据
    layui.use('form', function(){
        var form = layui.form;
        //监听提交
        form.on('submit(formDemo)', function(data){
            var req = data.field;
            var dig = $(this).parent().parent().parent();
            req.id = $('.notice-id', dig).attr('noticeId');
            if(req.title == null || req.title == ""){
                layer.msg('请输入标题!');
                return;
            }
            if(req.title.length > 25){
                layer.msg('请将标题控制在25个字以内!');
                return;
            }
            if(req.content == null || req.content == ""){
                layer.msg("请输入内容!");
                return;
            }
            if($('.notice').length > 3 && req.id == 0){
                layer.msg("最多发布4条公告!!");
                return;
            }
            Af.rest("notice/save.do", req, function (data) {
                $('.notice-con').empty();
                M.initNotice();
                $('.dig').hide(); // 关闭对话框
            });
        });
    });

    // 编辑公告
    M.editNotice = function(noticeId){
        Af.rest("notice/save.do", noticeId, function (data) {
            layui.use('form', function(){
                var form = layui.form;
                form.val("formTest", {
                    "id": data.id,
                    "title":data.title,
                    "content":data.content,
                })
            });
            $('.dig').show();
        });
    }

    // 删除公告
    M.removeNotice = function(e, noticeId){
        $(e).parent().parent().remove();
        Af.rest("notice/remove.do", noticeId, function (data) {
        });
    }

    // 公告模板引擎加载数据
    M.initNotice = function () {
        Af.rest("notice/list.all", user.id, function (data) {
            var NoticeData = {
                notices:data
            };
            var noticeHtml = template('tmp-notice', NoticeData);
            $('.notice-con').append(noticeHtml);
        });
    }

    M.initNotice();  // 初始化公告

    var U = {};

    U.init = function(){
        // 创建FileUpload对象，设置按钮触发事件以及上传回调事件
        U.uploadfile = new AfFileUploader();
        U.uploadfile.setButton('.dig .filebutton').setObserver(this);
    }

    U.upImgPhoto = function(status){
        // 设置请求接口，显示文件复选框
        U.uploadfile.setUploadUrl('user/uploadPhoto/' + status);
        U.uploadfile.openFileDialog();
    }

    U.uploadHandleEvent = function(msg, uploader)
    {
        // 上传完成后的回调时间
        if(msg == 'complete')
        {
            // 设置图片路径
            if(uploader.response.data.status == 1){
                $('.u-homePage .h-img').attr('src', uploader.response.data.imgUrl);
                user.theme_photo = uploader.response.data.imgUrl;
            }else {
                $('.u-homePage .d-img').attr('src', uploader.response.data.imgUrl);
                user.data_photo= uploader.response.data.imgUrl;
            }

        }
    }

    U.init();

    // 初始化加载数据
    if (user != null) {
        var p = $('.u-homePage');
        if (user.theme_photo != null)
            $('.h-img', p).attr('src', user.theme_photo);
        if (user.data_photo != null)
            $('.d-img', p).attr('src', user.data_photo);
        if (user.head_portrait != null)
            $('.p-img', p).attr('src', user.head_portrait);

        $('.user-text', p).text(user.username + '的个人博客');
        $('.name-lable', p).text(user.username);
    }

    M.selectCalss('编辑主页');
    //# sourceURL=user_page.js
</script>

