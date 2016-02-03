package com.channelsoft.usercenter.account.po;

public class Permission {
    private Integer permissionId;

    private String permissionName;

    private String permissionEngName;

    public Integer getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName == null ? null : permissionName.trim();
    }

    public String getPermissionEngName() {
        return permissionEngName;
    }

    public void setPermissionEngName(String permissionEngName) {
        this.permissionEngName = permissionEngName == null ? null : permissionEngName.trim();
    }
}