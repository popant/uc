package com.channelsoft.usercenter.message.mapper;

import com.channelsoft.usercenter.message.po.MessageSignatureInfo;
import com.channelsoft.usercenter.message.po.MessageSignatureInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MessageSignatureInfoMapper {
    int countByExample(MessageSignatureInfoExample example);

    int deleteByExample(MessageSignatureInfoExample example);

    int deleteByPrimaryKey(Integer msgsignatureId);

    int insert(MessageSignatureInfo record);

    int insertSelective(MessageSignatureInfo record);

    List<MessageSignatureInfo> selectByExample(MessageSignatureInfoExample example);

    MessageSignatureInfo selectByPrimaryKey(Integer msgsignatureId);

    int updateByExampleSelective(@Param("record") MessageSignatureInfo record, @Param("example") MessageSignatureInfoExample example);

    int updateByExample(@Param("record") MessageSignatureInfo record, @Param("example") MessageSignatureInfoExample example);

    int updateByPrimaryKeySelective(MessageSignatureInfo record);

    int updateByPrimaryKey(MessageSignatureInfo record);
}