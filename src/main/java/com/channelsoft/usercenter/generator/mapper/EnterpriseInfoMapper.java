package com.channelsoft.usercenter.generator.mapper;

import com.channelsoft.usercenter.generator.po.EnterpriseInfo;
import com.channelsoft.usercenter.generator.po.EnterpriseInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EnterpriseInfoMapper {
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