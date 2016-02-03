package com.channelsoft.usercenter.account.service.impl;

import com.channelsoft.usercenter.account.mapper.RoleMapper;
import com.channelsoft.usercenter.account.po.Role;
import com.channelsoft.usercenter.account.service.IRoleService;
import com.channelsoft.usercenter.common.mapper.IGenericMapper;
import com.channelsoft.usercenter.common.service.impl.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 角色Service实现类
 *
 * @author StarZou
 * @since 2014年6月10日 下午4:16:33
 */
@Service
public class RoleServiceImpl extends GenericServiceImpl<Role, Integer> implements IRoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public IGenericMapper<Role, Integer> getMapper() {
        return roleMapper;
    }

    @Override
    public List<Role> selectRolesByUserId(Integer userId) {
        return roleMapper.selectRolesByUserId(userId);
    }

}
