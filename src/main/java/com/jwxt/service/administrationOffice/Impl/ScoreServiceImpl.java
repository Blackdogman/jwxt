package com.jwxt.service.administrationOffice.Impl;

import com.framework.utils.PrimaryKeyUtil;
import com.jwxt.dao.administrationOffice.ScoreMapper;
import com.jwxt.dao.system.StudentMapper;
import com.jwxt.model.system.Score;
import com.jwxt.model.system.Student;
import com.jwxt.service.administrationOffice.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ScoreServiceImpl implements ScoreService {
    @Autowired
    private ScoreMapper scoreMapper;
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public int initScore(String subject_id, String year, String semester, String examName, List<String> idList) {
        List<Student> studentList = new ArrayList<>();
        for(String classId : idList){
            List<Student> tempStudentList = studentMapper.selectByClassId(classId);
            studentList.addAll(tempStudentList);
        }
        System.out.println(studentList);
        for(Student student : studentList){
            Score score = new Score();
            score.setId(PrimaryKeyUtil.getPrimaryKey());
            score.setScoreBathch(Integer.parseInt(examName));
            score.setScoreStudentId(student.getStudentId());
            score.setScoreSemester(semester);
            score.setScoreYear(year);
            score.setScoreSubjectId(subject_id);
            score.setScoreStatus(1);
            scoreMapper.insertSelective(score);
        }
        return 1;
    }
}
