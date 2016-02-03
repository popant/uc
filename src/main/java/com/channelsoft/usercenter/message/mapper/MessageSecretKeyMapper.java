package com.channelsoft.usercenter.message.mapper;

import com.channelsoft.usercenter.message.po.MessageSecretKey;
import com.channelsoft.usercenter.message.po.MessageSecretKeyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MessageSecretKeyMapper {
    int countByExample(MessageSecretKeyExample example);

    int deleteByExample(MessageSecretKeyExample example);

    int deleteByPrimaryKey(Integer secretkeyId);

    int insert(MessageSecretKey record);

    int insertSelective(MessageSecretKey record);

    List<MessageSecretKey> selectByExample(MessageSecretKeyExample example);

    MessageSecretKey selectByPrimaryKey(Integer secretkeyId);

    int updateByExampleSelective(@Param("record") MessageSecretKey record, @Param("example") MessageSecretKeyExample example);

    int updateByExample(@Param("record") MessageSecretKey record, @Param("example") MessageSecretKeyExample example);

    int updateByPrimaryKeySelective(MessageSecretKey record);

    int updateByPrimaryKey(MessageSecretKey record);
}