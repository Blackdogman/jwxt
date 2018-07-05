package com.jwxt.model.ydj;

public class YdjCourse {
    private String id;

    private String courseTeacherId;

    private String courseClassId;

    private String courseSubjectId;

    private String courseYear;

    private String courseSemester;

    private String courseWeekday;

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

	@Override
	public String toString() {
		return "YdjCourse [id=" + id + ", courseTeacherId=" + courseTeacherId + ", courseClassId=" + courseClassId
				+ ", courseSubjectId=" + courseSubjectId + ", courseYear=" + courseYear + ", courseSemester="
				+ courseSemester + ", courseWeekday=" + courseWeekday + ", coursePeriod=" + coursePeriod + "]";
	}
    
}