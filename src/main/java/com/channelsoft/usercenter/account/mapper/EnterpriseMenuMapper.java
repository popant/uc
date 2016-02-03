package com.channelsoft.usercenter.account.mapper;

import com.channelsoft.usercenter.account.po.EnterpriseMenu;
import com.channelsoft.usercenter.account.po.example.EnterpriseMenuExample;
import java.util.List;

import com.channelsoft.usercenter.common.mapper.IGenericMapper;
import org.apache.ibatis.annotations.Param;

public interface EnterpriseMenuMapper  extends IGenericMapper<EnterpriseMenu,Integer> {
    int countByExample(EnterpriseMenuExample example);

    int deleteByExample(EnterpriseMenuExample example);

    int deleteByPrimaryKey(Integer menuId);

    int insert(EnterpriseMenu record);

    int insertSelective(EnterpriseMenu record);

    List<EnterpriseMenu> selectByExample(EnterpriseMenuExample example);

    EnterpriseMenu selectByPrimaryKey(Integer menuId);

    int updateByExampleSelective(@Param("record") EnterpriseMenu record, @Param("example") EnterpriseMenuExample example);

    int updateByExample(@Param("record") EnterpriseMenu record, @Param("example") EnterpriseMenuExample example);

    int updateByPrimaryKeySelective(EnterpriseMenu record);

    int updateByPrimaryKey(EnterpriseMenu record);

    /**
     * 根据用户查询其菜单列表
     * @param userId
     * @return
     */
    List<EnterpriseMenu> selectEnterpriseMenusByUserId(Integer userId);
}