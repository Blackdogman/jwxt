package com.jwxt.model.sc;

import java.util.Date;

public class ScUser {
    private String userId;

    private String userLoginName;

    private String userLoginPwd;

    private Date userCreateTime;

    private String userCharactor;

    private Integer userStatus;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserLoginName() {
        return userLoginName;
    }

    public void setUserLoginName(String userLoginName) {
        this.userLoginName = userLoginName;
    }

    public String getUserLoginPwd() {
        return userLoginPwd;
    }

    public void setUserLoginPwd(String userLoginPwd) {
        this.userLoginPwd = userLoginPwd;
    }

    public Date getUserCreateTime() {
        return userCreateTime;
    }

    public void setUserCreateTime(Date userCreateTime) {
        this.userCreateTime = userCreateTime;
    }

    public String getUserCharactor() {
        return userCharactor;
    }

    public void setUserCharactor(String userCharactor) {
        this.userCharactor = userCharactor;
    }

    public Integer getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(Integer userStatus) {
        this.userStatus = userStatus;
    }

	@Override
	public String toString() {
		return "ScUser [userId=" + userId + ", userLoginName=" + userLoginName + ", userLoginPwd=" + userLoginPwd
				+ ", userCreateTime=" + userCreateTime + ", userCharactor=" + userCharactor + ", userStatus="
				+ userStatus + "]";
	}

	public ScUser(String userId, String userLoginName, String userLoginPwd, Date userCreateTime, String userCharactor,
                  Integer userStatus) {
		super();
		this.userId = userId;
		this.userLoginName = userLoginName;
		this.userLoginPwd = userLoginPwd;
		this.userCreateTime = userCreateTime;
		this.userCharactor = userCharactor;
		this.userStatus = userStatus;
	}

	public ScUser() {
		super();
	}
    
}