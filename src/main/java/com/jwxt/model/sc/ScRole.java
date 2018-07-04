package com.jwxt.model.sc;

import java.util.Date;

public class ScRole {
    private String roleId;

    private String roleName;

    private String roleDesc;

    private String roleState;

    private Date createTime;

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

    public String getRoleState() {
        return roleState;
    }

    public void setRoleState(String roleState) {
        this.roleState = roleState;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

	@Override
	public String toString() {
		return "ScRole [roleId=" + roleId + ", roleName=" + roleName + ", roleDesc=" + roleDesc + ", roleState="
				+ roleState + ", createTime=" + createTime + "]";
	}

	public ScRole(String roleId, String roleName, String roleDesc, String roleState, Date createTime) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
		this.roleDesc = roleDesc;
		this.roleState = roleState;
		this.createTime = createTime;
	}

	public ScRole() {
		super();
	}
    
}