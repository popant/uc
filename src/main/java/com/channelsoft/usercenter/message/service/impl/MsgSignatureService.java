package com.channelsoft.usercenter.message.service.impl;

import com.channelsoft.usercenter.common.exception.ServiceException;
import com.channelsoft.usercenter.message.mapper.MessageSignatureInfoMapper;
import com.channelsoft.usercenter.message.po.MessageSignatureInfo;
import com.channelsoft.usercenter.message.po.MessageSignatureInfoExample;
import com.channelsoft.usercenter.message.service.IMsgSignatureService;
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
public class MsgSignatureService implements IMsgSignatureService {
    @Autowired
    private MessageSignatureInfoMapper mapper;


    public List<MessageSignatureInfo> getMsgSignature(MessageSignatureInfoExample msgSignatureExp) throws ServiceException {
        return mapper.selectByExample(msgSignatureExp);
    }


    public void auditMsgSignature(MessageSignatureInfo msgSignature) throws ServiceException {
        mapper.insert(msgSignature);
    }

    public void auditMsgSignatureAgain(MessageSignatureInfo msgSignature,MessageSignatureInfoExample msgSignatureExp) throws ServiceException {
        mapper.updateByExampleSelective(msgSignature,msgSignatureExp);
    }
}
