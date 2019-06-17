package com.xbb.pojo;

import java.util.Date;

public class Article 
{ 
 
	public Integer id ; 
	public String title ; 
	public String content ;
	public Date issue_time ; 
	public Integer read_count ;
	public Boolean original ; 
	public Integer user_id ; 
	public Integer programa_id ;
	public String read_url;
	public String synopsis;
	public Boolean stick;

	public User user;		// 用户信息
	public String imgUrls;	// 上传图片
	public String pastTime ;	// 发布时间到现在的过去时间（分、时、天、月）

	public void setId(Integer id)
	{
		this.id=id;
	}
	public Integer getId()
	{
		return this.id;
	}
	public void setTitle(String title)
	{
		this.title=title;
	}
	public String getTitle()
	{
		return this.title;
	}
	public void setContent(String content)
	{
		this.content=content;
	}
	public String getContent()
	{
		return this.content;
	}
	public void setIssue_time(Date issue_time)
	{
		this.issue_time=issue_time;
	}
	public Date getIssue_time()
	{
		return this.issue_time;
	}
	public void setOriginal(Boolean original)
	{
		this.original=original;
	}
	public Boolean getOriginal()
	{
		return this.original;
	}
	public void setUser_id(Integer user_id)
	{
		this.user_id=user_id;
	}
	public Integer getUser_id()
	{
		return this.user_id;
	}
	public void setPrograma_id(Integer programa_id)
	{
		this.programa_id=programa_id;
	}
	public Integer getPrograma_id()
	{
		return this.programa_id;
	}

	public Boolean getStick() {
		return stick;
	}

	public void setStick(Boolean stick) {
		this.stick = stick;
	}

	public String getSynopsis() {
		return synopsis;
	}
	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}
	public User getUser() {
		return user;
	}

	public Integer getRead_count() {
		return read_count;
	}

	public void setRead_count(Integer read_count) {
		this.read_count = read_count;
	}

	public String getRead_url() {
		return read_url;
	}

	public void setRead_url(String read_url) {
		this.read_url = read_url;
	}

	public void setUser(User user) {
		this.user = user;
	}
	public String getImgUrls() {
		return imgUrls;
	}
	public void setImgUrls(String imgUrls) {
		this.imgUrls = imgUrls;
	}

	public String getPastTime() {
		return pastTime;
	}

	public void setPastTime(String pastTime) {
		this.pastTime = pastTime;
	}

}
 