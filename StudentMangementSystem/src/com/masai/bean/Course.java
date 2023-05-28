package com.masai.bean;

public class Course {
	private int cid;
	private String cName;
	private int fee;
	
	public Course() {
		// TODO Auto-generated constructor stub
	}

	public Course(int cid, String cName, int fee) {
		super();
		this.cid = cid;
		this.cName = cName;
		this.fee = fee;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public int getFee() {
		return fee;
	}

	public void setFee(int fee) {
		this.fee = fee;
	}

	@Override
	public String toString() {
		return "Course [cid=" + cid + ", cName=" + cName + ", fee=" + fee + "]";
	}
	

}
