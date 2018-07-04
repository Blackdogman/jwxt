package com.jwxt.model.zys.administrationOffice;

public class ZysCourse {
	/**课程id */
    private String id;
    /**任课教师id */
    private String courseTeacherId;
    /**班级id */	
    private String courseClassId;
    /**科目id */	
    private String courseSubjectId;
    /**年份 */
    private String courseYear;
    /**学期 */
    private String courseSemester;
    /**日期 */
    private String courseWeekday;
    /**时间段 */
    private String coursePeriod;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCourseTeacherId() {
        return courseTeacherId;
    }

    public void setCourseTeacherId(String courseTeacherId) {
        this.courseTeacherId = courseTeacherId;
    }

    public String getCourseClassId() {
        return courseClassId;
    }

    public void setCourseClassId(String courseClassId) {
        this.courseClassId = courseClassId;
    }

    public String getCourseSubjectId() {
        return courseSubjectId;
    }

    public void setCourseSubjectId(String courseSubjectId) {
        this.courseSubjectId = courseSubjectId;
    }

    public String getCourseYear() {
        return courseYear;
    }

    public void setCourseYear(String courseYear) {
        this.courseYear = courseYear;
    }

    public String getCourseSemester() {
        return courseSemester;
    }

    public void setCourseSemester(String courseSemester) {
        this.courseSemester = courseSemester;
    }

    public String getCourseWeekday() {
        return courseWeekday;
    }

    public void setCourseWeekday(String courseWeekday) {
        this.courseWeekday = courseWeekday;
    }

    public String getCoursePeriod() {
        return coursePeriod;
    }

    public void setCoursePeriod(String coursePeriod) {
        this.coursePeriod = coursePeriod;
    }

	public ZysCourse() {
		super();
	}

	public ZysCourse(String id, String courseTeacherId, String courseClassId, String courseSubjectId, String courseYear,
                     String courseSemester, String courseWeekday, String coursePeriod) {
		super();
		this.id = id;
		this.courseTeacherId = courseTeacherId;
		this.courseClassId = courseClassId;
		this.courseSubjectId = courseSubjectId;
		this.courseYear = courseYear;
		this.courseSemester = courseSemester;
		this.courseWeekday = courseWeekday;
		this.coursePeriod = coursePeriod;
	}

	@Override
	public String toString() {
		return "ZysCourse [id=" + id + ", courseTeacherId=" + courseTeacherId + ", courseClassId=" + courseClassId
				+ ", courseSubjectId=" + courseSubjectId + ", courseYear=" + courseYear + ", courseSemester="
				+ courseSemester + ", courseWeekday=" + courseWeekday + ", coursePeriod=" + coursePeriod + "]";
	}
    
    
}