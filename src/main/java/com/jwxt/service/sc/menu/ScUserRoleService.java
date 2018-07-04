package com.jwxt.service.sc.menu;

import com.jwxt.model.sc.ScUserRole;

public interface ScUserRoleService {

	int deleteUserRoleByUserId(String userId);

	int addUserRoleByUserRole(ScUserRole userRole);

	String selectRoIdByUId(String userId);

}
