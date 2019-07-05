<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title></title>
		<base href="${ctxPath}">
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
		<script type="text/javascript" src="static/js/jquery-3.3.1.min.js"></script>
		<script type="text/javascript" src="static/js/afquery.js"></script>
		<link rel="stylesheet" href="static/css/index_top.css">

		<style>
			body {
				margin: 0px;
				background-color: #eeeeee;
			}

			.user-page{
				width: 1250px;
				margin: 0px auto;
			}
			.user-page .user-top {
				position: relative;
				margin-top: 10px;
			}
			
			.user-top {
				position: relative;
				width: 1050px;
				margin: 0px auto;
			}
			
			.user-page .home-img {
				position: relative;
				width: 835px;
				height: 310px;
				left: 0px;
				display: inline-block;
			}
			
			.home-img img {
				width: 100%;
				height: 100%;
			}
			
			.user-top .user-data {
				position: absolute;
				right: 0px;
				height: 310px;
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
			
			.user-data .user-item{
				height: 50px;
				background-color: #7aa4a9;
				width: 100%;
				position: absolute;
				bottom: 0px;
				text-align: center;
			}
			.user-data .user-item .item-lable{
				color: #ffffff;
				font-family: "微软雅黑";
				font-size: 14px;
				display: inline-block;
				margin-top: 5px;
			}
			
			.user-data .user-name{
				height: 70px;
				border-bottom: 1px solid #968686;
				margin-top: 10px;
				position: relative;
				width: 180px;
				margin-left: 10px;
				color: #444;
			}
			.user-data .user-name .name-lable{
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
			.user-data .user-signature{
				position: absolute;
				bottom: 55px;
				height: 70px;
				left: 10px;
				right: 10px;
				text-align: left;
				padding: 0px 13px;
				color: #9F9F9F;
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
			.article-con .article-list{
				width: 835px;
				background-color: #888888;
				display: inline-block;
				padding: 0px;
				margin: 0px;
			}
			.article-list .clerfix{
				padding: 18px 24px;
				background: #fff;
				border-bottom: 1px solid #d4c6c6;
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
			.clerfix .title{
				position: relative;
			}
			.clerfix .title h2{
				font-size: 18px;
				margin: 0px;
				margin-bottom: 10px;
				margin-top: 5px;
				cursor: pointer;
				display: inline-block;
			}
			.clerfix .title h2 a{
				text-decoration:none;
				color: #333333;
			}
			.clerfix .title h2 a:hover{
				text-decoration:none;
				color: #8a71b7;
			}
			.clerfix .title .stick{
				line-height: 30px;
				color: #127ca5;
				font-size: 18px;
				border-right: 1px solid #8a71b7;
				display: inline-block;
				padding-right: 10px;
				margin-right: 5px;
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
			.article-list .userData img{
				width: 30px;
				height: 30px;
				border-radius: 30px;
			}
			.article-list .userData .day{
				display: inline-block;
				margin-top: 6px;
				color: #3d3d3d;
			}
			.userData .read-count{
				display: inline-block;
				position: absolute;
				right: 10px;
				width: 100px;
				text-align: center;
				color: #8a8a8a;

			}
			.article-con .notice{
				position: absolute;
				right: 0px;
				height: 240px;
				width: 180px;
				display: inline-block;
				padding: 0px 10px;
				background-color: #ffffff;
			}
			.notice .notice-text{
				width: 70px;
				border-bottom: 2px solid #867e7e;
				text-align: center;
				margin-top: 20px;
				padding-bottom: 4px;
				font-size: 16px;
				color: #7b7171;
			}
			.notice ul{
				height: 160px;
				margin: 0px;
				padding-left: 20px;
			}
			.notice ul li{
				height: 35px;
				background-color: #eeeeee;
				margin-top: 10px;
				line-height: 40px;
				padding: 0px;
				cursor: pointer;
				padding-left: 10px;
			}
			.dig{
				position: absolute;
				top: 0px;
				bottom: 0px;
				left: 0px;
				right: 0px;
				background:rgba(0,0,0,0.5);
				z-index: 1000;
				display: none;
			}
			.dig .notice{
				margin: 0px auto;
				margin-top: 100px;
				background-color: #ffffff;
				width: 600px;
				height: 310px;
				padding: 30px 0px;
			}
			.notice .notice-button{
				text-align: center;
				margin-top: 15px;
			}
			.notice .notice-button button{
				border: 1px solid #B2B2B2;
				background-color: #6FA5DB;
				padding: 4px 6px;
				border-radius: 6px;
				cursor: pointer;
				width: 60px;
			}
			.notice .notice-title{
				height: 40px;
				padding: 0px 10px;
				margin: 0px auto;
				width: 500px;
				text-align: center;
				border-bottom: 1px dotted #F44444;
			}
			.notice .notice-content{
				height: 200px;
				margin-top: 10px;
				text-align: left;
				margin: 0px auto;
				width: 500px;
				padding: 20px 10px;
				border-bottom: 1px dotted #F44444;
			}
		</style>
	</head>

	<body>
	<#include "indexTop.ftl">

		<div class="user-page">
			<div class="user-top">
				<div class="home-img">
					<img src='${(user.theme_photo)!"static/img/shanfeng.jpg"}'>
				</div>
				<div class="user-data">
						<div class="data-img">
							<img src='${(user.data_photo)!"static/img/timg.jpg"}'>
						</div>
						<div class="user-photo">
							<img src='${user.headPhoto}'>
						</div>
					<div class="user-name">
						<label class="name-lable">${user.username}</label>
					</div>
					<div class="user-item">
						<div class="item-lable">
							<label>原创</label><br /><label>${user.originalCount}</label>
						</div>
						<div class="item-lable">
							<label>关注</label><br /><label>${user.followCount}</label>
						</div>
						<div class="item-lable">
							<label>粉丝</label><br /><label>${user.fansCount}</label>
						</div>
						<div class="item-lable">
							<label>访问量</label><br /><label>${user.visitCount}</label>
						</div>
						<div class="user-signature">
							<label> ${(user.signature)!"这位同学可能比较懒、并没有留下个人介绍哦#"} </label>
						</div>
					</div>
				</div>
				<div class="user-text">
					${user.username}的个人博客
				</div>
			</div>

			<div class="article-con">
				<ul class="article-list">
   					<#if user.articleList??>
						<#list user.articleList as article>
							<li class="clerfix">
								<div class="title">
									<#if (article.stick)>
										<div class="stick">置顶</div>
									</#if>
									<h2><a href="article/read/${article.id}.html">${article.titleShow}</a></h2>
								</div>
								<div class="syponsis">${article.synopsis}</div>
								<div class="userData">
									<div class="day">
										<label>发布时间：${article.issueTime?datetime}</label>
									</div>
									<div class="read-count">
										<label>阅读量</label><br>
										<label>${article.readCount}</label>
									</div>
								</div>
							</li>
						</#list>
   					</#if>
   				</ul>
			</div>
		</div>
	</body>

	<script>

	</script>
</html>
