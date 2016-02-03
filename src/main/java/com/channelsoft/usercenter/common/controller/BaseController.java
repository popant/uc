/**
 * 
 */
package com.channelsoft.usercenter.common.controller;

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;

import com.channelsoft.usercenter.account.po.UserInfo;

/**
 * <dl>
 * <dt>BaseController</dt>
 * <dd>Description:Controller基类</dd>
 * <dd>Copyright: Copyright (C) 2016</dd>
 * <dd>Company: 青牛（北京）技术有限公司</dd>
 * <dd>CreateDate: 2016年1月14日</dd>
 * </dl>
 * 
 * @author cy
 */
public class BaseController {
	
	protected Logger logger = Logger.getLogger(getClass());
	
	protected UserInfo getUserInfo(){
		UserInfo userInfo = (UserInfo) SecurityUtils.getSubject().getSession().getAttribute("userInfo");
		return userInfo;
	}

}
