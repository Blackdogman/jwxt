package com.jwxt.dao.sc;

import com.jwxt.model.sc.ScScore;

import java.util.List;

public interface ScScoreMapper {
    int deleteByPrimaryKey(String id);

    int insert(ScScore record);

    int insertSelective(ScScore record);

    ScScore selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ScScore record);

    int updateByPrimaryKey(ScScore record);

	List<ScScore> seletByTeacherId(String teacher_id);

	List<Object> selectNameAndScoreByTid(String teacher_id);
}