package com.channelsoft.usercenter.account.mapper;

import com.channelsoft.usercenter.account.po.RolePermissionRela;
import com.channelsoft.usercenter.account.po.example.RolePermissionRelaExample;
import java.util.List;

import com.channelsoft.usercenter.common.mapper.IGenericMapper;
import org.apache.ibatis.annotations.Param;

public interface RolePermissionRelaMapper  extends IGenericMapper<RolePermissionRela,Integer> {
    int countByExample(RolePermissionRelaExample example);

    int deleteByExample(RolePermissionRelaExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(RolePermissionRela record);

    int insertSelective(RolePermissionRela record);

    List<RolePermissionRela> selectByExample(RolePermissionRelaExample example);

    RolePermissionRela selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RolePermissionRela record, @Param("example") RolePermissionRelaExample example);

    int updateByExample(@Param("record") RolePermissionRela record, @Param("example") RolePermissionRelaExample example);

    int updateByPrimaryKeySelective(RolePermissionRela record);

    int updateByPrimaryKey(RolePermissionRela record);
}