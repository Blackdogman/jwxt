package com.jwxt.service.ydj.imp;

import com.jwxt.dao.ydj.YdjClassInfoMapper;
import com.jwxt.model.ydj.YdjClassInfo;
import com.jwxt.service.ydj.YdjClassInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class YdjClassInfoServiceImp implements YdjClassInfoService {
@Autowired
private YdjClassInfoMapper classInfoMapper;

@Override
	public YdjClassInfo queryClassById(String studentClassId) {
		return classInfoMapper.queryClassById(studentClassId);
	}

}
