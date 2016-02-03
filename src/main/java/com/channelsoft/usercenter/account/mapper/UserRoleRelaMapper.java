package com.channelsoft.usercenter.account.mapper;

import com.channelsoft.usercenter.account.po.UserRoleRela;
import com.channelsoft.usercenter.account.po.example.UserRoleRelaExample;
import java.util.List;

import com.channelsoft.usercenter.common.mapper.IGenericMapper;
import org.apache.ibatis.annotations.Param;

public interface UserRoleRelaMapper  extends IGenericMapper<UserRoleRela,Integer> {
    int countByExample(UserRoleRelaExample example);

    int deleteByExample(UserRoleRelaExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserRoleRela record);

    int insertSelective(UserRoleRela record);

    List<UserRoleRela> selectByExample(UserRoleRelaExample example);

    UserRoleRela selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserRoleRela record, @Param("example") UserRoleRelaExample example);

    int updateByExample(@Param("record") UserRoleRela record, @Param("example") UserRoleRelaExample example);

    int updateByPrimaryKeySelective(UserRoleRela record);

    int updateByPrimaryKey(UserRoleRela record);
}