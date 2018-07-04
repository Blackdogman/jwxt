package com.jwxt.service.sc.menu;


import com.jwxt.model.sc.ScMenu;

import java.util.List;

public interface ScMenuService {

	List<ScMenu> queryAllMenu();

	int addMenuByMenu(ScMenu menu);

	int deleteMenuByMenuId(String menuId);

	ScMenu queryMenuByMenuId(String menuId);

	List<ScMenu> queryAllMenuXZ(String roleId);

    List<ScMenu> getUserMenu(String userId);

	List<ScMenu> listKidMenuByMenuIdAndUserId(String userId, String menuId);
}
