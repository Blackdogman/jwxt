package com.jwxt.dao.ydj;

import com.jwxt.model.ydj.YdjDiction;

import java.util.List;

public interface YdjDictionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(YdjDiction record);

    int insertSelective(YdjDiction record);

    YdjDiction selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(YdjDiction record);

    int updateByPrimaryKey(YdjDiction record);

    List<String> queryCourseByDictionId(int n);

}