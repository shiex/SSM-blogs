package com.xbb.pojo;

import java.util.Date;

public class Comment
{ 
 
	public Integer id ; 
	public Integer article_id ; 
	public Integer user_id ; 
	public String username ; 
	public String comment ;
	public Date comment_time;
	public Integer appluad_count;
	public Integer reply_count;
	public User user;

	public Integer status = 0; // 判断是否点赞，默认为未点赞
	public Integer isRemove; // 是否可以进行删除（仅用户删除发表评论）

	public void setId(Integer id)
	{
		this.id=id;
	}
	public Integer getId()
	{
		return this.id;
	}
	public void setArticle_id(Integer article_id)
	{
		this.article_id=article_id;
	}
	public Integer getArticle_id()
	{
		return this.article_id;
	}
	public void setUser_id(Integer user_id)
	{
		this.user_id=user_id;
	}
	public Integer getUser_id()
	{
		return this.user_id;
	}
	public void setUsername(String username)
	{
		this.username=username;
	}
	public String getUsername()
	{
		return this.username;
	}
	public void setComment(String comment)
	{
		this.comment=comment;
	}
	public String getComment()
	{
		return this.comment;
	}

	public Integer getAppluad_count() {
		return appluad_count;
	}

	public void setAppluad_count(Integer appluad_count) {
		this.appluad_count = appluad_count;
	}

	public void setReply_count(Integer reply_count) {
		this.reply_count = reply_count;
	}

	public Date getComment_time() {
		return comment_time;
	}

	public void setComment_time(Date comment_time) {
		this.comment_time = comment_time;
	}

	public int getReply_count() {
		return reply_count;
	}

	public void setReply_count(int reply_count) {
		this.reply_count = reply_count;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
}
 