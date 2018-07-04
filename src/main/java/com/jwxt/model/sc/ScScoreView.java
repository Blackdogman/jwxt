package com.jwxt.model.sc;

public class ScScoreView {

	private String courseWeekday;
	
	private String coursePeriod;
	
	 private String name;

	@Override
	public String toString() {
		return "ScScoreView [courseWeekday=" + courseWeekday + ", coursePeriod=" + coursePeriod + ", name=" + name + "]";
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ScScoreView(String courseWeekday, String coursePeriod, String name) {
		super();
		this.courseWeekday = courseWeekday;
		this.coursePeriod = coursePeriod;
		this.name = name;
	}

	public ScScoreView() {
		super();
	}
	 
	 
}
