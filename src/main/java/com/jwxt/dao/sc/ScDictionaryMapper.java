package com.jwxt.dao.sc;

import com.jwxt.model.sc.ScDictionary;

public interface ScDictionaryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ScDictionary record);

    int insertSelective(ScDictionary record);

    ScDictionary selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ScDictionary record);

    int updateByPrimaryKey(ScDictionary record);
}