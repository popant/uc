package com.channelsoft.usercenter.message.mapper;

import com.channelsoft.usercenter.message.po.MessageTemplateInfo;
import com.channelsoft.usercenter.message.po.MessageTemplateInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MessageTemplateInfoMapper {
    int countByExample(MessageTemplateInfoExample example);

    int deleteByExample(MessageTemplateInfoExample example);

    int deleteByPrimaryKey(Integer msgtemplateId);

    int insert(MessageTemplateInfo record);

    int insertSelective(MessageTemplateInfo record);

    List<MessageTemplateInfo> selectByExample(MessageTemplateInfoExample example);

    MessageTemplateInfo selectByPrimaryKey(Integer msgtemplateId);

    int updateByExampleSelective(@Param("record") MessageTemplateInfo record, @Param("example") MessageTemplateInfoExample example);

    int updateByExample(@Param("record") MessageTemplateInfo record, @Param("example") MessageTemplateInfoExample example);

    int updateByPrimaryKeySelective(MessageTemplateInfo record);

    int updateByPrimaryKey(MessageTemplateInfo record);
}