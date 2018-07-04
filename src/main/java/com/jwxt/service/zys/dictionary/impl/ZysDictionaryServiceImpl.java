package com.jwxt.service.zys.dictionary.impl;


import com.jwxt.dao.zys.dictionary.ZysDictionaryMapper;
import com.jwxt.model.zys.dictionary.ZysDictionary;
import com.jwxt.service.zys.dictionary.ZysDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ZysDictionaryServiceImpl implements ZysDictionaryService {
	@Autowired
	private ZysDictionaryMapper dictionaryMapper;
	
	@Override
	public List<ZysDictionary> queryDictionaryByType(String type) {
		return dictionaryMapper.queryDictionaryByType(type);
	}

}
