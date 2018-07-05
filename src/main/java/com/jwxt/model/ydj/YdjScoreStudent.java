package com.jwxt.model.ydj;

import java.math.BigDecimal;

public class YdjScoreStudent {
	private String scoreStudentId;

	private String scoreYear;

    private String scoreSemester;

    private BigDecimal scoreAchievement;

    private Integer scoreBathch;
 
    private String scoreStatus;
    
    private String subjectName;

	@Override
	public String toString() {
		return "YdjScoreStudent [scoreStudentId=" + scoreStudentId + ", scoreYear=" + scoreYear + ", scoreSemester="
				+ scoreSemester + ", scoreAchievement=" + scoreAchievement + ", scoreBathch=" + scoreBathch
				+ ", scoreStatus=" + scoreStatus + ", subjectName=" + subjectName + "]";
	}

	public String getScoreStudentId() {
		return scoreStudentId;
	}

	public void setScoreStudentId(String scoreStudentId) {
		this.scoreStudentId = scoreStudentId;
	}

	public String getScoreYear() {
		return scoreYear;
	}

	public void setScoreYear(String scoreYear) {
		this.scoreYear = scoreYear;
	}

	public String getScoreSemester() {
		return scoreSemester;
	}

	public void setScoreSemester(String scoreSemester) {
		this.scoreSemester = scoreSemester;
	}

	public BigDecimal getScoreAchievement() {
		return scoreAchievement;
	}

	public void setScoreAchievement(BigDecimal scoreAchievement) {
		this.scoreAchievement = scoreAchievement;
	}

	public Integer getScoreBathch() {
		return scoreBathch;
	}

	public void setScoreBathch(Integer scoreBathch) {
		this.scoreBathch = scoreBathch;
	}

	public String getScoreStatus() {
		return scoreStatus;
	}

	public void setScoreStatus(String scoreStatus) {
		this.scoreStatus = scoreStatus;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

}
