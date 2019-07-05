<!DOCTYPE html>
<html>
<head>
	<title></title>
    <base href="${ctxPath}">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
	<script type="text/javascript" src="static/js/jquery-3.3.1.min.js"></script>
	<script type="text/javascript" src="static/js/afquery.js"></script>
	<link rel="stylesheet" href="static/css/index_top.css">
    <style type="text/css">
        body{
           	margin: 0px;
        }
        .index{
			position: relative;
			width: 1250px;
			margin: 0 auto;
			min-height: 540px;
			margin-top: 15px;
        }
        .index .content{
			width: 900px;
			display: inline-block;
			position: relative;
			margin-left: 20px;
        }
        .index .content .article-list{
        	width: 100%;
        	background-color: #FFFFFF;
        	margin: 0px;
        	padding: 0px;
        	margin-top: 10px;
			margin-bottom: 30px;
        }
        .index .content .article-list .clerfix{
        	padding: 13px 24px;
    		background: #fff;
    		border-bottom: 1px dashed #c6cce4;
    		position: relative;
   			-webkit-box-shadow: 0 1px 2px 0 rgba(0,0,0,0.04);
    		box-shadow: 0 1px 2px 0 rgba(0,0,0,0.04);
    		list-style: none;
    		margin: 0;
    		-webkit-box-sizing: border-box;
    		display: list-item;
    		text-align: -webkit-match-parent;
        	line-height: 20px;
        }
		.article-list .title h2{
			font-size: 20px;
			margin: 0px;
			margin-bottom: 10px;
			margin-top: 5px;
			cursor: pointer;
		}
		.article-list .title h2 a{
			text-decoration:none;
			color: #333333;
		}
		.article-list .title h2 a:hover{
			text-decoration:none;
			color: #8a71b7;
		}
		.article-list .syponsis{
			margin-bottom: 4px;
			color: #8a8a8a;
			font-size: 14px;
			line-height: 24px;
			font-family: PingFang SC,Hiragino Sans GB,
			Arial,Microsoft YaHei,Verdana,Roboto,Noto,Helvetica Neue,sans-serif !important;
		}
		.article-list .userData{
			position: relative;
			height: 30px;
		}
		.userData .read_count{
			position: absolute;
			right: 20px;
			bottom: 0px;
		}
		.article-list .userData .img{
			position: absolute;
			width: 30px;
			height: 30px;
			border-radius: 30px;
			display: inline-block;
			cursor: pointer;
		}
		.article-list .userData img{
			width: 30px;
			height: 30px;
			border-radius: 30px;
		}
		.article-list .userData .name{
			display: inline-block;
			margin: 0px 10px;
			margin-left: 40px;
			top: 10px;
			cursor: pointer;
			color: #7aa4a9;
		}
		.article-list .userData .name:hover{
			color: blueviolet;
			border-bottom: 1px solid blueviolet;
		}
		.article-list .userData .day{
			display: inline-block;
			margin-top: 6px;
			padding-left: 13px;
			color: #8a8a8a;
			border-left: 1px solid #C2BE9E;
		}
		.index .right{
			width: 310px;
			display: inline-block;
			position: absolute;
			height: 500px;
			border-left: 1px solid #B2B2B2;
			padding-left: 10px;
			text-align: center;
        }
		.right .text{
			width: 250px;
			height: 50px;
			border: 1px solid #8a71b7;
			text-align: center;
			line-height: 50px;
			border-radius: 10px;
			margin-top: 25px;
			font-size: 20px;
			color: #7aa4a9;
			box-shadow: 1px 1px 1px #B2B2B2;
			margin: 0px auto;
		}
		.right .advertising{
			width: 290px;
			height: 220px;
			border: 1px solid #8a71b7;
			margin: 0 auto;
			margin-top: 25px;
		}
		.right .advertising img{
			width: 100%;
			height: 100%;
		}
    </style>
</head>
<body>

<#include "indexTop.ftl">

<div class="index">
	<!--	变动区域		-->
   	<div class="content">
   		<ul class="article-list">
   			<#list articleList as article>
				<li class="clerfix">
					<div class="title">
						<h2><a href="article/read/${article.id}.html">${article.titleShow}</a></h2>
					</div>
					<div class="syponsis">${article.synopsis}</div>
					<div class="userData">
						<div class="img">
							<img src="${article.user.headPhoto}" onclick="M.loadUserPage('${article.user.id}')"/>
						</div>
						<div class="name" onclick="M.loadUserPage('${article.user.id}')">${article.user.username}</div>
						<div class="day">
							<label>${article.pastTime}</label>
						</div>
						<div class="read_count">
							<label>阅读量：${article.readCount}</label>
						</div>
					</div>
   				</li>
            </#list>
   		</ul>
   	</div>

	<div class="right">
		<div class="text">
			已筛选出符合条件的博客
		</div>
		<div class="advertising">
			<img src="static/img/why.jpg">
		</div>
	</div>
</div>
<script>

</script>
</body>

<script>
	var M = {};
	M.loadUserPage = function (userId) {
		location.href = "/u/index/" + userId + ".html";
	}

</script>
</html>
