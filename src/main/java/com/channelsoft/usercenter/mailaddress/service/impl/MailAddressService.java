package com.channelsoft.usercenter.mailaddress.service.impl;

import com.channelsoft.usercenter.common.exception.ServiceException;
import com.channelsoft.usercenter.mailaddress.mapper.MailAddressMapper;
import com.channelsoft.usercenter.mailaddress.po.MailAddress;
import com.channelsoft.usercenter.mailaddress.service.IMailAddressService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
@Service
public class MailAddressService implements IMailAddressService {
    @Autowired
    private MailAddressMapper mapper;



    public List<MailAddress> getMailAddress(MailAddress mailAddress) throws ServiceException{
       return mapper.query(mailAddress);
    }


    public void addMailAsddress(MailAddress mailAddress) throws ServiceException{
        mapper.add(mailAddress);
    }


    public void updateMailAddress(MailAddress mailAddress) throws ServiceException {
        mapper.update(mailAddress);
    }


    public void deleteMailAddress(MailAddress mailAddress) throws ServiceException{
        mapper.delete(mailAddress);
    }

}
