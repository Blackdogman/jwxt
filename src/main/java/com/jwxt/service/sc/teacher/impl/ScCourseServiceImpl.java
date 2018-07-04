package com.jwxt.service.sc.teacher.impl;

import com.jwxt.dao.sc.ScCourseMapper;
import com.jwxt.model.sc.ScCourse;
import com.jwxt.model.sc.ScScoreView;
import com.jwxt.service.sc.teacher.ScCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ScCourseServiceImpl implements ScCourseService {
    @Autowired
	private ScCourseMapper courseMapper;

    @Override
	public List<ScCourse> selectByTeacherId(String teacher_id) {
		// TODO Auto-generated method stub
		return courseMapper.selectByTeacherId( teacher_id) ;
	}
	@Override
	public List<ScScoreView> selectCourseById(String teacher_id) {
		// TODO Auto-generated method stub
		return courseMapper.selectCourseById(teacher_id);
	}

}
