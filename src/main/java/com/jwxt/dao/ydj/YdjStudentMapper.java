package com.jwxt.dao.ydj;

import com.jwxt.model.ydj.YdjScoreStudent;
import com.jwxt.model.ydj.YdjStudent;
import com.jwxt.model.ydj.YdjStudentCourse;
import com.jwxt.model.ydj.YdjStudentMessage;

import java.util.List;

public interface YdjStudentMapper {
    int deleteByPrimaryKey(String id);

    int insert(YdjStudent record);

    int insertSelective(YdjStudent record);

    YdjStudent selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(YdjStudent record);

    int updateByPrimaryKey(YdjStudent record);

    YdjStudent queryStudentByuserLoginName(String userLoginName);

	List<YdjStudentCourse> queryCourseWeekPeriodByClassId(String n);

	List<YdjScoreStudent> queryScoreById(String id);

	List<YdjStudentMessage> queryStudentMessage(String name);


}