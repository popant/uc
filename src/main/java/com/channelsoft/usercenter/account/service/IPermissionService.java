package com.channelsoft.usercenter.account.service;


import com.channelsoft.usercenter.account.po.Permission;
import com.channelsoft.usercenter.common.service.IGenericService;

import java.util.List;

/**
 * 权限 业务接口
 * 
 * @author StarZou
 * @since 2014年6月10日 下午12:02:39
 **/
public interface IPermissionService extends IGenericService<Permission, Integer> {

    /**
     * 通过角色id 查询角色 拥有的权限
     * 
     * @param roleId
     * @return
     */
    List<Permission> selectPermissionsByRoleId(Integer roleId);

}
