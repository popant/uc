package com.channelsoft.usercenter.account.service;

import com.channelsoft.usercenter.account.po.EnterpriseMenu;
import com.channelsoft.usercenter.common.service.IGenericService;

/**
 * <dl>
 * <dd>Description:</dd>
 * <dd>Copyright: Copyright (C) 2006</dd>
 * <dd>Company: 青牛（北京）技术有限公司</dd>
 * <dd>CreateDate: 2016年01月12日</dd>
 * </dl>
 *
 * @author 安宁
 */
public interface IEnterpriseMenuService extends IGenericService<EnterpriseMenu,Integer> {
    String getJsonMenuList(Integer userId, Integer enterpriseId);
}
