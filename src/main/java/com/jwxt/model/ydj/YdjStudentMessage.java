package com.jwxt.model.ydj;

import java.util.Date;

public class YdjStudentMessage {
	
	 private String studentId;
	 
	 private String studentName;
	 
	 private Date studentBirthday;
	 
	 private String studentAddress;
	 
	 private String className;
	  
	 private String studentSex;
	 
	 private String studentStatus;
	 
	 private String studentNationality;
	 
	 private String studentPoliticalStatus;

	@Override
	public String toString() {
		return "YdjStudentMessage [studentId=" + studentId + ", studentName=" + studentName + ", studentBirthday="
				+ studentBirthday + ", studentAddress=" + studentAddress + ", className=" + className + ", studentSex="
				+ studentSex + ", studentStatus=" + studentStatus + ", studentNationality=" + studentNationality
				+ ", studentPoliticalStatus=" + studentPoliticalStatus + "]";
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public Date getStudentBirthday() {
		return studentBirthday;
	}

	public void setStudentBirthday(Date studentBirthday) {
		this.studentBirthday = studentBirthday;
	}

	public String getStudentAddress() {
		return studentAddress;
	}

	public void setStudentAddress(String studentAddress) {
		this.studentAddress = studentAddress;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getStudentSex() {
		return studentSex;
	}

	public void setStudentSex(String studentSex) {
		this.studentSex = studentSex;
	}

	public String getStudentStatus() {
		return studentStatus;
	}

	public void setStudentStatus(String studentStatus) {
		this.studentStatus = studentStatus;
	}

	public String getStudentNationality() {
		return studentNationality;
	}

	public void setStudentNationality(String studentNationality) {
		this.studentNationality = studentNationality;
	}

	public String getStudentPoliticalStatus() {
		return studentPoliticalStatus;
	}

	public void setStudentPoliticalStatus(String studentPoliticalStatus) {
		this.studentPoliticalStatus = studentPoliticalStatus;
	}

}
