package com.jwxt.dao.zys.teacher;

import com.jwxt.model.zys.teacher.ZysTeacher;

import java.util.List;

public interface ZysTeacherMapper {
    int deleteByPrimaryKey(String id);

    int insert(ZysTeacher record);

    int insertSelective(ZysTeacher record);

    ZysTeacher selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ZysTeacher record);

    int updateByPrimaryKey(ZysTeacher record);

	List<ZysTeacher> queryTeahcerByStatus(List<Integer> statusList);
}