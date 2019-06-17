package com.xbb.pojo;

import java.util.Date; 

public class Friend 
{ 
 
	public Integer id ; 
	public Integer user_id ; 
	public Integer friend_id ; 


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
	public void setFriend_id(Integer friend_id)
	{
		this.friend_id=friend_id;
	}
	public Integer getFriend_id()
	{
		return this.friend_id;
	}

} 
 