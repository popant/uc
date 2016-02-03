package com.channelsoft.usercenter.message.service;


import com.channelsoft.usercenter.common.exception.ServiceException;
import com.channelsoft.usercenter.message.po.MessageTemplateInfo;
import com.channelsoft.usercenter.message.po.MessageTemplateInfoExample;

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
public interface IMsgTemplateService {
    public List<MessageTemplateInfo> getMsgTemplate(MessageTemplateInfoExample msgTemplateExample) throws ServiceException;

    public void addMsgTemplate(MessageTemplateInfo msgTemplate) throws ServiceException;

    public void updateMsgTemplate(MessageTemplateInfo msgTemplate, MessageTemplateInfoExample msgTemplateExample) throws ServiceException;

    public void deleteMsgTemplate(MessageTemplateInfoExample msgTemplateExample) throws ServiceException;

}
