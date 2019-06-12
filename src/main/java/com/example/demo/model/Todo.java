package com.example.demo.model;

import java.util.Date;

import javax.validation.constraints.Size;

public class Todo {

	public Integer id;
	public String user;
	
	@Size(min=5,message="Enter at least 5 characters...")
	public String desc;
	public Date targetDate;
	public Boolean isDone;
	
	
	public Todo() {
		super();
	}

	public Todo(Integer id, String user, String desc, Date targetDate, Boolean isDone) {
		super();
		this.id = id;
		this.user = user;
		this.desc = desc;
		this.targetDate = targetDate;
		this.isDone = isDone;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the user
	 */
	public String getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(String user) {
		this.user = user;
	}

	/**
	 * @return the desc
	 */
	public String getDesc() {
		return desc;
	}

	/**
	 * @param desc the desc to set
	 */
	public void setDesc(String desc) {
		this.desc = desc;
	}

	/**
	 * @return the targetDate
	 */
	public Date getTargetDate() {
		return targetDate;
	}

	/**
	 * @param targetDate the targetDate to set
	 */
	public void setTargetDate(Date targetDate) {
		this.targetDate = targetDate;
	}

	/**
	 * @return the isDone
	 */
	public Boolean getIsDone() {
		return isDone;
	}

	/**
	 * @param isDone the isDone to set
	 */
	public void setIsDone(Boolean isDone) {
		this.isDone = isDone;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Todo [id=" + id + ", user=" + user + ", desc=" + desc + ", targetDate=" + targetDate + ", isDone="
				+ isDone + "]\n";
		
	}
	
	
	
}
