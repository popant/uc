package com.channelsoft.usercenter.account.mapper;

import com.channelsoft.usercenter.account.po.RoleMenuRela;
import com.channelsoft.usercenter.account.po.example.RoleMenuRelaExample;
import java.util.List;

import com.channelsoft.usercenter.common.mapper.IGenericMapper;
import org.apache.ibatis.annotations.Param;

public interface RoleMenuRelaMapper  extends IGenericMapper<RoleMenuRela,Integer> {
    int countByExample(RoleMenuRelaExample example);

    int deleteByExample(RoleMenuRelaExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(RoleMenuRela record);

    int insertSelective(RoleMenuRela record);

    List<RoleMenuRela> selectByExample(RoleMenuRelaExample example);

    RoleMenuRela selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RoleMenuRela record, @Param("example") RoleMenuRelaExample example);

    int updateByExample(@Param("record") RoleMenuRela record, @Param("example") RoleMenuRelaExample example);

    int updateByPrimaryKeySelective(RoleMenuRela record);

    int updateByPrimaryKey(RoleMenuRela record);
}