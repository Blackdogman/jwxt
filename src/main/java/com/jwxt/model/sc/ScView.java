package com.jwxt.model.sc;

import java.math.BigDecimal;

public class ScView {
	private BigDecimal scoreAchievement;
	
	private String studentName;
	
	private String name;

	public BigDecimal getScoreAchievement() {
		return scoreAchievement;
	}

	public void setScoreAchievement(BigDecimal scoreAchievement) {
		this.scoreAchievement = scoreAchievement;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "ScView [scoreAchievement=" + scoreAchievement + ", studentName=" + studentName + ", name=" + name + "]";
	}

	public ScView(BigDecimal scoreAchievement, String studentName, String name) {
		super();
		this.scoreAchievement = scoreAchievement;
		this.studentName = studentName;
		this.name = name;
	}

	public ScView() {
		super();
	}

	
	
}
