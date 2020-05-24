package com.tuition.beans;

import java.sql.Blob;
import java.sql.Date;
import java.sql.Timestamp;

public class TuitionForm {
	private int form_id;
	private String first_name;
	private String last_name;
	private Date start_date;
	private Timestamp start_time;
	private String location;
	private String description;
	private double cost;
	private String event_type;
	private Blob attachments;
	private int user_id;
	
	
	public TuitionForm() {
		super();
		// TODO Auto-generated constructor stub
	}


	public TuitionForm(int form_id, String first_name, String last_name, Date start_date, Timestamp start_time,
			String location, String description, double cost, String event_type, Blob attachments, int user_id) {
		super();
		this.form_id = form_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.start_date = start_date;
		this.start_time = start_time;
		this.location = location;
		this.description = description;
		this.cost = cost;
		this.event_type = event_type;
		this.attachments = attachments;
		this.user_id = user_id;
	}


	public int getForm_id() {
		return form_id;
	}


	public void setForm_id(int form_id) {
		this.form_id = form_id;
	}


	public String getFirst_name() {
		return first_name;
	}


	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}


	public String getLast_name() {
		return last_name;
	}


	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}


	public Date getStart_date() {
		return start_date;
	}


	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}


	public Timestamp getStart_time() {
		return start_time;
	}


	public void setStart_time(Timestamp start_time) {
		this.start_time = start_time;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public double getCost() {
		return cost;
	}


	public void setCost(double cost) {
		this.cost = cost;
	}


	public String getEvent_type() {
		return event_type;
	}


	public void setEvent_type(String event_type) {
		this.event_type = event_type;
	}


	public Blob getAttachments() {
		return attachments;
	}


	public void setAttachments(Blob attachments) {
		this.attachments = attachments;
	}


	public int getUser_id() {
		return user_id;
	}


	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}


	@Override
	public String toString() {
		return "TuitionForm [form_id=" + form_id + ", first_name=" + first_name + ", last_name=" + last_name
				+ ", start_date=" + start_date + ", start_time=" + start_time + ", location=" + location
				+ ", description=" + description + ", cost=" + cost + ", event_type=" + event_type + ", attachments="
				+ attachments + ", user_id=" + user_id + "]";
	} 
	
	
	
	
	
	

}
