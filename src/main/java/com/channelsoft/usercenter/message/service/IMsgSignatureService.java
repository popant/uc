package com.channelsoft.usercenter.message.service;


import com.channelsoft.usercenter.common.exception.ServiceException;
import com.channelsoft.usercenter.message.po.MessageSignatureInfo;
import com.channelsoft.usercenter.message.po.MessageSignatureInfoExample;

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
public interface IMsgSignatureService {
    public List<MessageSignatureInfo> getMsgSignature(MessageSignatureInfoExample msgSignatureExp) throws ServiceException;

    public void auditMsgSignature(MessageSignatureInfo msgSignature) throws ServiceException;

    public void auditMsgSignatureAgain(MessageSignatureInfo msgSignature, MessageSignatureInfoExample msgSignatureExp) throws ServiceException;
}
