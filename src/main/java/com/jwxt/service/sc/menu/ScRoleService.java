package com.jwxt.service.sc.menu;

import com.jwxt.model.sc.ScRole;

import java.util.List;

public interface ScRoleService {

	List<ScRole> queryAllRole();

	List<ScRole> queryAllRoleXZ(String userId);

	ScRole queryRoleByRoleId(String roleId);

}
