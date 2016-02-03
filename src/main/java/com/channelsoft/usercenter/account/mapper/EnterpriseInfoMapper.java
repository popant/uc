package com.channelsoft.usercenter.account.mapper;

import com.channelsoft.usercenter.account.po.EnterpriseInfo;
import com.channelsoft.usercenter.account.po.example.EnterpriseInfoExample;
import java.util.List;

import com.channelsoft.usercenter.common.mapper.IGenericMapper;
import org.apache.ibatis.annotations.Param;

public interface EnterpriseInfoMapper extends IGenericMapper<EnterpriseInfo , Integer>{
    int countByExample(EnterpriseInfoExample example);

    int deleteByExample(EnterpriseInfoExample example);

    int deleteByPrimaryKey(Integer enterpriseId);

    int insert(EnterpriseInfo record);

    int insertSelective(EnterpriseInfo record);

    List<EnterpriseInfo> selectByExampleWithBLOBs(EnterpriseInfoExample example);

    List<EnterpriseInfo> selectByExample(EnterpriseInfoExample example);

    EnterpriseInfo selectByPrimaryKey(Integer enterpriseId);

    int updateByExampleSelective(@Param("record") EnterpriseInfo record, @Param("example") EnterpriseInfoExample example);

    int updateByExampleWithBLOBs(@Param("record") EnterpriseInfo record, @Param("example") EnterpriseInfoExample example);

    int updateByExample(@Param("record") EnterpriseInfo record, @Param("example") EnterpriseInfoExample example);

    int updateByPrimaryKeySelective(EnterpriseInfo record);

    int updateByPrimaryKeyWithBLOBs(EnterpriseInfo record);

    int updateByPrimaryKey(EnterpriseInfo record);
}