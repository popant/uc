package com.channelsoft.usercenter.account.mapper;

import com.channelsoft.usercenter.account.po.Permission;
import com.channelsoft.usercenter.account.po.example.PermissionExample;
import java.util.List;

import com.channelsoft.usercenter.common.mapper.IGenericMapper;
import org.apache.ibatis.annotations.Param;

public interface PermissionMapper  extends IGenericMapper<Permission,Integer> {
    int countByExample(PermissionExample example);

    int deleteByExample(PermissionExample example);

    int deleteByPrimaryKey(Integer permissionId);

    int insert(Permission record);

    int insertSelective(Permission record);

    List<Permission> selectByExample(PermissionExample example);

    Permission selectByPrimaryKey(Integer permissionId);

    int updateByExampleSelective(@Param("record") Permission record, @Param("example") PermissionExample example);

    int updateByExample(@Param("record") Permission record, @Param("example") PermissionExample example);

    int updateByPrimaryKeySelective(Permission record);

    int updateByPrimaryKey(Permission record);
    /**
     * 通过角色id 查询角色 拥有的权限
     *
     * @param roleId
     * @return
     */
    List<Permission> selectPermissionsByRoleId(Integer roleId);
}