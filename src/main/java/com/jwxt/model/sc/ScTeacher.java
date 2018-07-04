package com.jwxt.model.sc;

import java.util.Date;

public class ScTeacher {
    private String id;

    private String teacherId;

    private String teacherName;

    private Date teacherBirthday;

    private Integer teacherSex;

    private String teacherAddress;

    private String teacherNationality;

    private Integer teacherStatus;

    private String teacherCitizenId;

    private Integer teacherPoliticalStatus;

    private String teacherPhone;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public Date getTeacherBirthday() {
        return teacherBirthday;
    }

    public void setTeacherBirthday(Date teacherBirthday) {
        this.teacherBirthday = teacherBirthday;
    }

    public Integer getTeacherSex() {
        return teacherSex;
    }

    public void setTeacherSex(Integer teacherSex) {
        this.teacherSex = teacherSex;
    }

    public String getTeacherAddress() {
        return teacherAddress;
    }

    public void setTeacherAddress(String teacherAddress) {
        this.teacherAddress = teacherAddress;
    }

    public String getTeacherNationality() {
        return teacherNationality;
    }

    public void setTeacherNationality(String teacherNationality) {
        this.teacherNationality = teacherNationality;
    }

    public Integer getTeacherStatus() {
        return teacherStatus;
    }

    public void setTeacherStatus(Integer teacherStatus) {
        this.teacherStatus = teacherStatus;
    }

    public String getTeacherCitizenId() {
        return teacherCitizenId;
    }

    public void setTeacherCitizenId(String teacherCitizenId) {
        this.teacherCitizenId = teacherCitizenId;
    }

    public Integer getTeacherPoliticalStatus() {
        return teacherPoliticalStatus;
    }

    public void setTeacherPoliticalStatus(Integer teacherPoliticalStatus) {
        this.teacherPoliticalStatus = teacherPoliticalStatus;
    }

    public String getTeacherPhone() {
        return teacherPhone;
    }

    public void setTeacherPhone(String teacherPhone) {
        this.teacherPhone = teacherPhone;
    }

	@Override
	public String toString() {
		return "ScTeacher [id=" + id + ", teacherId=" + teacherId + ", teacherName=" + teacherName + ", teacherBirthday="
				+ teacherBirthday + ", teacherSex=" + teacherSex + ", teacherAddress=" + teacherAddress
				+ ", teacherNationality=" + teacherNationality + ", teacherStatus=" + teacherStatus
				+ ", teacherCitizenId=" + teacherCitizenId + ", teacherPoliticalStatus=" + teacherPoliticalStatus
				+ ", teacherPhone=" + teacherPhone + "]";
	}

	public ScTeacher(String id, String teacherId, String teacherName, Date teacherBirthday, Integer teacherSex,
                     String teacherAddress, String teacherNationality, Integer teacherStatus, String teacherCitizenId,
                     Integer teacherPoliticalStatus, String teacherPhone) {
		super();
		this.id = id;
		this.teacherId = teacherId;
		this.teacherName = teacherName;
		this.teacherBirthday = teacherBirthday;
		this.teacherSex = teacherSex;
		this.teacherAddress = teacherAddress;
		this.teacherNationality = teacherNationality;
		this.teacherStatus = teacherStatus;
		this.teacherCitizenId = teacherCitizenId;
		this.teacherPoliticalStatus = teacherPoliticalStatus;
		this.teacherPhone = teacherPhone;
	}

	public ScTeacher() {
		super();
	}
    
    
    
}