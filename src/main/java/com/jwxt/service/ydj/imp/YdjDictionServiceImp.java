package com.jwxt.service.ydj.imp;

import com.jwxt.dao.ydj.YdjDictionMapper;
import com.jwxt.service.ydj.YdjDictionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class YdjDictionServiceImp implements YdjDictionService {
@Autowired
private YdjDictionMapper dictionMapper;

@Override
public List<String> queryCourseByDictionId(int n) {
	return  dictionMapper.queryCourseByDictionId(n);
}


}
