package com.channelsoft.usercenter.account.mapper;

import com.channelsoft.usercenter.account.po.Role;
import com.channelsoft.usercenter.account.po.example.RoleExample;
import java.util.List;

import com.channelsoft.usercenter.common.mapper.IGenericMapper;
import org.apache.ibatis.annotations.Param;

public interface RoleMapper extends IGenericMapper<Role,Integer>{
    int countByExample(RoleExample example);

    int deleteByExample(RoleExample example);

    int deleteByPrimaryKey(Integer roleId);

    int insert(Role record);

    int insertSelective(Role record);

    List<Role> selectByExample(RoleExample example);

    Role selectByPrimaryKey(Integer roleId);

    int updateByExampleSelective(@Param("record") Role record, @Param("example") RoleExample example);

    int updateByExample(@Param("record") Role record, @Param("example") RoleExample example);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
    /**
     * 通过用户id 查询用户 拥有的角色
     *
     * @param id
     * @return
     */
    List<Role> selectRolesByUserId(Integer userId);
}