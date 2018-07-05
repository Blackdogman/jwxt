package com.jwxt.dao.ydj;

import com.jwxt.model.ydj.YdjScore;

public interface YdjScoreMapper {
    int deleteByPrimaryKey(String id);

    int insert(YdjScore record);

    int insertSelective(YdjScore record);

    YdjScore selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(YdjScore record);

    int updateByPrimaryKey(YdjScore record);
}