package com.channelsoft.usercenter.mailaddress.service;


import com.channelsoft.usercenter.common.exception.ServiceException;
import com.channelsoft.usercenter.mailaddress.po.MailAddress;

import java.util.List;

/**
 * <dl>
 * <dd>Description:</dd>
 * <dd>Copyright: Copyright (C) 2006</dd>
 * <dd>Company: 青牛（北京）技术有限公司</dd>
 * <dd>CreateDate: 2016年1月5日</dd>
 * </dl>
 *
 * @author 肖迪
 */
public interface IMailAddressService {
    public List<MailAddress> getMailAddress(MailAddress mailAddress) throws ServiceException;

    public void addMailAsddress(MailAddress mailAddress) throws ServiceException;

    public void updateMailAddress(MailAddress mailAddress) throws ServiceException;

    public void deleteMailAddress(MailAddress mailAddress) throws ServiceException;
    
}
