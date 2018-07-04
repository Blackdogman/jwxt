package com.jwxt.dao.sc;

import com.jwxt.model.sc.ScMenu;

import java.util.List;

public interface ScMenuMapper {
    int deleteByPrimaryKey(String menuId);

    int insert(ScMenu record);

    int insertSelective(ScMenu record);

    ScMenu selectByPrimaryKey(String menuId);

    int updateByPrimaryKeySelective(ScMenu record);

    int updateByPrimaryKey(ScMenu record);

	List<ScMenu> queryAllMenu();

	List<ScMenu> queryAllMenuXZ(String roleId);

	
}