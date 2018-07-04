package com.jwxt.model.sc;

import java.util.Date;

public class ScStudent {
    private String id;

    private String studentId;

    private String studentName;

    private Date studentBirthday;

    private Integer studentSex;

    private String studentAddress;

    private Integer studentNationality;

    private String studentClassId;

    private Integer studentStatus;

    private String studentCitizenId;

    private Integer studentPoliticalStatus;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public Integer getStudentSex() {
        return studentSex;
    }

    public void setStudentSex(Integer studentSex) {
        this.studentSex = studentSex;
    }

    public String getStudentAddress() {
        return studentAddress;
    }

    public void setStudentAddress(String studentAddress) {
        this.studentAddress = studentAddress;
    }

    public Integer getStudentNationality() {
        return studentNationality;
    }

    public void setStudentNationality(Integer studentNationality) {
        this.studentNationality = studentNationality;
    }

    public String getStudentClassId() {
        return studentClassId;
    }

    public void setStudentClassId(String studentClassId) {
        this.studentClassId = studentClassId;
    }

    public Integer getStudentStatus() {
        return studentStatus;
    }

    public void setStudentStatus(Integer studentStatus) {
        this.studentStatus = studentStatus;
    }

    public String getStudentCitizenId() {
        return studentCitizenId;
    }

    public void setStudentCitizenId(String studentCitizenId) {
        this.studentCitizenId = studentCitizenId;
    }

    public Integer getStudentPoliticalStatus() {
        return studentPoliticalStatus;
    }

    public void setStudentPoliticalStatus(Integer studentPoliticalStatus) {
        this.studentPoliticalStatus = studentPoliticalStatus;
    }
}