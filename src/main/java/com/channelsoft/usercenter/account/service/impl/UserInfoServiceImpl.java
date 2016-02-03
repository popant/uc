package com.channelsoft.usercenter.account.service.impl;

import com.channelsoft.usercenter.account.mapper.EnterpriseInfoMapper;
import com.channelsoft.usercenter.account.mapper.UserInfoMapper;
import com.channelsoft.usercenter.account.mapper.UserRoleRelaMapper;
import com.channelsoft.usercenter.account.po.EnterpriseInfo;
import com.channelsoft.usercenter.account.po.UserInfo;
import com.channelsoft.usercenter.account.po.UserRoleRela;
import com.channelsoft.usercenter.account.po.example.EnterpriseInfoExample;
import com.channelsoft.usercenter.account.po.example.UserInfoExample;
import com.channelsoft.usercenter.account.po.status.AuditStatus;
import com.channelsoft.usercenter.account.service.IUserInfoService;
import com.channelsoft.usercenter.common.exception.ServiceException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;


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
@Service
public class UserInfoServiceImpl implements IUserInfoService{
    private Log logger = LogFactory.getLog(this.getClass());
    @Autowired
    private UserInfoMapper userInfoMapper;
    @Autowired
    private EnterpriseInfoMapper enterpriseInfoMapper;
    @Autowired
    private UserRoleRelaMapper userRoleRelaMapper;
    @Override
    public UserInfo authentication(UserInfo user) {
        return userInfoMapper.authentication(user);
    }

    @Override
    public UserInfo selectByUsername(String userName) {
        UserInfoExample example = new UserInfoExample();
        example.createCriteria().andUserNameEqualTo(userName);
        List<UserInfo> userInfos = userInfoMapper.selectByExample(example);
        if(userInfos != null && !userInfos.isEmpty()){
            return userInfos.get(0);
        }
        return null;
    }
    @Transactional
    @Override
    public int insertRegisterUserInfo(UserInfo userInfo){
        try {
            EnterpriseInfo info = new EnterpriseInfo();
            info.setAuditStatus(AuditStatus.NOT_AUDIT);
            info.setContactInfo(userInfo.getUserName());
            info.setCreateTime(new Date());
            enterpriseInfoMapper.insertSelective(info);
            EnterpriseInfoExample ex = new EnterpriseInfoExample();
            ex.createCriteria().andContactInfoEqualTo(userInfo.getUserName());
            List<EnterpriseInfo> enterpriseInfos = enterpriseInfoMapper.selectByExample(ex);
            Integer enterpriseId = null;
            if(enterpriseInfos != null && !enterpriseInfos.isEmpty()){
                enterpriseId = enterpriseInfos.get(0).getEnterpriseId();
            }else{
                throw new ServiceException("企业信息插入失败");
            }
            userInfo.setEnterpriseId(enterpriseId);
            int insert = userInfoMapper.insert(userInfo);
            UserInfoExample userInfoExample = new UserInfoExample();
            userInfoExample.createCriteria().andUserNameEqualTo(userInfo.getUserName());
            List<UserInfo> userInfos = userInfoMapper.selectByExample(userInfoExample);
            if(userInfos != null && !userInfos.isEmpty()){
                UserRoleRela userRoleRela = new UserRoleRela();
                userRoleRela.setRoleId(1);
                userRoleRela.setUserId(userInfos.get(0).getUserId());
                userRoleRelaMapper.insert(userRoleRela);
            }
            return insert;
        } catch (Exception e) {
            logger.error("注册用户失败" ,e);
        }
        return 0;
    }

    @Override
    public int updateUserPassword(UserInfo userInfo) {
        UserInfoExample example = new UserInfoExample();
        example.createCriteria().andUserNameEqualTo(userInfo.getUserName());
        return userInfoMapper.updateByExampleSelective(userInfo,example);
    }
}
