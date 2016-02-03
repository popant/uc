/**
 * 
 */
package com.channelsoft.usercenter.business.factory;

import com.channelsoft.usercenter.account.po.UserInfo;
import com.channelsoft.usercenter.business.po.EnterpriseProductAjax;
import com.channelsoft.usercenter.common.exception.HandlerException;

/**
 * <dl>
 * <dt>ProductHandler</dt>
 * <dd>Description:TODO</dd>
 * <dd>Copyright: Copyright (C) 2016</dd>
 * <dd>Company: 青牛（北京）技术有限公司</dd>
 * <dd>CreateDate: 2016年1月15日</dd>
 * </dl>
 * 
 * @author cy
 */
public interface ProductHandler {
	
	public String openBusiness(UserInfo userInfo) throws HandlerException;
	public void initValue(EnterpriseProductAjax productRela) throws HandlerException;
	public String forCommercial() throws HandlerException;
	
}
