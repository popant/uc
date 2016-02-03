/**
 * 
 */
package com.channelsoft.usercenter.invoice.po.status;

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
 * <dd>Description:发票开具类型</dd>
 * <dd>Copyright: Copyright (C) 2006</dd>
 * <dd>Company: 青牛（北京）技术有限公司</dd>
 * <dd>CreateDate: 2016年1月10日</dd>
 * </dl>
 * 
 * @author 安宁
 */
public class InvoiceKindType extends IntegerBeanLabelItem {

	private static final long serialVersionUID = 1L;

	private static final Log logger = LogFactory.getLog(InvoiceKindType.class);

	private static List<InvoiceKindType> items = new ArrayList<InvoiceKindType>();
	private static List<InvoiceKindType> queryItems = new ArrayList<InvoiceKindType>();
	private static Map<Integer, String> descMap = new HashMap<Integer, String>();
	protected InvoiceKindType(String name, int value, boolean queryOnly) {
		super(InvoiceKindType.class.getName(), name, value);
		queryItems.add(this);
		if (!queryOnly) {
			items.add(this);
		}
	}
	protected InvoiceKindType(String name, int value, String desc) {
		this(name, value, false);
		descMap.put(value, desc);
	}
	
	public static InvoiceKindType getItem(int value){
		try {
			return (InvoiceKindType) InvoiceKindType.getResult(InvoiceKindType.class.getName(), value);
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
	public static List<InvoiceKindType> getItems() {
		return items;
	}
	public static List<InvoiceKindType> getItemsForQuery() {
		return queryItems;
	}
	
	public static final InvoiceKindType PERSONAL = new InvoiceKindType("PERSONAL", 0, "个人");
	public static final InvoiceKindType ENTERPRISE = new InvoiceKindType("ENTERPRISE", 1, "企业");
}
