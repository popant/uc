package com.channelsoft.usercenter.account.service.impl;

import com.channelsoft.usercenter.account.mapper.EnterpriseInfoMapper;
import com.channelsoft.usercenter.account.po.EnterpriseInfo;
import com.channelsoft.usercenter.account.service.IEnterpriseInfoService;
import com.channelsoft.usercenter.common.mapper.IGenericMapper;
import com.channelsoft.usercenter.common.service.impl.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <dl>
 * <dd>Description:</dd>
 * <dd>Copyright: Copyright (C) 2006</dd>
 * <dd>Company: 青牛（北京）技术有限公司</dd>
 * <dd>CreateDate: 2016年01月14日</dd>
 * </dl>
 *
 * @author 安宁
 */
@Service
public class EnterpriseInfoServiceImpl extends GenericServiceImpl<EnterpriseInfo,Integer> implements IEnterpriseInfoService {
    @Autowired
    private EnterpriseInfoMapper enterpriseInfoMapper;
    @Override
    public IGenericMapper<EnterpriseInfo, Integer> getMapper() {
        return enterpriseInfoMapper;
    }
}
