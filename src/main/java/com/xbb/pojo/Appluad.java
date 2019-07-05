package com.xbb.pojo;

public class Appluad
{ 
 
	public Integer id ; 
	public Integer userId ;
	public Integer commentId ;
	public Integer articleId;
	public Boolean status ;

	public void setId(Integer id)
	{
		this.id=id;
	}
	public Integer getId()
	{
		return this.id;
	}
	public void setStatus(Boolean status)
	{
		this.status=status;
	}
	public Boolean getStatus()
	{
		return this.status;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getCommentId() {
		return commentId;
	}

	public void setCommentId(Integer commentId) {
		this.commentId = commentId;
	}

	public Integer getArticleId() {
		return articleId;
	}

	public void setArticleId(Integer articleId) {
		this.articleId = articleId;
	}
}
 