package com.channelsoft.usercenter.account.service.impl;

import com.channelsoft.usercenter.account.mapper.EmailTempMapper;
import com.channelsoft.usercenter.account.mapper.EnterpriseInfoMapper;
import com.channelsoft.usercenter.account.po.EmailTemp;
import com.channelsoft.usercenter.account.po.EnterpriseInfo;
import com.channelsoft.usercenter.account.po.example.EmailTempExample;
import com.channelsoft.usercenter.account.po.example.EnterpriseInfoExample;
import com.channelsoft.usercenter.common.exception.ServiceException;
import com.channelsoft.usercenter.account.service.ISendEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <dl>
 * <dd>Description:</dd>
 * <dd>Copyright: Copyright (C) 2006</dd>
 * <dd>Company: 青牛（北京）技术有限公司</dd>
 * <dd>CreateDate: 2016年1月13日</dd>
 * </dl>
 *
 * @author 肖迪
 */
@Service
public class SendEmailService implements ISendEmailService {
    @Autowired
    private EnterpriseInfoMapper entPriseInfomapper;
    @Autowired
    private EmailTempMapper emailTempmapper;

    public void bindingEmail(EnterpriseInfo entInfo,EnterpriseInfoExample entExample) throws ServiceException {
        entPriseInfomapper.updateByExampleSelective(entInfo,entExample);
    }

    public List<EnterpriseInfo> queryEmail(EnterpriseInfoExample entExample) throws ServiceException {
        return entPriseInfomapper.selectByExample(entExample);
    }

    public List<EmailTemp> queryEmailTemp(EmailTempExample emailTempExample) throws ServiceException {
        return emailTempmapper.selectByExample(emailTempExample);
    }

    public void addEmailTemp(EmailTemp entInfo) throws ServiceException {
        emailTempmapper.insert(entInfo);
    }

    public void updateEmailTemp(EmailTemp emailTemp,EmailTempExample emailTempExample) throws ServiceException {
        emailTempmapper.updateByExampleSelective(emailTemp,emailTempExample);
    }

    public void deleteeEmailTemp(int enterpriseId) throws ServiceException {
        emailTempmapper.deleteByPrimaryKey(enterpriseId);
    }

}
