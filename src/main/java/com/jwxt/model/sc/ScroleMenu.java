package com.jwxt.model.sc;

public class ScroleMenu {
    private String roleMenuId;

    private String roleId;

    private String menuId;

    public String getRoleMenuId() {
        return roleMenuId;
    }

    public void setRoleMenuId(String roleMenuId) {
        this.roleMenuId = roleMenuId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

	@Override
	public String toString() {
		return "ScroleMenu [roleMenuId=" + roleMenuId + ", roleId=" + roleId + ", menuId=" + menuId + "]";
	}

	public ScroleMenu(String roleMenuId, String roleId, String menuId) {
		super();
		this.roleMenuId = roleMenuId;
		this.roleId = roleId;
		this.menuId = menuId;
	}

	public ScroleMenu() {
		super();
	}
    
}