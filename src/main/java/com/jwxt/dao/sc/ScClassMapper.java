package com.jwxt.dao.sc;

import com.jwxt.model.sc.ScClass;

public interface ScClassMapper {
    int deleteByPrimaryKey(String id);

    int insert(ScClass record);

    int insertSelective(ScClass record);

    ScClass selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ScClass record);

    int updateByPrimaryKey(ScClass record);
}