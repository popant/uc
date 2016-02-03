package com.channelsoft.usercenter.account.po;

public class EnterpriseMenu {
    private Integer menuId;

    private String menuName;

    private Integer parentId;

    private String menuUrl;

    private Integer menuOrder;

    private String menuHost;
    
    private String menuClass;

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName == null ? null : menuName.trim();
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl == null ? null : menuUrl.trim();
    }

    public Integer getMenuOrder() {
        return menuOrder;
    }

    public void setMenuOrder(Integer menuOrder) {
        this.menuOrder = menuOrder;
    }

    public String getMenuHost() {
        return menuHost;
    }

    public void setMenuHost(String menuHost) {
        this.menuHost = menuHost == null ? null : menuHost.trim();
    }

	public String getMenuClass() {
		return menuClass;
	}

	public void setMenuClass(String menuClass) {
		this.menuClass = menuClass;
	}
    
}