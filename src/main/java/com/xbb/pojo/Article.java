package com.xbb.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Article implements Cloneable, Serializable
{
	public Integer id ; 
	public String title ;
	public String titleShow;
	public String content ;
	public Date issueTime ;
	public Integer readCount ;
	public Boolean original ; 
	public Integer userId ;
	public Integer programaId ;
	public String readUrl;
	public String synopsis;
	public Boolean stick;

	public List<Comment> commentList; // 评论列表
	public User user;		// 用户信息
	public String programaName; // 分类名称
	public Integer isCollect; // 是否收藏
	public Integer isAttention; // 是否关注
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
	public void setOriginal(Boolean original)
	{
		this.original=original;
	}
	public Boolean getOriginal()
	{
		return this.original;
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

	public Date getIssueTime() {
		return issueTime;
	}

	public void setIssueTime(Date issueTime) {
		this.issueTime = issueTime;
	}

	public Integer getReadCount() {
		return readCount;
	}

	public void setReadCount(Integer readCount) {
		this.readCount = readCount;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getProgramaId() {
		return programaId;
	}

	public void setProgramaId(Integer programaId) {
		this.programaId = programaId;
	}

	public String getReadUrl() {
		return readUrl;
	}

	public void setReadUrl(String readUrl) {
		this.readUrl = readUrl;
	}

	public User getUser() {
		return user;
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
	public String getProgramaName() {
		return programaName;
	}
	public void setProgramaName(String programaName) {
		this.programaName = programaName;
	}

	public Integer getIsCollect() {
		return isCollect;
	}

	public void setIsCollect(Integer isCollect) {
		this.isCollect = isCollect;
	}

	public List<Comment> getCommentList() {
		return commentList;
	}

	public void setCommentList(List<Comment> commentList) {
		this.commentList = commentList;
	}

	public String getTitleShow() {
		return titleShow;
	}

	public void setTitleShow(String titleShow) {
		this.titleShow = titleShow;
	}

	public Integer getIsAttention() {
		return isAttention;
	}

	public void setIsAttention(Integer isAttention) {
		this.isAttention = isAttention;
	}

	@Override
	public Object clone() {
		Article article = null;
		try{
			article = (Article) super.clone();
		}catch (CloneNotSupportedException e){
			e.printStackTrace();
		}
		return article;
	}
}

 