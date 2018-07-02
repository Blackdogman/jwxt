package com.jwxt.service.administrationOffice.Impl;

import com.framework.utils.PrimaryKeyUtil;
import com.jwxt.dao.administrationOffice.ScoreMapper;
import com.jwxt.dao.system.StudentMapper;
import com.jwxt.model.system.Score;
import com.jwxt.model.system.ScoreVo;
import com.jwxt.model.system.Student;
import com.jwxt.service.administrationOffice.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ScoreServiceImpl implements ScoreService {
    @Autowired
    private ScoreMapper scoreMapper;
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public int initScore(String subjectId, String year, String semester, String examName, List<String> idList) {
        List<Student> studentList = new ArrayList<>();
        for(String classId : idList){
            List<Student> tempStudentList = studentMapper.selectByClassId(classId);
            studentList.addAll(tempStudentList);
        }
        for(Student student : studentList){
            Score score = new Score();
            score.setId(PrimaryKeyUtil.getPrimaryKey());
            score.setScoreBathch(Integer.parseInt(examName));
            score.setScoreStudentId(student.getStudentId());
            score.setScoreSemester(semester);
            score.setScoreYear(year);
            score.setScoreSubjectId(subjectId);
            score.setScoreStatus(1);
            scoreMapper.insertSelective(score);
        }
        return 1;
    }

    @Override
    public int isExist(String subjectId, String year, String semester, String examName, String classId) {
        Map<String, Object> parmMap = new HashMap<>();
        parmMap.put("score_subject_id", subjectId);
        parmMap.put("score_year", year);
        parmMap.put("score_semester", semester);
        parmMap.put("score_bathch", examName);
        parmMap.put("class_id", classId);
        return scoreMapper.isExist(parmMap);
    }

    @Override
    public List<ScoreVo> listScoreVoByStudentId(String studentId) {
        Map<String, Object> parmMap = new HashMap<>();
        parmMap.put("studentId", studentId);
        return scoreMapper.listScoreVoByStudentId(parmMap);
    }

    @Override
    public int submitScore(List<Map<String, Object>> parmMapList) {
        for(Map<String, Object> parmMap : parmMapList){
            int flag = scoreMapper.submitScore(parmMap);
        }
        return 1;
    }
}
