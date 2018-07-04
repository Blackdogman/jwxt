package com.jwxt.model.zys.administrationOffice;

public class ZysClassInfo {
	/**班级ID */
    private String id;
    /**班级名称 */
    private String className;
    /**毕业年 */
    private String classGraduateYear;
    /**班主任ID */
    private String classTeacherId;
    /**班级状态 */
    private Integer classStatus;

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

    public String getClassTeacherId() {
        return classTeacherId;
    }

    public void setClassTeacherId(String classTeacherId) {
        this.classTeacherId = classTeacherId;
    }

    public Integer getClassStatus() {
        return classStatus;
    }

    public void setClassStatus(Integer classStatus) {
        this.classStatus = classStatus;
    }

	public ZysClassInfo() {
		super();
	}

	public ZysClassInfo(String id, String className, String classGraduateYear, String classTeacherId,
                        Integer classStatus) {
		super();
		this.id = id;
		this.className = className;
		this.classGraduateYear = classGraduateYear;
		this.classTeacherId = classTeacherId;
		this.classStatus = classStatus;
	}

	@Override
	public String toString() {
		return "ZysClassInfo [id=" + id + ", className=" + className + ", classGraduateYear=" + classGraduateYear
				+ ", classTeacherId=" + classTeacherId + ", classStatus=" + classStatus + "]";
	}
    
    
}