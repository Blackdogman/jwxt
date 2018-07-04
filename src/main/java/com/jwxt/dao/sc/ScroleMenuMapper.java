package com.jwxt.dao.sc;

import com.jwxt.model.sc.ScroleMenu;

public interface ScroleMenuMapper {
    int deleteByPrimaryKey(String roleMenuId);

    int insert(ScroleMenu record);

    int insertSelective(ScroleMenu record);

    ScroleMenu selectByPrimaryKey(String roleMenuId);

    int updateByPrimaryKeySelective(ScroleMenu record);

    int updateByPrimaryKey(ScroleMenu record);

	void deleteRoleMenuByRoleId(String roleId);

	
}