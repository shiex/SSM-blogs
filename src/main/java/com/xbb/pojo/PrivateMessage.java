package com.xbb.pojo;

import java.util.Date;

public class PrivateMessage 
{ 
 
	public Integer id ; 
	public Integer sendId ;
	public Integer receiveId ;
	public String content ; 
	public Date sendTime ;
	public Date receiveTime ;
	public Integer keSendId ;
	public Integer keReceiveId ;
	public Boolean removeContent ;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getSendId() {
		return sendId;
	}

	public void setSendId(Integer sendId) {
		this.sendId = sendId;
	}

	public Integer getReceiveId() {
		return receiveId;
	}

	public void setReceiveId(Integer receiveId) {
		this.receiveId = receiveId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getSendTime() {
		return sendTime;
	}

	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}

	public Date getReceiveTime() {
		return receiveTime;
	}

	public void setReceiveTime(Date receiveTime) {
		this.receiveTime = receiveTime;
	}

	public Integer getKeSendId() {
		return keSendId;
	}

	public void setKeSendId(Integer keSendId) {
		this.keSendId = keSendId;
	}

	public Integer getKeReceiveId() {
		return keReceiveId;
	}

	public void setKeReceiveId(Integer keReceiveId) {
		this.keReceiveId = keReceiveId;
	}

	public Boolean getRemoveContent() {
		return removeContent;
	}

	public void setRemoveContent(Boolean removeContent) {
		this.removeContent = removeContent;
	}
}
 