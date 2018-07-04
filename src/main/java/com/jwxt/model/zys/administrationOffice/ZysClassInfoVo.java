package com.jwxt.model.zys.administrationOffice;

public class ZysClassInfoVo {
	/**班级ID */
    private String id;
    /**班级名称 */
    private String className;
    /**毕业年 */
    private String classGraduateYear;
    /**班主任姓名 */
    private String teacherName;
    /**班级状态 */
    private String classStatus;
    
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getClassGraduateYear() {
		return classGraduateYear;
	}
	public void setClassGraduateYear(String classGraduateYear) {
		this.classGraduateYear = classGraduateYear;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public String getClassStatus() {
		return classStatus;
	}
	public void setClassStatus(String classStatus) {
		this.classStatus = classStatus;
	}
	
	public ZysClassInfoVo() {
		super();
	}
	
	public ZysClassInfoVo(String id, String className, String classGraduateYear, String teacherName, String classStatus) {
		super();
		this.id = id;
		this.className = className;
		this.classGraduateYear = classGraduateYear;
		this.teacherName = teacherName;
		this.classStatus = classStatus;
	}
	
	@Override
	public String toString() {
		return "ZysClassInfoVo [id=" + id + ", className=" + className + ", classGraduateYear=" + classGraduateYear
				+ ", teacherName=" + teacherName + ", classStatus=" + classStatus + "]";
	}
    
}
