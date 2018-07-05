package com.jwxt.model.ydj;

public class YdjClassInfo {
    private String id;

    private String className;

    private String classGraduateYear;

    private String classTeacherId;

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

	@Override
	public String toString() {
		return "YdjClassInfo [id=" + id + ", className=" + className + ", classGraduateYear=" + classGraduateYear
				+ ", classTeacherId=" + classTeacherId + ", classStatus=" + classStatus + "]";
	}
    
}