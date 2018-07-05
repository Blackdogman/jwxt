package com.jwxt.service.ydj.imp;

import com.jwxt.dao.ydj.YdjCourseMapper;
import com.jwxt.service.ydj.YdjCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class YdjCourseServiceImp implements YdjCourseService {
@Autowired
private YdjCourseMapper courseMapper;
	@Override
	public List<String> queryCourseByClassId(String studentClassId) {
		return  courseMapper.queryCourseByClassId(studentClassId);
	}

}
