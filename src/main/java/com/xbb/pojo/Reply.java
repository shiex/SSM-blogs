package com.xbb.pojo;

import java.util.Date;

public class Reply
{ 
 
	public Integer id ; 
	public Integer commentId ;
	public Integer userId;
	public String username;
	public String headPhoto;
	public Integer byUserId ;
	public String byUsername ;	// 被回复者姓名
	public String content ;
	public Date replyTime ;
	public User user;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCommentId() {
		return commentId;
	}

	public void setCommentId(Integer commentId) {
		this.commentId = commentId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getHeadPhoto() {
		return headPhoto;
	}

	public void setHeadPhoto(String headPhoto) {
		this.headPhoto = headPhoto;
	}

	public Integer getByUserId() {
		return byUserId;
	}

	public void setByUserId(Integer byUserId) {
		this.byUserId = byUserId;
	}

	public String getByUsername() {
		return byUsername;
	}

	public void setByUsername(String byUsername) {
		this.byUsername = byUsername;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getReplyTime() {
		return replyTime;
	}

	public void setReplyTime(Date replyTime) {
		this.replyTime = replyTime;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
 