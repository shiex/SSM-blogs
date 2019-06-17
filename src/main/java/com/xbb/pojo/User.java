package com.xbb.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class User implements Serializable {
 
	public Integer id ; 
	public String username ; 
	public String password ; 
	public String head_portrait ; 
	public String imgs_file_url ;
	public String cellphone ;
	public String mailbox ; 
	public Integer vip_id ; 
	public Date register_time ; 
	public Short original_count ;
	public Integer follow_count;
	public Integer fans_count ;
	public Integer visit_count;
	public String theme_photo;
	public String data_photo;
	public String signature;
	public String speciality;
	public String pas;
	public Boolean sex;

	public List<Article> articles;

	public void setId(Integer id)
	{
		this.id=id;
	}
	public Integer getId()
	{
		return this.id;
	}
	public void setUsername(String username)
	{
		this.username=username;
	}
	public String getUsername()
	{
		return this.username;
	}
	public void setPassword(String password)
	{
		this.password=password;
	}
	public String getPassword()
	{
		return this.password;
	}
	public void setHead_portrait(String head_portrait)
	{
		this.head_portrait=head_portrait;
	}
	public String getHead_portrait()
	{
		return this.head_portrait;
	}

	public String getImgs_file_url() {
		return imgs_file_url;
	}

	public void setImgs_file_url(String imgs_file_url) {
		this.imgs_file_url = imgs_file_url;
	}

	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	public void setMailbox(String mailbox)
	{
		this.mailbox=mailbox;
	}
	public String getMailbox()
	{
		return this.mailbox;
	}
	public void setVip_id(Integer vip_id)
	{
		this.vip_id=vip_id;
	}
	public Integer getVip_id()
	{
		return this.vip_id;
	}
	public void setRegister_time(Date register_time)
	{
		this.register_time=register_time;
	}
	public Date getRegister_time()
	{
		return this.register_time;
	}

	public Integer getVisit_count() {
		return visit_count;
	}

	public String getTheme_photo() {
		return theme_photo;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public void setTheme_photo(String theme_photo) {
		this.theme_photo = theme_photo;
	}

	public String getData_photo() {
		return data_photo;
	}

	public void setData_photo(String data_photo) {
		this.data_photo = data_photo;
	}

	public void setVisit_count(Integer visit_count) {
		this.visit_count = visit_count;
	}

	public Short getOriginal_count() {
		return original_count;
	}

	public void setOriginal_count(Short original_count) {
		this.original_count = original_count;
	}

	public Integer getFollow_count() {
		return follow_count;
	}

	public void setFollow_count(Integer follow_count) {
		this.follow_count = follow_count;
	}

	public Integer getFans_count() {
		return fans_count;
	}

	public void setFans_count(Integer fans_count) {
		this.fans_count = fans_count;
	}

	public Boolean getSex() {
		return sex;
	}

	public void setSex(Boolean sex) {
		this.sex = sex;
	}

	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}

	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

	public String getPas() {
		return pas;
	}

	public void setPas(String pas) {
		this.pas = pas;
	}
}
 