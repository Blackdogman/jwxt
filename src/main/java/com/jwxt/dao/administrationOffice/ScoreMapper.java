package com.jwxt.dao.administrationOffice;

import com.jwxt.model.system.Score;
import com.jwxt.model.system.ScoreVo;

import java.util.List;
import java.util.Map;

public interface ScoreMapper {
    int deleteByPrimaryKey(String id);

    int insert(Score record);

    int insertSelective(Score record);

    Score selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Score record);

    int updateByPrimaryKey(Score record);

    int isExist(Map<String,Object> parmMap);

    List<ScoreVo> listScoreVoByStudentId(Map<String,Object> parmMap);
}