package com.jwxt.service.ydj.imp;

import com.jwxt.dao.ydj.YdjStudentMapper;
import com.jwxt.model.ydj.YdjScoreStudent;
import com.jwxt.model.ydj.YdjStudent;
import com.jwxt.model.ydj.YdjStudentCourse;
import com.jwxt.model.ydj.YdjStudentMessage;
import com.jwxt.service.ydj.YdjStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class YdjStudentServiceImp implements YdjStudentService {
	@Autowired
	private YdjStudentMapper studentMapper;

	@Override
	public YdjStudent queryStudentByuserLoginName(String userLoginName) {
		return studentMapper.queryStudentByuserLoginName(userLoginName);
	}
	@Override
	public List<YdjStudentCourse> queryCourseWeekPeriodByClassId(String n) {
		System.err.println("实现层中可以试一试吗？：" + studentMapper.queryCourseWeekPeriodByClassId(n));
		return studentMapper.queryCourseWeekPeriodByClassId(n);
	}
	@Override
	public List<YdjScoreStudent> queryScoreById(String id) {
		return studentMapper.queryScoreById(id);
	}
	@Override
	public List<YdjStudentMessage> queryStudentMessage(String name) {
		return studentMapper.queryStudentMessage(name);
	}
	
}
