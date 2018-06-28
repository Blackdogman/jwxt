package com.jwxt.service.administrationOffice;

import java.util.List;

public interface ScoreService {
    int initScore(String subject_id, String year, String semester, String examName, List<String> idList);
}
