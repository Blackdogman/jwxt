package com.jwxt.service.sc.menu.impl;

import com.jwxt.dao.sc.ScroleMenuMapper;
import com.jwxt.model.sc.ScroleMenu;
import com.jwxt.service.sc.menu.ScRoleMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ScRoleMenuServiceImpl implements ScRoleMenuService {
@Autowired
private ScroleMenuMapper rolemenuMapper;
	
	@Override
	public int addRoleMenuByRoleMenu(ScroleMenu roleMenu) {
		// TODO Auto-generated method stub
		return rolemenuMapper.insert(roleMenu);
	}

	@Override
	public void deleteRoleMenuByRoleId(String roleId) {
		rolemenuMapper.deleteRoleMenuByRoleId( roleId);
	}

}
