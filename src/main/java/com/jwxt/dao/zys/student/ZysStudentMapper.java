package com.jwxt.dao.zys.student;


import com.jwxt.model.zys.student.ZysStudent;

import java.util.List;
import java.util.Map;

public interface ZysStudentMapper {
    int deleteByPrimaryKey(String id);

    int insert(ZysStudent record);

    int insertSelective(ZysStudent record);

    ZysStudent selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ZysStudent record);

    int updateByPrimaryKey(ZysStudent record);

	List<ZysStudent> queryStudentByStatus(List<Integer> statusList);

	List<ZysStudent> queryDistributedStudentByClassId(String id);

	int updateClassIdByClassIdAndStudentId(Map<String, Object> map2);

	int removeStudentClassIdByClassId(String id);
}