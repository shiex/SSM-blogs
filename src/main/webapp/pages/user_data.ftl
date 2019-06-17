<style>
	.index .load-content .user-data{
		height: 100%;
		background-color: #ffffff;
		width: 100%;
	}
	.user-data .layui-form{
		position: absolute;
		top: 70px;
		width: 100%;
	}
	.user-data .data-top{
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
	.data-top .my-data{
		font-family: "楷体";
		font-size: 28px;
		display: inline-block;
		line-height: 40px;
		margin-top: 4px;
		display: inline-block;
	}
	.data-top .button{
		display: inline-block;
		position: absolute;
		top: 2px;
		right: 25px;
	}
	.data-top a{
		background-color: #ffffff;
		border: 1px solid #888888;
		padding: 2px 4px;
	}
	.data-top button{
		background-color: #ded5e4;
		border: 1px solid #888888;
		padding: 4px 6px;
		margin-left: 20px;
		cursor: pointer;
		border-radius: 4px;
	}
	.data-top button:hover{
		background-color: #9F9F9F;
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
	.dig .form2{
		background-color: #ffffff;
		width: 700px;
		padding: 20px 18px;
		padding-top: 30px;
		margin: auto;
		margin-top: 30px;
	}
	.layui-form-item{
		margin-left: 45px;
	}
	.user-data .lable2 {
		text-align: left;
	}
	.dig .layui-form .layui-input-block .u-img-botton{
		margin-left: 7px;
		position: absolute;
		bottom: 0px;
		background-color: beige;
		border: 1px solid #888888;
		padding: 2px 4px;
		border-radius: 4px;
		cursor: pointer;
	}

	.dig .layui-form .layui-input-block .u-img-botton:hover{
		background-color: #a0cbec;
		border: 1px solid #6FA5DB;
	}
</style>

<div class="user-data">
	<div class="data-top">
		<div class="my-data">个人资料</div>
		<div class="button">
			<button onclick="M.loadUserPage()"> 查看个人主页 </button>
			<button onclick="M.showDiglog()"> 编辑资料 </button>
		</div>
	</div>
	<div id='info' class="layui-form" style="margin-top: 50px">
		<div class="layui-form-item">
			<label class="layui-form-label">昵称：</label>
			<label class="layui-form-label" name="username" style="text-align: left; width: 300px" ></label>
		</div>
		<div class="layui-form-item" style="position: relative">
			<label class="layui-form-label">头像：</label>
			<div class="layui-input-block">
				<img src="static/img/ph.png" class="u-img" style="width: 80px; height: 80px; cursor: pointer"><br>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">性别：</label>
			<label class="layui-form-label" name='sex2'style="text-align: left;"></label>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">个人介绍：</label>
			<label class="layui-form-label" name="signature"
				   style="text-align: left; width: 500px">
			</label>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">技术特长：</label>
			<label class="layui-form-label" name="speciality"
				   style="text-align: left;"></label>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">联系方式：</label>
			<label class="layui-form-label" name="cellphone"
				   style="text-align: left;"></label>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">常用邮箱：</label>
			<label class="layui-form-label" name='mailbox'
				   style="text-align: left;"></label>
		</div>
	</div>
</div>

<div class="dig">
	<div id='info' class="layui-form form2" lay-filter="formTest">
		<div class="layui-form-item">
			<label class="layui-form-label">昵称</label>
			<div class="layui-input-block">
				<input class="layui-input d-username" name="username" style="width: 200px;">
			</div>
		</div>
		<div class="layui-form-item">
			<input type="file" class="filebutton" style="display: none;"/>
			<label class="layui-form-label">头像</label>
			<div class="layui-input-block">
				<img src='static/img/ph.png' class="d-img" style="width: 80px; height: 80px;">
				<button onclick="U.upImgPhoto()" class="u-img-botton">修改头像</button>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">性别</label>
			<div class="layui-input-block">
				<input type="radio" name="sex" value="true" title="男">
				<input type="radio" name="sex" value="false" title="女">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">个人介绍</label>
			<div class="layui-input-block" style="width: 500px;">
				<textarea name="signature" required lay-verify="required"
						  placeholder="200字以内" class="layui-textarea d-signature">

				</textarea>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">技术特长</label>
			<div class="layui-input-block" style="width: 130px;">
				<select class="ke" name="speciality">
					<option value="Java">Java</option>
					<option value="C++">C++</option>
					<option value="C">C</option>
					<option value="Python">Python</option>
					<option value="Go">Go</option>
					<option value="PHP">PHP</option>
					<option value="JavaScript">JavaScript</option>
				</select>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label" >联系方式</label>
			<div class="layui-input-inline" style="width: 200px;">
				<input class="layui-input d-cellphone" name='cellphone'>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label" >常用邮箱</label>
			<div class="layui-input-inline" style="width: 200px;">
				<input class="layui-input d-mailbox" name='mailbox'>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label" ></label>
			<button class='layui-btn layui-btn-normal' lay-submit lay-filter="formDemo"> 提交 </button>
			<button class='layui-btn layui-btn-normal' onclick='M.do_call(this)'> 取消 </button>
		</div>
	</div>
</div>

<script>

	var U = {};

	U.init = function(){
		// 创建FileUpload对象，设置按钮触发事件以及上传回调事件
		U.uploadfile = new AfFileUploader();
		U.uploadfile.setButton('.dig .filebutton').setObserver(this);
	}

	U.upImgPhoto = function(){
		// 设置请求接口，显示文件复选框
		U.uploadfile.setUploadUrl('user/uploadPhoto/0');
		U.uploadfile.openFileDialog();
	}

	U.uploadHandleEvent = function(msg, uploader)
	{
		// 上传完成后的回调时间
		if(msg == 'complete')
		{
			// 设置图片路径
			var imgUrl = uploader.response.data.imgUrl;
			$('.dig .d-img').attr('src', imgUrl);
		}
	}

	U.init();

	// 弹出编辑对话框，自动填充属性为name的数据
	M.showDiglog = function () {
		if(user != null)
		{
			layui.use('form', function(){
				if(user.sex){
					$(".dig [title=男]").prop('checked', true);
				}else {
					$(".dig [title=女]").prop('checked', true);
				}
				if(user.head_portrait != null && user.head_portrait != ''){
					$('.layui-form .d-img').attr("src", user.head_portrait);
				}else {
					$('.layui-form .d-img').attr("src", "static/img/ph.png");
				}
				var form = layui.form;
				form.val("formTest", {
					"username": user.username,
					"mailbox":user.mailbox,
					"cellphone":user.cellphone,
					"speciality":user.speciality,
					"signature":user.signature
				})
			});
		}
		$('.dig').show();
	}

	// 关闭对话框
	M.do_call = function (e) {
		var dig = $(e).parent().parent().parent();
		var imgUrl = $('.d-img', dig).attr('src');
		if(imgUrl.length > 1){
			if(imgUrl != user.head_portrait){
				Af.rest("updata.call", imgUrl, function (data) {
					$('.d-img', dig).attr('src', '');
				});
			}
		}
		$('.dig').hide();
	}

	// 当点击提交时触发事件，data.field自动提取name属性数据
	layui.use('form', function(){
			var form = layui.form;
			//监听提交
			form.on('submit(formDemo)', function(data){
				var req = data.field;
				if(req.username == null || req.username == ""){
					layer.msg('名称不得为空');
					return;
				}
				req.id = user.id; // 用户ID以及图片路径自行处理
				req.head_portrait = $('.dig .d-img').attr('src');
				Af.rest("user/updata", req, function (upUser) {
					this.user = upUser;  // 更新user数据
					$('.top .top-username').text(upUser.username);
					M.initUserData();
					$('.dig').hide(); // 关闭对话框
				});
			});
	});

	// 跳转到用户个人主页
	M.loadUserPage = function(){
		location.href = "userPage/" + user.id + ".html";
	}

	M.initUserData = function(){
		if(user != null)
		{
			if(user.head_portrait != null && user.head_portrait != ''){
				$('.layui-form .u-img').attr("src", user.head_portrait);
				$('.top .layui-nav-img').attr("src", user.head_portrait);
			}
			var from = new AfForm('.user-data');
			user.sex2 = user.sex?'男':'女';
			from.set(user);
		}
	}

	M.initUserData(); // 初始化user数据
	M.selectCalss('个人资料');
	layui.form.render();  // 渲染控件
	//# sourceURL=user_data.js
</script>
