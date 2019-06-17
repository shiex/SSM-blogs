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
			min-height: 550px;
        }
        .index #left{
        	width: 170px;
        	background-color: #fff;
        	display: inline-block;
			position: absolute;
			border: 1px solid #adadaa;
			margin-left: 10px;
			border-radius: 10px;
			box-shadow: 1px 1px 1px 0px #C2BE9E;
        }
        .index #left ul{
        	list-style: none;
        	margin: 10px 0px;
        	padding: 0px;
            background-color: #FFFFFF;
			margin-bottom: 15px;
        }
        .index #left li{
        	width: 100%;
        	text-align: center;
        	height: 20px;
        	padding: 9px 0px;
        	cursor: pointer;
        	background-color: #ffffff;
        	border-bottom: 1px solid #e4e3e3;
        	list-style: none;
			font-size: 17px;
        }
		.index #left li a{
			height: 100%;
			width: 100%;
		}
		.index #left .color{
			box-shadow: 0 1px 2px 0 rgba(0,0,0,0.04);
			background-color: #767e82;
		}
		.index #left li:hover{
			box-shadow: 0 1px 2px 0 rgba(0,0,0,0.04);
			background-color: #eeeeee;
		}
        .index #left li a{
        	text-decoration:none;
        	color: #333333;
        }
        .index .content{
        	width: 770px;
        	display: inline-block;
        	margin-left: 195px;
        	position: relative;
        }
        .index .content .advertising-top{
        	height: 310px;
        	width: 100%;
        	position: absolute;
        	background-color: #FFFFFF;
        }
        .index .content .advertising-top img{
        	height: 100%;
        	width: 100%;
        	position: relative;
        	top: 0px;
        }
        .index .content .article-list{
        	width: 100%;
        	background-color: #FFFFFF;
        	margin: 0px;
        	padding: 0px;
        	margin-top: 320px;
			margin-bottom: 30px;
        }
        .index .content .article-list .clerfix{
        	padding: 18px 24px;
    		background: #fff;
    		border-bottom: 1px solid #bfb2b2;
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
			font-size: 18px;
			margin: 0px;
			margin-bottom: 10px;
			margin-top: 5px;
		}
		.article-list .title h2 a{
			text-decoration:none;
			color: #333333;
			cursor: pointer;
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
		.article-list .userData .img{
			position: absolute;
			width: 30px;
			height: 30px;
			border-radius: 30px;
			display: inline-block;
			cursor: pointer;
		}
		.userData img{
			width: 30px;
			height: 30px;
			border-radius: 30px;
		}
		.userData .name{
			display: inline-block;
			margin: 0px 10px;
			margin-left: 40px;
			top: 10px;
			cursor: pointer;
			color: #7aa4a9;
		}
		.userData .name:hover{
			color: blueviolet;
			border-bottom: 1px solid blueviolet;
		}
		.userData .day{
			display: inline-block;
			margin-top: 6px;
			padding-left: 13px;
			color: #8a8a8a;
			border-left: 1px solid #C2BE9E;
		}
		.userData .read{
			position: absolute;
			right: 10px;
			bottom: 0px;
			width: 110px;
			color: #8a8a8a;
		}
		.index #right{
        	width: 270px;
        	display: inline-block;
        	background-color: #F5F6F7;
			position: absolute;
			margin-left: 10px;
        }
        .index #right .advertising-right{
        	height: 100px;
        	width: 100%;
        	position: relative;
        	background-color: #FFFFFF;
        }
        .index #right .advertising-right img{
        	height: 100%;
			width: 100%;
        	position: absolute;
        	top: 0px;
        }
        .index #right .right-box{
			position: relative;	
			top: 10px;
			width: 100%;
        }
        .right-box .tj{
			padding: 20px 0px;
			background-color: #FFFFFF;
			width: 260px;
			padding-left: 10px;
			position: absolute;
        }
        #right .right-box ul{
        	position: absolute;
        	top: 50px;
			list-style: none;
			width: 100%;
			background-color: #FFFFFF;
			margin: 0px;
			padding: 0px;
			margin-bottom: 20px;
        }
        #right .right-box ul li{
        	margin-bottom: 16px;
    		height: 50px;
        }
        .advertising-item{
        	position: relative;
        	height: 100%;
        	width: 100%;
			padding-left: 8px;
        }
        
        .advertising-item .img{
        	width: 70px;
        	height: 50px;
        	line-height: 50px;
        	display: inline-block;
        	position: absolute;
        	top: 10px;
			cursor: pointer;
        }
        .advertising-item .img img{
        	width: 70px;
        	height: 50px;
        	vertical-align: middle;
        	border-radius: 6px;
        }
        .advertising-item .text{
        	height:50px;
        	width:180px;
        	display:inline-block;
        	word-break:break-all;
        	position: absolute;
        	top: 10px;
        	left: 85px;
        }
        .advertising-item .text span{
        	display:table-cell;
        	vertical-align:middle;  	   
   			margin-bottom: 3px;
  			font-size: 15px;
    		color: #3d3d3d;
 			letter-spacing: 0;
   			line-height: 22px;
  			max-width: 200px;
  			overflow: hidden;
   		 	cursor: pointer;
   		 	font-weight: bold;
        }
        .right-box .text2{
        	margin-top: 40px; 
        	border-top: 1px solid #C2BE9E; 
        	text-align: center; 
        	line-height: 60px;
        	color: blueviolet;
        }
    </style>
