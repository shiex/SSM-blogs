<style>
	.load-content .user-fans{
		min-height: 545px;
		background-color: #ffffff;
		width: 100%;
	}
	.user-fans .fans-top{
		height: 50px;
		font-size: .75em;
		color: #333;
		line-height: 50px;
		background: #fff;
		box-shadow: 0 2px 4px 0 rgba(0,0,0,.05);
		width: 100%;
		box-sizing: border-box;
		-moz-box-sizing: border-box;
		-webkit-box-sizing: border-box;
		position: relative;
		padding: 0 28px 0 27px;
	}
	.fans-top .my-fans{
		font-family: "楷体";
		font-size: 28px;
		display: inline-block;
		line-height: 40px;
		margin-top: 4px;
		display: inline-block;
	}
	.user-fans .u-fans{
		margin-top: 15px;
		width: 100%;
	}
	.u-fans .fans{
		height: 50px;
		width: 420px;
		padding: 10px 25px;
		padding-right: 0px;
		margin-bottom: 10px;
		position: relative;
		display: inline-block;
		margin-left: 35px;
		border: 1px solid #c1a9a9;
		border-radius: 20px;
		box-shadow: 1px 1px 1px 1px #e4d6d6;
	}
	.fans .fans-img{
		width: 50px;
		height: 50px;
		display: inline-block;
	}
	.fans .fans-img img{
		width: 50px;
		height: 50px;
		border-radius: 50%;
		cursor: pointer;
	}
	.fans .fans-name{
		font-size: 18px;
		font-family: "楷体";
		position: absolute;
		left: 90px;
		top: 25px;
		cursor: pointer;
	}
	.fans .fans-cancel{
		position: absolute;
		right: 15px;
		top: 25px;
	}
	.fans button{
		background-color: #ffffff;
		padding: 2px 4px;
		border: 1px solid blueviolet;
		border-radius: 4px;
		color: #888888;
		cursor: pointer;
		width: 80px;
	}
	.fans button:hover{
		background-color: bisque;
		padding: 2px 4px;
		border: 1px solid #4476A7;
		border-radius: 4px;
	}
</style>

<div class="user-fans">
	<div class="fans-top">
		<div class="my-fans">粉丝列表</div>
	</div>
	<div class="u-fans">

	</div>
</div>

<script type="text/html" id="tmp-fans">
	{{each fanss as fans}}
	<div class="fans">
		<div class="fans-img">
			<img src="{{fans.head_portrait}}" onclick="M.loadUserPage({{fans.id}})"/>
		</div>
		<label class="fans-name" onclick="M.loadUserPage({{fans.id}})"> {{fans.username}} </label>
	</div>
	{{/each}}
</script>

<script>

	// 进入用户个人主页
	M.loadUserPage = function(userId){
		location.href = "userPage/" + userId + ".html";
	}

	M.initFans = function () {
		Af.rest("fans.all", user.id, function (data) {
			var fansData = {
				fanss:data
			};
			var fansHtml = template('tmp-fans',fansData);
			$('.u-fans').append(fansHtml);
		});
	}

	M.initFans();
	M.selectCalss('查看粉丝');
	//# sourceURL=user_fans.js
</script>

