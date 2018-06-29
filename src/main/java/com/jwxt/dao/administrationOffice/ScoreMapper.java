package com.jwxt.dao.administrationOffice;

import com.jwxt.model.system.Score;

import java.util.Map;

public interface ScoreMapper {
    int deleteByPrimaryKey(String id);

    int insert(Score record);

    int insertSelective(Score record);

    Score selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Score record);

    int updateByPrimaryKey(Score record);

    int isExist(Map<String,Object> parmMap);
}