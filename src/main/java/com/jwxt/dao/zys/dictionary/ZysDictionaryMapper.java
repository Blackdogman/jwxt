package com.jwxt.dao.zys.dictionary;


import com.jwxt.model.zys.dictionary.ZysDictionary;

import java.util.List;

public interface ZysDictionaryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ZysDictionary record);

    int insertSelective(ZysDictionary record);

    ZysDictionary selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ZysDictionary record);

    int updateByPrimaryKey(ZysDictionary record);

	List<ZysDictionary> queryDictionaryByType(String type);
}