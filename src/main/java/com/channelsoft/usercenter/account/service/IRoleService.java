package com.channelsoft.usercenter.account.service;


import com.channelsoft.usercenter.account.po.Role;
import com.channelsoft.usercenter.common.service.IGenericService;

import java.util.List;


public interface IRoleService extends IGenericService<Role, Integer> {
    /**
     * 通过用户id 查询用户 拥有的角色
     * 
     * @param userId
     * @return
     */
    List<Role> selectRolesByUserId(Integer userId);
}
