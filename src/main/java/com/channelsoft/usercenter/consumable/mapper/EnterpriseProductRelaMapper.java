package com.channelsoft.usercenter.consumable.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.channelsoft.usercenter.consumable.po.EnterpriseProductRela;
import com.channelsoft.usercenter.consumable.po.EnterpriseProductRelaExample;

public interface EnterpriseProductRelaMapper {
    int countByExample(EnterpriseProductRelaExample example);

    int deleteByExample(EnterpriseProductRelaExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(EnterpriseProductRela record);

    int insertSelective(EnterpriseProductRela record);

    List<EnterpriseProductRela> selectByExample(EnterpriseProductRelaExample example);

    EnterpriseProductRela selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") EnterpriseProductRela record, @Param("example") EnterpriseProductRelaExample example);

    int updateByExample(@Param("record") EnterpriseProductRela record, @Param("example") EnterpriseProductRelaExample example);

    int updateByPrimaryKeySelective(EnterpriseProductRela record);

    int updateByPrimaryKey(EnterpriseProductRela record);
    
    List<EnterpriseProductRela> validProduct(EnterpriseProductRela po);
}