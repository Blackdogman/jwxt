package com.jwxt.service.sc.menu.impl;

import com.jwxt.dao.sc.ScRoleMapper;
import com.jwxt.model.sc.ScRole;
import com.jwxt.service.sc.menu.ScRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class ScRoleServiceImpl implements ScRoleService {
@Autowired	
private ScRoleMapper roleMapper;
	@Override 
	public List<ScRole> queryAllRole() {
		// TODO Auto-generated method stub
		return roleMapper.queryAllRole();
	}
	@Override
	public List<ScRole> queryAllRoleXZ(String userId) {
		// TODO Auto-generated method stub
		return roleMapper.queryAllRoleXZ( userId);
	}
	@Override
	public ScRole queryRoleByRoleId(String roleId) {
		// TODO Auto-generated method stub
		return roleMapper.selectByPrimaryKey(roleId);
	}

}
