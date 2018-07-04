package com.jwxt.dao.sc;

import com.jwxt.model.sc.ScUserRole;

public interface ScUserRoleMapper {
    int deleteByPrimaryKey(String userRoleId);

    int insert(ScUserRole record);

    int insertSelective(ScUserRole record);

    ScUserRole selectByPrimaryKey(String userRoleId);

    int updateByPrimaryKeySelective(ScUserRole record);

    int updateByPrimaryKey(ScUserRole record);

	int deleteUserRoleByUserId(String userId);

	String selectRoIdByUId(String userId);
}