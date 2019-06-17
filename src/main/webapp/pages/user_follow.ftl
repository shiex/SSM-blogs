<style>
	.load-content .user-follow{
		min-height: 545px;
		background-color: #ffffff;
		width: 100%;
	}
	.user-follow .follow-top{
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
	.follow-top .my-follow{
		font-family: "楷体";
		font-size: 28px;
		display: inline-block;
		line-height: 40px;
		margin-top: 4px;
		display: inline-block;
	}
	.user-follow .u-follow{
		margin-top: 15px;
		width: 100%;
	}
	.u-follow .follow{
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
	.follow .follow-img{
		width: 50px;
		height: 50px;
		display: inline-block;
		margin-right: 10px;
	}
	.follow .follow-img img{
		width: 50px;
		height: 50px;
		border-radius: 50%;
		cursor: pointer;
	}
	.follow .follow-name{
		font-size: 18px;
		font-family: "楷体";
		position: absolute;
		left: 90px;
		top: 25px;
		cursor: pointer;
	}
	.follow .follow-cancel{
		position: absolute;
		right: 15px;
		top: 25px;
	}
	.follow button{
		background-color: #ffffff;
		padding: 2px 4px;
		border: 1px solid blueviolet;
		border-radius: 4px;
		color: #888888;
		cursor: pointer;
		width: 80px;
	}
	.follow button:hover{
		background-color: bisque;
		padding: 2px 4px;
		border: 1px solid #4476A7;
		border-radius: 4px;
	}
</style>

<div class="user-follow">
	<div class="follow-top">
		<div class="my-follow">关注列表</div>
	</div>
	<div class="u-follow">

	</div>
</div>

<script type="text/html" id="tmp-follow">
	{{each follows as follow}}
	<div class="follow">
		<div class="follow-img">
			<img src="{{follow.head_portrait}}" onclick="M.loadUserPage({{follow.id}})"/>
		</div>
		<label class="follow-name" onclick="M.loadUserPage({{follow.id}})"> {{follow.username}} </label>
		<button onclick="M.follow(this, {{follow.id}})" class="follow-cancel" isFollow="1"> 取消关注</button>
	</div>
	{{/each}}
</script>

<script>

	// 进入用户个人主页
	M.loadUserPage = function(userId){
		location.href = "userPage/" + userId + ".html";
	}

	// 点击关注
	M.follow = function(e, userId){

		var isFollow = $(e).attr('isFollow');
		if(isFollow == 1){
			$(e).attr('isFollow', 0);
			$(e).text('关注');
		}else {
			$(e).attr('isFollow', 1);
			$(e).text('取消关注');
		}

		var req = {};
		req.follow_id = userId;
		Af.rest("follow.add", req, function (data) {

		}) ;
	}

	M.initFollow = function () {
		Af.rest("follow.all", user.id, function (data) {
			/*M.loadArticle(data);*/
			var followData = {
				follows:data
			};
			var followHtml = template('tmp-follow',followData);
			$('.u-follow').append(followHtml);
		});
	}

	M.initFollow();
	M.selectCalss('查看关注');
	//# sourceURL=user_follow.js
</script>

