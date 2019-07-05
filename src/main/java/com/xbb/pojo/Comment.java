package com.xbb.pojo;

import java.util.Date;

public class Comment
{ 
 
	public Integer id ; 
	public Integer articleId ;
	public Integer userId ;
	public String comment ;
	public Date commentTime;
	public Integer appluadCount;
	public Integer replyCount;

	public User user;
	public Integer status; // 是否点赞

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getArticleId() {
		return articleId;
	}

	public void setArticleId(Integer articleId) {
		this.articleId = articleId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Date getCommentTime() {
		return commentTime;
	}

	public void setCommentTime(Date commentTime) {
		this.commentTime = commentTime;
	}

	public Integer getAppluadCount() {
		return appluadCount;
	}

	public void setAppluadCount(Integer appluadCount) {
		this.appluadCount = appluadCount;
	}

	public Integer getReplyCount() {
		return replyCount;
	}

	public void setReplyCount(Integer replyCount) {
		this.replyCount = replyCount;
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
 