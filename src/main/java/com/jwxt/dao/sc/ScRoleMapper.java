package com.jwxt.dao.sc;

import com.jwxt.model.sc.ScRole;

import java.util.List;

public interface ScRoleMapper {
    int deleteByPrimaryKey(String roleId);

    int insert(ScRole record);

    int insertSelective(ScRole record);

    ScRole selectByPrimaryKey(String roleId);

    int updateByPrimaryKeySelective(ScRole record);

    int updateByPrimaryKey(ScRole record);

	List<ScRole> queryAllRole();

	List<ScRole> queryAllRoleXZ(String userId);

	

	
}