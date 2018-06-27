package com.jwxt.model.system;

import java.util.Date;

public class TeacherVo {
    private String id;

    private String teacherId;

    private String teacherName;

    private Date teacherBirthday;

    private String teacherSex;

    private String teacherAddress;

    private String teacherNationality;

    private String teacherStatus;

    private String teacherCitizenId;

    private String teacherPoliticalStatus;

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

    public String getTeacherSex() {
        return teacherSex;
    }

    public void setTeacherSex(String teacherSex) {
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

    public String getTeacherStatus() {
        return teacherStatus;
    }

    public void setTeacherStatus(String teacherStatus) {
        this.teacherStatus = teacherStatus;
    }

    public String getTeacherCitizenId() {
        return teacherCitizenId;
    }

    public void setTeacherCitizenId(String teacherCitizenId) {
        this.teacherCitizenId = teacherCitizenId;
    }

    public String getTeacherPoliticalStatus() {
        return teacherPoliticalStatus;
    }

    public void setTeacherPoliticalStatus(String teacherPoliticalStatus) {
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
        return "TeacherVo{" +
                "id='" + id + '\'' +
                ", teacherId='" + teacherId + '\'' +
                ", teacherName='" + teacherName + '\'' +
                ", teacherBirthday=" + teacherBirthday +
                ", teacherSex='" + teacherSex + '\'' +
                ", teacherAddress='" + teacherAddress + '\'' +
                ", teacherNationality='" + teacherNationality + '\'' +
                ", teacherStatus='" + teacherStatus + '\'' +
                ", teacherCitizenId='" + teacherCitizenId + '\'' +
                ", teacherPoliticalStatus='" + teacherPoliticalStatus + '\'' +
                ", teacherPhone='" + teacherPhone + '\'' +
                '}';
    }
}