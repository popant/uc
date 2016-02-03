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
 * <dd>Description:角色类型</dd>
 * <dd>Copyright: Copyright (C) 2006</dd>
 * <dd>Company: 青牛（北京）技术有限公司</dd>
 * <dd>CreateDate: 2016年1月10日</dd>
 * </dl>
 * 
 * @author 安宁
 */
public class RoleType extends IntegerBeanLabelItem {

	private static final long serialVersionUID = 1L;

	private static final Log logger = LogFactory.getLog(RoleType.class);

	private static List<RoleType> items = new ArrayList<RoleType>();
	private static List<RoleType> queryItems = new ArrayList<RoleType>();
	private static Map<Integer, String> descMap = new HashMap<Integer, String>();
	protected RoleType(String name, int value, boolean queryOnly) {
		super(RoleType.class.getName(), name, value);
		queryItems.add(this);
		if (!queryOnly) {
			items.add(this);
		}
	}
	protected RoleType(String name, int value, String desc) {
		this(name, value, false);
		descMap.put(value, desc);
	}
	
	public static RoleType getItem(int value){
		try {
			return (RoleType) RoleType.getResult(RoleType.class.getName(), value);
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
	public static List<RoleType> getItems() {
		return items;
	}
	public static List<RoleType> getItemsForQuery() {
		return queryItems;
	}
	
	public static final RoleType SYSTEM_ROLE = new RoleType("UC-010001", 1, "系统角色");
	public static final RoleType CUSTOM_ROLE = new RoleType("CUSTOM_ROLE", 2, "自定义角色");
}
