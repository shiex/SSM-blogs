package com.xbb.pojo;

public class Appluad
{ 
 
	public Integer id ; 
	public Integer user_id ; 
	public Integer comment_id ;
	public Integer article_id;
	public Boolean status ;

	public void setId(Integer id)
	{
		this.id=id;
	}
	public Integer getId()
	{
		return this.id;
	}
	public void setUser_id(Integer user_id)
	{
		this.user_id=user_id;
	}
	public Integer getUser_id()
	{
		return this.user_id;
	}
	public void setComment_id(Integer comment_id)
	{
		this.comment_id=comment_id;
	}
	public Integer getComment_id()
	{
		return this.comment_id;
	}
	public void setStatus(Boolean status)
	{
		this.status=status;
	}
	public Boolean getStatus()
	{
		return this.status;
	}

	public Integer getArticle_id() {
		return article_id;
	}

	public void setArticle_id(Integer article_id) {
		this.article_id = article_id;
	}

}
 