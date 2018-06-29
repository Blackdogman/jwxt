package com.jwxt.dao.administrationOffice;

import com.jwxt.model.administrationOffice.ClassInfo;
import com.jwxt.model.administrationOffice.ClassInfoVo;

import java.util.List;
import java.util.Map;

public interface ClassInfoMapper {
    int deleteByPrimaryKey(String id);

    int insert(ClassInfo record);

    int insertSelective(ClassInfo record);

    ClassInfo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ClassInfo record);

    int updateByPrimaryKey(ClassInfo record);

	List<ClassInfoVo> queryAllClassInfo();

	List<ClassInfoVo> queryClassInfoByStatus(List<Integer> statusList);

    List<ClassInfoVo> listClassInfoVoByYearAndName(ClassInfoVo classInfoVo);

    List<ClassInfoVo> listAddScoreClassInfoVo(Map<String,Object> parmMap);
}