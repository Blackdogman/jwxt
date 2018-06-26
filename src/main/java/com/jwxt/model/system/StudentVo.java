package com.jwxt.model.system;

import java.util.Date;

public class StudentVo {
    private String id;

    private String studentId;

    private String studentName;

    private Date studentBirthday;

    private String studentSex;

    private String studentAddress;

    private String studentNationality;

    private String studentClassId;

    private String studentStatus;

    private String studentCitizenId;

    private String studentPoliticalStatus;

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

    public String getStudentSex() {
        return studentSex;
    }

    public void setStudentSex(String studentSex) {
        this.studentSex = studentSex;
    }

    public String getStudentAddress() {
        return studentAddress;
    }

    public void setStudentAddress(String studentAddress) {
        this.studentAddress = studentAddress;
    }

    public String getStudentNationality() {
        return studentNationality;
    }

    public void setStudentNationality(String studentNationality) {
        this.studentNationality = studentNationality;
    }

    public String getStudentClassId() {
        return studentClassId;
    }

    public void setStudentClassId(String studentClassId) {
        this.studentClassId = studentClassId;
    }

    public String getStudentStatus() {
        return studentStatus;
    }

    public void setStudentStatus(String studentStatus) {
        this.studentStatus = studentStatus;
    }

    public String getStudentCitizenId() {
        return studentCitizenId;
    }

    public void setStudentCitizenId(String studentCitizenId) {
        this.studentCitizenId = studentCitizenId;
    }

    public String getStudentPoliticalStatus() {
        return studentPoliticalStatus;
    }

    public void setStudentPoliticalStatus(String studentPoliticalStatus) {
        this.studentPoliticalStatus = studentPoliticalStatus;
    }

    @Override
    public String toString() {
        return "StudentVo{" +
                "id='" + id + '\'' +
                ", studentId='" + studentId + '\'' +
                ", studentName='" + studentName + '\'' +
                ", studentBirthday=" + studentBirthday +
                ", studentSex='" + studentSex + '\'' +
                ", studentAddress='" + studentAddress + '\'' +
                ", studentNationality='" + studentNationality + '\'' +
                ", studentClassId='" + studentClassId + '\'' +
                ", studentStatus='" + studentStatus + '\'' +
                ", studentCitizenId='" + studentCitizenId + '\'' +
                ", studentPoliticalStatus='" + studentPoliticalStatus + '\'' +
                '}';
    }
}