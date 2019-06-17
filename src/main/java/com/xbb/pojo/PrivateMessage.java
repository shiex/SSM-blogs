package com.xbb.pojo;

import java.util.Date;

public class PrivateMessage 
{ 
 
	public Integer id ; 
	public Integer send_id ; 
	public Integer receive_id ; 
	public String content ; 
	public Date send_time ; 
	public Date receive_time ; 
	public Integer ke_send_id ; 
	public Integer ke_receive_id ; 
	public Boolean remove_content ; 


	public void setId(Integer id)
	{
		this.id=id;
	}
	public Integer getId()
	{
		return this.id;
	}
	public void setSend_id(Integer send_id)
	{
		this.send_id=send_id;
	}
	public Integer getSend_id()
	{
		return this.send_id;
	}
	public void setReceive_id(Integer receive_id)
	{
		this.receive_id=receive_id;
	}
	public Integer getReceive_id()
	{
		return this.receive_id;
	}
	public void setContent(String content)
	{
		this.content=content;
	}
	public String getContent()
	{
		return this.content;
	}
	public void setSend_time(Date send_time)
	{
		this.send_time=send_time;
	}
	public Date getSend_time()
	{
		return this.send_time;
	}
	public void setReceive_time(Date receive_time)
	{
		this.receive_time=receive_time;
	}
	public Date getReceive_time()
	{
		return this.receive_time;
	}
	public void setKe_send_id(Integer ke_send_id)
	{
		this.ke_send_id=ke_send_id;
	}
	public Integer getKe_send_id()
	{
		return this.ke_send_id;
	}
	public void setKe_receive_id(Integer ke_receive_id)
	{
		this.ke_receive_id=ke_receive_id;
	}
	public Integer getKe_receive_id()
	{
		return this.ke_receive_id;
	}
	public void setRemove_content(Boolean remove_content)
	{
		this.remove_content=remove_content;
	}
	public Boolean getRemove_content()
	{
		return this.remove_content;
	}

} 
 