package com.jwxt.service.ydj;

import com.jwxt.model.ydj.YdjScoreStudent;
import com.jwxt.model.ydj.YdjStudent;
import com.jwxt.model.ydj.YdjStudentCourse;
import com.jwxt.model.ydj.YdjStudentMessage;

import java.util.List;

public interface YdjStudentService {

	YdjStudent queryStudentByuserLoginName(String userLoginName);

	List<YdjStudentCourse> queryCourseWeekPeriodByClassId(String n);

	List<YdjScoreStudent> queryScoreById(String id);

	List<YdjStudentMessage> queryStudentMessage(String name);


}
