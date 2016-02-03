package com.channelsoft.usercenter.account.mapper;

import com.channelsoft.usercenter.account.po.EmailTemp;
import com.channelsoft.usercenter.account.po.example.EmailTempExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EmailTempMapper {
    int countByExample(EmailTempExample example);

    int deleteByExample(EmailTempExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(EmailTemp record);

    int insertSelective(EmailTemp record);

    List<EmailTemp> selectByExample(EmailTempExample example);

    EmailTemp selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") EmailTemp record, @Param("example") EmailTempExample example);

    int updateByExample(@Param("record") EmailTemp record, @Param("example") EmailTempExample example);

    int updateByPrimaryKeySelective(EmailTemp record);

    int updateByPrimaryKey(EmailTemp record);
}