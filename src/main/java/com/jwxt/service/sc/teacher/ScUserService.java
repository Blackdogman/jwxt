package com.jwxt.service.sc.teacher;

import com.jwxt.model.sc.ScUser;

import java.util.List;

public interface ScUserService {

	
	List<ScUser> selectPrimary();

	String seletTidbyname(String userLoginName);

	ScUser selectByPrimaryKeyAndStatus(String teacherId);

	void updateByPrimaryKeySelective(ScUser us);

	ScUser queryByUserId(String userId);


	ScUser selectUserByLoginName(String teacherId);


	int updateByLoginName(ScUser us);
}
