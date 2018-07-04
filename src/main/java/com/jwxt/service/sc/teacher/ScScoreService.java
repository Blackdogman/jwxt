package com.jwxt.service.sc.teacher;

import com.jwxt.model.sc.ScScore;

import java.util.List;



public interface ScScoreService {

	List<ScScore> seletByTeacherId(String teacher_id);

	List<Object> selectNameAndScoreByTid(String teacher_id);

}
