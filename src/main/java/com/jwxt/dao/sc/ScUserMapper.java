package com.jwxt.dao.sc;

import com.jwxt.model.sc.ScUser;

import java.util.List;

public interface ScUserMapper {
    int deleteByPrimaryKey(String userId);

    int insert(ScUser record);

    int insertSelective(ScUser record);

    ScUser selectByPrimaryKey(String userId);

    int updateByPrimaryKeySelective(ScUser record);

    int updateByPrimaryKey(ScUser record);

	String seletTIDbyname(String userLoginName);

	List<ScUser> selectPrimary();

	String seletTidbyname(String userLoginName);

	ScUser selectByPrimaryKeyAndStatus(String teacherId);


    ScUser selectUserByLoginName(String teacherId);

    int updateByLoginName(ScUser us);
}