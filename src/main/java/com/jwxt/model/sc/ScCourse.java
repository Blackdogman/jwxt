package com.jwxt.model.sc;

public class ScCourse {
    private String id;

    private String courseTeacherId;

    private String courseClassId;

    private String courseSubjectId;

    private String courseYear;

    private int courseSemester;

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

	public int getCourseSemester() {
		return courseSemester;
	}

	public void setCourseSemester(int courseSemester) {
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
		return "ScCourse [id=" + id + ", courseTeacherId=" + courseTeacherId + ", courseClassId=" + courseClassId
				+ ", courseSubjectId=" + courseSubjectId + ", courseYear=" + courseYear + ", courseSemester="
				+ courseSemester + ", courseWeekday=" + courseWeekday + ", coursePeriod=" + coursePeriod + "]";
	}

	public ScCourse(String id, String courseTeacherId, String courseClassId, String courseSubjectId, String courseYear,
					int courseSemester, String courseWeekday, String coursePeriod) {
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

	public ScCourse() {
		super();
	}

  
    
}