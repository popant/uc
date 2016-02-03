package com.channelsoft.usercenter.message.service;


import com.channelsoft.usercenter.common.exception.ServiceException;
import com.channelsoft.usercenter.message.po.MessageSecretKey;
import com.channelsoft.usercenter.message.po.MessageSecretKeyExample;

import java.util.List;


/**
 * <dl>
 * <dd>Description:</dd>
 * <dd>Copyright: Copyright (C) 2006</dd>
 * <dd>Company: 青牛（北京）技术有限公司</dd>
 * <dd>CreateDate: 2016年1月19日</dd>
 * </dl>
 *
 * @author 肖迪
 */
public interface IMsgSecretkeyService {
    public List<MessageSecretKey> getMessageSecretKey(MessageSecretKeyExample msgSkeyExample) throws ServiceException;
    public void addToApply(MessageSecretKey msgSkey,MessageSecretKeyExample msgSkeyExample) throws ServiceException;
    public Integer insertInitValue(MessageSecretKey msgSkey) throws ServiceException;
}
