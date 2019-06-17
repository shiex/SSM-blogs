package com.xbb.pojo;

import java.util.Date;

public class Reply
{ 
 
	public Integer id ; 
	public Integer comment_id ;
	public Integer user_id;
	public String username;
	public String head_portrait;
	public Integer by_user_id ;
	public String by_username ;	// 被回复者姓名
	public String content ;
	public Date reply_time ;
	public User user;


	public void setId(Integer id)
	{
		this.id=id;
	}
	public Integer getId()
	{
		return this.id;
	}
	public void setComment_id(Integer comment_id)
	{
		this.comment_id=comment_id;
	}
	public Integer getComment_id()
	{
		return this.comment_id;
	}
	public void setBy_username(String by_username)
	{
		this.by_username=by_username;
	}
	public void setContent(String content)
	{
		this.content=content;
	}
	public String getContent()
	{
		return this.content;
	}

	public Integer getBy_user_id() {
		return by_user_id;
	}

	public void setBy_user_id(Integer by_user_id) {
		this.by_user_id = by_user_id;
	}

	public String getBy_username() {
		return by_username;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public Date getReply_time() {
		return reply_time;
	}

	public void setReply_time(Date reply_time) {
		this.reply_time = reply_time;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getHead_portrait() {
		return head_portrait;
	}

	public void setHead_portrait(String head_portrait) {
		this.head_portrait = head_portrait;
	}
}
 