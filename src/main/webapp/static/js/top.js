var T = {};
T.findArticle = function () {
    var antistop = $('.top .antistop').val().trim();
    if(antistop == null || antistop.length < 1){
        layer.msg('请输入关键词');
        return;
    }
    location.href = "article/find/top/" + antistop;
}
if(user != null)
{
    $('.top .loginOut').hide();
    $('.top .login').show();
    $('.top .layui-nav-img').attr("src", user.head_portrait);
    $('.top .top-username').text(user.username);
}
else
{
    $('.top .loginOut').show();
    $('.top .login').hide();
}
layui.use('element', function(){
    var element = layui.element;

    //一些事件监听
    element.on('tab(demo)', function(data){
        console.log(data);
    });
    element.init();
    element.render('nav');
});