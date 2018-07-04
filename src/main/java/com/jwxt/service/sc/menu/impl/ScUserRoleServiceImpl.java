package com.jwxt.service.sc.menu.impl;

import com.jwxt.dao.sc.ScUserRoleMapper;
import com.jwxt.model.sc.ScUserRole;
import com.jwxt.service.sc.menu.ScUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ScUserRoleServiceImpl implements ScUserRoleService {
    @Autowired
	private ScUserRoleMapper userRoleMapper;
	@Override
	public int deleteUserRoleByUserId(String userId) {
		// TODO Auto-generated method stub
		return userRoleMapper.deleteUserRoleByUserId( userId);
	}
	@Override
	public int addUserRoleByUserRole(ScUserRole userRole) {
		// TODO Auto-generated method stub
		return userRoleMapper.insert(userRole);
	}
	@Override
	public String selectRoIdByUId(String userId) {
		// TODO Auto-generated method stub
		return userRoleMapper.selectRoIdByUId( userId);
	}

}
