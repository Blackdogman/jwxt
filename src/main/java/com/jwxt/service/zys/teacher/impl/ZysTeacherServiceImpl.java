package com.jwxt.service.zys.teacher.impl;

import java.util.List;

import com.jwxt.dao.zys.teacher.ZysTeacherMapper;
import com.jwxt.model.zys.teacher.ZysTeacher;
import com.jwxt.service.zys.teacher.ZysTeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ZysTeacherServiceImpl implements ZysTeacherService {
    @Autowired
	private ZysTeacherMapper teacherMapper;
	
	@Override
	public List<ZysTeacher> queryTeahcerByStatus(List<Integer> statusList) {
		return teacherMapper.queryTeahcerByStatus(statusList);
	}

}
