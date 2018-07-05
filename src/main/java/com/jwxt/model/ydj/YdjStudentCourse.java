package com.jwxt.model.ydj;

public class YdjStudentCourse {
	  private String courseName;
	  
	  private String courseWeekday;
	  
	  private String coursePeriod;

	@Override
	public String toString() {
		return "YdjStudentCourse [courseName=" + courseName + ", courseWeekday=" + courseWeekday + ", coursePeriod="
				+ coursePeriod + "]";
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
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
	  


}
