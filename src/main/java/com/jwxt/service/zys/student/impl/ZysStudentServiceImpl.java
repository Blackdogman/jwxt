package com.jwxt.service.zys.student.impl;

import java.util.List;

import com.jwxt.dao.zys.student.ZysStudentMapper;
import com.jwxt.model.zys.student.ZysStudent;
import com.jwxt.service.zys.student.ZysStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ZysStudentServiceImpl implements ZysStudentService {
	@Autowired
	private ZysStudentMapper studentMapper;
	
	@Override
	public List<ZysStudent> queryStudentByStatus(List<Integer> statusList) {
		return studentMapper.queryStudentByStatus(statusList);
	}

	@Override
	public List<ZysStudent> queryDistributedStudentByClassId(String id) {
		return studentMapper.queryDistributedStudentByClassId(id);
	}

}
