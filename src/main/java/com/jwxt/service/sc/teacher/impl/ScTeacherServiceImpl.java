package com.jwxt.service.sc.teacher.impl;

import com.jwxt.dao.sc.ScTeacherMapper;
import com.jwxt.model.sc.ScTeacher;
import com.jwxt.service.sc.teacher.ScTeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ScTeacherServiceImpl implements ScTeacherService {
   	@Autowired
	private ScTeacherMapper teacherMapper;
	
	
	@Override
	public List<ScTeacher> selectByTeacherAll(String teacher_id) {
		// TODO Auto-generated method stub
		return teacherMapper.selectByTeacherAll( teacher_id);
	}

}
