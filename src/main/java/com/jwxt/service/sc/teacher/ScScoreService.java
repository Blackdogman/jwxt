package com.jwxt.service.sc.teacher;

import com.jwxt.model.sc.ScScore;
import com.jwxt.model.sc.ScView;

import java.util.List;



public interface ScScoreService {

	List<ScScore> seletByTeacherId(String teacher_id);

	List<ScView> selectNameAndScoreByTid(String teacher_id);

}
