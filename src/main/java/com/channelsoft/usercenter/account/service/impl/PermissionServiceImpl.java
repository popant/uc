package com.channelsoft.usercenter.account.service.impl;

import com.channelsoft.usercenter.account.mapper.PermissionMapper;
import com.channelsoft.usercenter.account.po.Permission;
import com.channelsoft.usercenter.account.service.IPermissionService;
import com.channelsoft.usercenter.common.mapper.IGenericMapper;
import com.channelsoft.usercenter.common.service.impl.GenericServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 权限Service实现类
 *
 * @author StarZou
 * @since 2014年6月10日 下午12:05:03
 */
@Service
public class PermissionServiceImpl extends GenericServiceImpl<Permission, Integer> implements IPermissionService {

    @Resource
    private PermissionMapper permissionMapper;


    @Override
    public IGenericMapper<Permission, Integer> getMapper() {
        return permissionMapper;
    }

    @Override
    public List<Permission> selectPermissionsByRoleId(Integer roleId) {
        return permissionMapper.selectPermissionsByRoleId(roleId);
    }
}
