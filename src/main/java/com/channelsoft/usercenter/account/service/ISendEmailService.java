package com.channelsoft.usercenter.account.service;


import com.channelsoft.usercenter.account.po.EmailTemp;
import com.channelsoft.usercenter.account.po.EnterpriseInfo;
import com.channelsoft.usercenter.account.po.example.EmailTempExample;
import com.channelsoft.usercenter.account.po.example.EnterpriseInfoExample;
import com.channelsoft.usercenter.common.exception.ServiceException;

import java.util.List;

/**
 * <dl>
 * <dd>Description:</dd>
 * <dd>Copyright: Copyright (C) 2006</dd>
 * <dd>Company: 青牛（北京）技术有限公司</dd>
 * <dd>CreateDate: 2016年1月18日</dd>
 * </dl>
 *
 * @author 肖迪
 */
public interface ISendEmailService {
    public void bindingEmail(EnterpriseInfo entInfo, EnterpriseInfoExample entExample) throws ServiceException;

    public List<EnterpriseInfo> queryEmail(EnterpriseInfoExample entExample) throws ServiceException;

    public List<EmailTemp> queryEmailTemp(EmailTempExample emailTempExample) throws ServiceException;

    public void addEmailTemp(EmailTemp emailTemp) throws ServiceException;

    public void updateEmailTemp(EmailTemp emailTemp, EmailTempExample emailTempExample) throws ServiceException;

    public void deleteeEmailTemp(int enterpriseId) throws ServiceException;
}
