package com.jwxt.service.administrationOffice;

import java.util.List;

public interface ScoreService {
    int initScore(String subjectId, String year, String semester, String examName, List<String> idList);

    int isExist(String subjectId, String year, String semester, String examName, String classId);
}
