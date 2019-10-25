package com.netapp.ngdc.devexp.azuredevopsapiaccess.model;

public class Remainder {

	
	private int id;
	private String rTime;
	private String rDate;
	private String status;
	private boolean snoozed;
	private String name;
	private String reason;
	
	
	public Remainder() {
		super();
	}
	
	public Remainder(int id,String name, String rDate, String rTime, String status) {
		super();
		this.id=id;
		this.rTime = rTime;
		this.rDate = rDate;
		this.status = status;
		this.name = name;
	}

	public int getId() {
		return id;
	}
	
	public String getrTime() {
		return rTime;
	}
	public void setrTime(String rTime) {
		this.rTime = rTime;
	}
	public String getrDate() {
		return rDate;
	}
	public void setrDate(String rDate) {
		this.rDate = rDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public boolean isSnoozed() {
		return snoozed;
	}
	public void setSnoozed(boolean snoozed) {
		this.snoozed = snoozed;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}

	@Override
	public String toString() {
		return "Remainder [id=" + id + ", rTime=" + rTime + ", rDate=" + rDate + ", status=" + status + ", snoozed="
				+ snoozed + ", name=" + name + ", reason=" + reason + "]";
	}


}
