package com.jwxt.model.ydj;

import java.math.BigDecimal;

public class YdjScore {
    private String id;

    private String scoreSubjectId;

    private String scoreStudentId;

    private String scoreYear;

    private String scoreSemester;

    private BigDecimal scoreAchievement;

    private Integer scoreBathch;

    private Integer scoreStatus;

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

    public Integer getScoreBathch() {
        return scoreBathch;
    }

    public void setScoreBathch(Integer scoreBathch) {
        this.scoreBathch = scoreBathch;
    }

    public Integer getScoreStatus() {
        return scoreStatus;
    }

    public void setScoreStatus(Integer scoreStatus) {
        this.scoreStatus = scoreStatus;
    }
}