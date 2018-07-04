package com.jwxt.model.sc;

import java.util.Date;

public class ScMenu {
    private String menuId;

    private String pId;

    private String anthortyName;

    private String anthortyDesc;

    private String anthortyUrl;

    private Date createTime;

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }

    public String getAnthortyName() {
        return anthortyName;
    }

    public void setAnthortyName(String anthortyName) {
        this.anthortyName = anthortyName;
    }

    public String getAnthortyDesc() {
        return anthortyDesc;
    }

    public void setAnthortyDesc(String anthortyDesc) {
        this.anthortyDesc = anthortyDesc;
    }

    public String getAnthortyUrl() {
        return anthortyUrl;
    }

    public void setAnthortyUrl(String anthortyUrl) {
        this.anthortyUrl = anthortyUrl;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

	@Override
	public String toString() {
		return "ScMenu [menuId=" + menuId + ", pId=" + pId + ", anthortyName=" + anthortyName + ", anthortyDesc="
				+ anthortyDesc + ", anthortyUrl=" + anthortyUrl + ", createTime=" + createTime + "]";
	}

	public ScMenu(String menuId, String pId, String anthortyName, String anthortyDesc, String anthortyUrl,
                  Date createTime) {
		super();
		this.menuId = menuId;
		this.pId = pId;
		this.anthortyName = anthortyName;
		this.anthortyDesc = anthortyDesc;
		this.anthortyUrl = anthortyUrl;
		this.createTime = createTime;
	}

	public ScMenu() {
		super();
	}
    
    
    
}