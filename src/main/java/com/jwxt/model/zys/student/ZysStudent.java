package com.jwxt.model.zys.student;

import java.util.Date;

public class ZysStudent {
	/**学生id */
    private String id;
    /**学号 */
    private String studentId;
    /**姓名 */
    private String studentName;
    /**生日 */
    private Date studentBirthday;
    /**性别 (代码)*/
    private Integer studentSex;
    /**籍贯 */
    private String studentAddress;
    /**民族(代码) */
    private Integer studentNationality;
    /**所在班级id */
    private String studentClassId;
    /**状态(代码) */
    private Integer studentStatus;
    /**身份证号 */
    private String studentCitizenId;
    /**政治面貌(代码) */
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

	public ZysStudent() {
		super();
	}

	public ZysStudent(String id, String studentId, String studentName, Date studentBirthday, Integer studentSex,
                      String studentAddress, Integer studentNationality, String studentClassId, Integer studentStatus,
                      String studentCitizenId, Integer studentPoliticalStatus) {
		super();
		this.id = id;
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentBirthday = studentBirthday;
		this.studentSex = studentSex;
		this.studentAddress = studentAddress;
		this.studentNationality = studentNationality;
		this.studentClassId = studentClassId;
		this.studentStatus = studentStatus;
		this.studentCitizenId = studentCitizenId;
		this.studentPoliticalStatus = studentPoliticalStatus;
	}

	@Override
	public String toString() {
		return "ZysStudent [id=" + id + ", studentId=" + studentId + ", studentName=" + studentName + ", studentBirthday="
				+ studentBirthday + ", studentSex=" + studentSex + ", studentAddress=" + studentAddress
				+ ", studentNationality=" + studentNationality + ", studentClassId=" + studentClassId
				+ ", studentStatus=" + studentStatus + ", studentCitizenId=" + studentCitizenId
				+ ", studentPoliticalStatus=" + studentPoliticalStatus + "]";
	}
    
    
}