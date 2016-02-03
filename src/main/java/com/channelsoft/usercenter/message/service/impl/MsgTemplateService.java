package com.channelsoft.usercenter.message.service.impl;

import com.channelsoft.usercenter.common.exception.ServiceException;
import com.channelsoft.usercenter.message.mapper.MessageTemplateInfoMapper;
import com.channelsoft.usercenter.message.po.MessageTemplateInfo;
import com.channelsoft.usercenter.message.po.MessageTemplateInfoExample;
import com.channelsoft.usercenter.message.service.IMsgTemplateService;
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
public class MsgTemplateService implements IMsgTemplateService {
    @Autowired
    private MessageTemplateInfoMapper mapper;


    public List<MessageTemplateInfo> getMsgTemplate(MessageTemplateInfoExample msgTemplateExample) throws ServiceException {
        return mapper.selectByExample(msgTemplateExample);
    }


    public void addMsgTemplate(MessageTemplateInfo msgTemplate) throws ServiceException {
        mapper.insert(msgTemplate);
    }

    public void updateMsgTemplate(MessageTemplateInfo msgTemplate,MessageTemplateInfoExample msgTemplateExample) throws ServiceException {
        mapper.updateByExample(msgTemplate,msgTemplateExample);
    }

    public void deleteMsgTemplate(MessageTemplateInfoExample msgTemplateExample) throws ServiceException {
        mapper.deleteByExample(msgTemplateExample);
    }
}
