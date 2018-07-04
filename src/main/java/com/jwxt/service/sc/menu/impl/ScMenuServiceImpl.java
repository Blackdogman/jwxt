package com.jwxt.service.sc.menu.impl;

import com.jwxt.dao.sc.ScMenuMapper;
import com.jwxt.model.sc.ScMenu;
import com.jwxt.service.sc.menu.ScMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ScMenuServiceImpl implements ScMenuService {

@Autowired	
private ScMenuMapper menuMapper;
	@Override
	public List<ScMenu> queryAllMenu() {
		// TODO Auto-generated method stub
		return menuMapper.queryAllMenu();
	}
	@Override
	public int addMenuByMenu(ScMenu menu) {
		
		return menuMapper.insert(menu);
	}
	@Override
	public int deleteMenuByMenuId(String menuId) {
		// TODO Auto-generated method stub
		return menuMapper.deleteByPrimaryKey(menuId);
	}
	@Override
	public ScMenu queryMenuByMenuId(String menuId) {
		// TODO Auto-generated method stub
		return menuMapper.selectByPrimaryKey(menuId);
	}
	@Override
	public List<ScMenu> queryAllMenuXZ(String roleId) {
		// TODO Auto-generated method stub
		return menuMapper.queryAllMenuXZ( roleId);
	}

	@Override
	public List<ScMenu> getUserMenu(String userId) {
		return menuMapper.getUserMenu(userId);
	}

	@Override
	public List<ScMenu> listKidMenuByMenuIdAndUserId(String userId, String menuId) {
		return menuMapper.listKidMenuByMenuIdAndUserId(userId, menuId);
	}

}
