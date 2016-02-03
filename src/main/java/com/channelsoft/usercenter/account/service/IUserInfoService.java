package com.channelsoft.usercenter.account.service;

import com.channelsoft.usercenter.account.po.UserInfo;

/**
 * <dl>
 * <dd>Description:</dd>
 * <dd>Copyright: Copyright (C) 2006</dd>
 * <dd>Company: 青牛（北京）技术有限公司</dd>
 * <dd>CreateDate: 2016年01月10日</dd>
 * </dl>
 *
 * @author 安宁
 */
public interface IUserInfoService {
    /**
     * 用户验证
     *
     * @param user
     * @return
     */
    UserInfo authentication(UserInfo user);

    /**
     * 根据用户名查询用户
     *
     * @param username
     * @return
     */
    UserInfo selectByUsername(String username);

    int insertRegisterUserInfo(UserInfo userInfo);

    /**
     * 更新用户密码
     * @param userInfo
     * @return
     */
    int updateUserPassword(UserInfo userInfo);
}
