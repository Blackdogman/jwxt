package com.jwxt.model.system;

import java.math.BigDecimal;

public class ScoreVo {
    private String id;

    private String scoreSubjectId;

    private String scoreStudentId;

    private String scoreYear;

    private String scoreSemester;

    private BigDecimal scoreAchievement;

    private String scoreBathch;

    private String scoreStatus;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getScoreSubjectId() {
        return scoreSubjectId;
    }

    public void setScoreSubjectId(String scoreSubjectId) {
        this.scoreSubjectId = scoreSubjectId;
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

    public String getScoreBathch() {
        return scoreBathch;
    }

    public void setScoreBathch(String scoreBathch) {
        this.scoreBathch = scoreBathch;
    }

    public String getScoreStatus() {
        return scoreStatus;
    }

    public void setScoreStatus(String scoreStatus) {
        this.scoreStatus = scoreStatus;
    }

    @Override
    public String toString() {
        return "ScoreVo{" +
                "id='" + id + '\'' +
                ", scoreSubjectId='" + scoreSubjectId + '\'' +
                ", scoreStudentId='" + scoreStudentId + '\'' +
                ", scoreYear='" + scoreYear + '\'' +
                ", scoreSemester='" + scoreSemester + '\'' +
                ", scoreAchievement=" + scoreAchievement +
                ", scoreBathch='" + scoreBathch + '\'' +
                ", scoreStatus='" + scoreStatus + '\'' +
                '}';
    }
}