package com.channelsoft.usercenter.account.mapper;

import com.channelsoft.usercenter.account.po.UserInfo;
import com.channelsoft.usercenter.account.po.example.UserInfoExample;
import java.util.List;

import com.channelsoft.usercenter.common.mapper.IGenericMapper;
import org.apache.ibatis.annotations.Param;

public interface UserInfoMapper  extends IGenericMapper<UserInfo,Integer> {
    int countByExample(UserInfoExample example);

    int deleteByExample(UserInfoExample example);

    int deleteByPrimaryKey(Integer userId);

    int insert(UserInfo record);

    int insertSelective(UserInfo record);

    List<UserInfo> selectByExample(UserInfoExample example);

    UserInfo selectByPrimaryKey(Integer userId);

    int updateByExampleSelective(@Param("record") UserInfo record, @Param("example") UserInfoExample example);

    int updateByExample(@Param("record") UserInfo record, @Param("example") UserInfoExample example);

    int updateByPrimaryKeySelective(UserInfo record);

    int updateByPrimaryKey(UserInfo record);
    /**
     * 用户登录验证查询
     *
     * @param record
     * @return
     */
    UserInfo authentication(@Param("record") UserInfo record);
}