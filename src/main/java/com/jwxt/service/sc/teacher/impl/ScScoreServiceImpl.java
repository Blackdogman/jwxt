package com.jwxt.service.sc.teacher.impl;


import com.jwxt.dao.sc.ScScoreMapper;
import com.jwxt.model.sc.ScScore;
import com.jwxt.service.sc.teacher.ScScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ScScoreServiceImpl implements ScScoreService {
    @Autowired
	private ScScoreMapper scoreMapper;
	@Override
	public List<ScScore> seletByTeacherId(String teacher_id) {
		// TODO Auto-generated method stub
		return scoreMapper.seletByTeacherId(teacher_id);
	}
	@Override
	public List<Object> selectNameAndScoreByTid(String teacher_id) {
		// TODO Auto-generated method stub
		return scoreMapper.selectNameAndScoreByTid( teacher_id);
	}

}