</head>
<body>

<#include "index_top.ftl">

<div class="index">

    	<div id="left" title="${title}">
    		<!-- 栏目分类列表 -->
    		<ul>
    			<#list list_programa as programa>
					<li class="item" onclick="P.herfLo(${programa.id})">
						<a>${programa.name}</a>
					</li>
    			</#list>
    		</ul>
			<div class="">
			</div>
   		</div>

	<!--	变动区域		-->
   	<div class="content">
   		<div class="advertising-top">
   			<img src="static/img/t2.jpg"/>
   		</div>
   		<ul class="article-list">
   			<#list list_article as article>
				<li class="clerfix">
					<div class="title">
						<h2><a href="article/read/${article.id}.html">${article.title}</a></h2>
					</div>
					<div class="syponsis">${article.synopsis}</div>
					<div class="userData">
						<div class="img">
							<img src="${article.user.head_portrait}" onclick="M.loadUserPage('${article.user_id}')"/>
						</div>
						<div class="name" onclick="M.loadUserPage('${article.user_id}')">${article.user.username}</div>
						<div class="day">
							<label>${article.pastTime}</label>
						</div>
						<div class="read">阅读量：${article.read_count}</div>
					</div>
   				</li>
            </#list>
   		</ul>
   	</div>

   	<div id="right">
   		<div class="advertising-right">
   			<img src="static/img/ttt.gif"/>
   		</div>
   		<div class="advertising-right" style="height: 200px; margin-top: 10px;">
   			<img src="static/img/t4.jpg" style="height: 100%;"/>
   		</div>
   		
   		<div class="right-box">
   			<div class="tj">
   				<span style="border-left: 3px solid blueviolet;"></span>
   				<span style="margin-left: 10px;">今日推荐</span>
   			</div>
   			<ul>
   				<#list articles as art>
					<li>
						<div class="advertising-item">
							<div class="img">
								<img src="${art.user.head_portrait}" onclick="P.loadUserPage(${art.user_id})"/>
							</div>
							<div class="text">
								<span>
									<a href="/article/read/${art.id}.html">${art.title}</a>
								</span>
							</div>
						</div>
					</li>
   				</#list>
   				<li>
   					<div class="text2">
   						阿薛出品
   					</div>
   				</li>
   			</ul>
   		</div>
   	</div>

</div>
<script>
	var P = {};

	P.loadUserPage = function(userId){
		location.href = "userPage/" + userId + ".html";
	}

	P.herfLo = function (id) {
		location.href = "article/list/" + id;
	}

	P.addTitleColor = function () {
		var title = $('#left').attr("title");
		var as = $('#left a');
		for(var i=0; i<as.length; i++){
			var text = as[i].text;
			if(text == title){
				var li = $(as[i]).parent().addClass('color');
			}
		}
	}
	P.addTitleColor();
		/*window.onload=
        function(){
            var oDiv = document.getElementById("left"),
                H = 0,
                Y = oDiv        
            while (Y) {
                H += Y.offsetTop; 
                Y = Y.offsetParent;
            }
            window.onscroll = function()
            {
                var s = document.body.scrollTop || document.documentElement.scrollTop
                if(s>H) {
                    oDiv.style = "position:fixed; top:0;"
                } else {
                    oDiv.style = ""
                }
            }
        }*/
</script>
</body>

<script>
	var M = {};
	M.loadUserPage = function (id) {
		location.href = "userPage/" + id + ".html";
	}

</script>
</html>
