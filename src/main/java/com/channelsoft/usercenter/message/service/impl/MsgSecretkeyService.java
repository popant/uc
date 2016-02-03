package com.channelsoft.usercenter.message.service.impl;

import com.channelsoft.usercenter.common.exception.ServiceException;
import com.channelsoft.usercenter.message.mapper.MessageSecretKeyMapper;
import com.channelsoft.usercenter.message.po.MessageSecretKey;
import com.channelsoft.usercenter.message.po.MessageSecretKeyExample;
import com.channelsoft.usercenter.message.service.IMsgSecretkeyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
@Service
public class MsgSecretkeyService implements IMsgSecretkeyService {
    @Autowired
    private MessageSecretKeyMapper mapper;


    public List<MessageSecretKey> getMessageSecretKey(MessageSecretKeyExample msgSkeyExample) throws ServiceException {
        return mapper.selectByExample(msgSkeyExample);
    }


    public void addToApply(MessageSecretKey msgSkey,MessageSecretKeyExample msgSkeyExample) throws ServiceException {
        mapper.updateByExampleSelective(msgSkey,msgSkeyExample);
    }


	/* (non-Javadoc)
	 * @see com.channelsoft.usercenter.message.service.IMsgSecretkeyService#insertInitValue(com.channelsoft.usercenter.message.po.MessageSecretKey)
	 */
	@Override
	public Integer insertInitValue(MessageSecretKey msgSkey)
			throws ServiceException {
		return mapper.insertSelective(msgSkey);
	}

}
