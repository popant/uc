package com.channelsoft.usercenter.account.po;

public class Role {
    private Integer roleId;

    private String roleName;

    private String roleEngName;

    private Short roleType;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    public String getRoleEngName() {
        return roleEngName;
    }

    public void setRoleEngName(String roleEngName) {
        this.roleEngName = roleEngName == null ? null : roleEngName.trim();
    }

    public Short getRoleType() {
        return roleType;
    }

    public void setRoleType(Short roleType) {
        this.roleType = roleType;
    }
}