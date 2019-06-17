<!DOCTYPE html>
<html lang="en">
<head>
    <title></title>
    <base href="${ctxPath}">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <script type="text/javascript" src="static/js/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="static/js/afquery.js"></script>
    <link rel="stylesheet" href="static/css/index_top.css">
    <script charset="UTF-8" src="kindeditor/kindeditor-all.js"></script>
    <script charset="UTF-8" src="kindeditor/lang/zh-CN.js"></script>
    <link rel="stylesheet" href="kindeditor/themes/simple/simple.css">
    <link rel="stylesheet" href="kindeditor/themes/example1/example1.css">

    <style>

        body{
            margin: 0px;
            background-color: #eeeeee;
        }
        .article_add{
            position: relative;
            background-color: #FFFFFF;
            width: 1200px;
            margin: 0px auto;
            margin-top: 10px;
            padding: 16px 18px;
        }
        .article_add .ke-container-example1 .ke-toolbar{
            background-color: #efe1e1;
        }
        .article_add .ke-toolbar .ke-outline{
            padding: 4px 8px;
        }
        .article_add .ke-container{
            margin: 0px auto;
        }
        .article_add .t{
            width: 1000px;
            height: 40px;
            margin: 0px auto;
            margin-bottom: 20px;
            margin-top: 10px;
        }
        .article_add .t input{
            width: 985px;
            height: 30px;
            padding: 5px 5px;
            font-size: 20px;
            border: 2px solid #efe1e1;
        }
        .article_add .iuuse{
            margin: 0px auto;
            width: 1000px;
            margin-top: 20px;
            min-height: 100px;
            font-size: 18px;
            text-align: right;
        }
        .article_add .iuuse select{
            width: 170px;
            padding: 10px 10px;
            background-color: #efe1e1;
            font-size: 16px;
        }
        .article_add .iuuse select option{
            font-size: 16px;
        }
        .article_add .iuuse button{
            margin-left: 220px;
            padding: 4px;
            width: 60px;
            border: 1px solid #6aca6e;
            background-color: #ffffff;
            border-radius: 4px;
            margin-top: 15px;
            cursor: pointer;
        }
        .add-dig{
            position: fixed;
            top: 0px;
            bottom: 0px;
            left: 0px;
            right: 0px;
            background:rgba(0,0,0,0.5);
            z-index: 1000;
            display: none;
        }
        .add-dig .tmp{
            position: absolute;
            margin-left: 500px;
            top: 150px;
            width: 390px;
            height: 170px;
            background-color: #eeeeee;
            padding: 20px 20px;
        }
        .tmp .title{
            width: 100%;
            text-align: center;
            font-size: 22px;
            margin-top: 5px;
        }
        .tmp .tmp-a{
            margin-top: 45px;
            text-align: center;
        }
        .tmp .tmp-a .a{
            width: 100px;
            height: 50px;
            line-height: 50px;
            border-radius: 6px;
            background-color: #b1acac;
            display: inline-block;
        }
        .add-dig .tmp a{
            font-size: 20px;
        }
    </style>
</head>
<body>
<#include "index_top.ftl">
<div class="article_add">
    <div class="t">
        <input type="text" placeholder="输入博客标题，上限50个字" class="title">
    </div>
    <textarea id="editor"></textarea>
    <div class="iuuse">
            <div>
                <label>博客分类：</label>
                <select class="ke">
                    <option value="0">选择分类</option>
                </select>
            </div>
        <button onclick="M.Iuuse()"> 发布 </button>
    </div>
</div>
<div class="add-dig">
    <div class="tmp">
        <div class="title">
            <h3>发布成功</h3>
        </div>
        <div class="tmp-a">
            <div class="a"><a href="" class="read">查看博客</a></div>
            <div class="a"><a href="user/index#pages/user_article.ftl">管理博客</a></div>
            <div class="a"><a href="article/issue.html">继续发布</a></div>
        </div>
    </div>
</div>
<#if article ??>
    <div class="edit" style="display: none">
        <label class="id">${article.id}</label>
        <label class="programa_id">${article.programa_id}</label>
        <label class="title">${article.title}</label>
        <div class="content">${article.content}</div>
    </div>
</#if>
</body>

<script>

    var imgs = "";

    var config = {
        uploadJson : 'article/uploadFile?' ,
        filePostName: "file",
        items : [ 'source', 'fontname', 'fontsize','image'
            ,  'forecolor', 'hilitecolor', 'bold','italic', 'underline', 'strikethrough', 'lineheight'
            ,  'justifyleft', 'justifycenter', 'justifyright','link','fullscreen','code','hr'
            ,  'indent','outdent','formatblock','selectall','copy'
        ],
        width : '1000px',
        height: '765px',
        resizeType:0,
        allowFileManager:true,
        fontSizeTable:['9px', '10px', '12px', '14px', '16px', '18px','20px', '24px','28px', '32px'],
        newlineTag : 'br',
        themeType : 'example1',
        afterUpload : function(imgUrl) {
            imgs += imgUrl;
        },
    };

    var editor = KindEditor.create('#editor', config);  // 初始化富文本编辑器

    var M = {};
    M.Iuuse = function () {

        var req = {};
        req.programa_id = $('.ke').find('option:selected').val();
        req.title = $('.title').val();
        req.content = editor.html();

        if(req.title <= 0){
            layer.msg('标题不得为空');
            return;
        } else if(req.title.length > 50) {
            layer.msg('标题请控制在50个字以内哦');
            return;
        }else if(req.content.length <= 0){
            layer.msg('内容不得为空');
            return;
        } else if(req.programa_id == 0){
            layer.msg('请选择分类');
            return;
        }
        if(edit != null){
            req.id = edit.id;
        }
        req.original = true;
        req.imgUrls = imgs;

        imgs = "";
        Af.rest("article/add", req, function (data) {
            M.showAddDig(data);
        });
    }

    M.showAddDig = function(readUrl){
        $('.add-dig .read').attr('href',readUrl);
        $('.add-dig').show();
    }

    M.hideAddDig = function(){
        $('.add-dig .read').attr('href','');
        $('.add-dig').hide();
    }

    // 加载博客栏目
    M.loadPrograma = function () {
        var req = {};
        req.t = "加载栏目";
        Af.rest("load", req, function (data) {
            var selected = $('.article_add .ke');
            data.forEach(function (e) {
                var op = "<option value='" + e.id + "'" + ">" + e.name + "</option>";
                selected.append(op);
            });
            // 编辑博客时将分类设为选中状态
            if(edit != null){
                $('.ke').val(edit.programa_id);
            }
        });
    }

    // 判断是否为修改博客
    if($('.edit').length > 0){
        var e = $('.edit ');
        var edit = {};
        edit.id = $('.id', e).text();
        edit.programa_id = $('.programa_id', e).text();
        edit.title = $('.title', e).text();
        edit.content = $('.content', e).html();
        $('.title').val(edit.title);
        editor.insertHtml(edit.content);
    }

    M.loadPrograma();
</script>
</html>