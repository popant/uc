/**
 * 
 */
package com.channelsoft.usercenter.account.po.status;

import com.channelsoft.usercenter.common.status.IntegerBeanLabelItem;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <dl>
 * <dt>UserType</dt>
 * <dd>Description:用户类型</dd>
 * <dd>Copyright: Copyright (C) 2006</dd>
 * <dd>Company: 青牛（北京）技术有限公司</dd>
 * <dd>CreateDate: 2016年1月10日</dd>
 * </dl>
 * 
 * @author 安宁
 */
public class UserType extends IntegerBeanLabelItem {

	private static final long serialVersionUID = 1L;

	private static final Log logger = LogFactory.getLog(UserType.class);
	
	private static List<UserType> items = new ArrayList<UserType>();
	private static List<UserType> queryItems = new ArrayList<UserType>();
	private static Map<Integer, String> descMap = new HashMap<Integer, String>();
	protected UserType(String name, int value, boolean queryOnly) {
		super(UserType.class.getName(), name, value);
		queryItems.add(this);
		if (!queryOnly) {
			items.add(this);
		}
	}
	protected UserType(String name, int value, String desc) {
		this(name, value, false);
		descMap.put(value, desc);
	}
	
	public static UserType getItem(int value){
		try {
			return (UserType) UserType.getResult(UserType.class.getName(), value);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}
	/**
	 * @Description: 获得描述，给页面使用
	 * @return String
	 * @throws
	 * @author 安宁 2014年10月13日
	 */
	public String getDesc(){
		return descMap.get(this.getValue());
	}
	public static List<UserType> getItems() {
		return items;
	}
	public static List<UserType> getItemsForQuery() {
		return queryItems;
	}
	
	public static final UserType SYSTEM_USER = new UserType("SYSTEM_USER", 1, "系统用户");
	public static final UserType CUSTOM_USER = new UserType("CUSTOM_USER", 2, "自定义用户");
}
