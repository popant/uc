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
 * <dd>Description:发票类型</dd>
 * <dd>Copyright: Copyright (C) 2006</dd>
 * <dd>Company: 青牛（北京）技术有限公司</dd>
 * <dd>CreateDate: 2016年1月10日</dd>
 * </dl>
 * 
 * @author 安宁
 */
public class InvoiceType extends IntegerBeanLabelItem {

	private static final long serialVersionUID = 1L;

	private static final Log logger = LogFactory.getLog(InvoiceType.class);

	private static List<InvoiceType> items = new ArrayList<InvoiceType>();
	private static List<InvoiceType> queryItems = new ArrayList<InvoiceType>();
	private static Map<Integer, String> descMap = new HashMap<Integer, String>();
	protected InvoiceType(String name, int value, boolean queryOnly) {
		super(InvoiceType.class.getName(), name, value);
		queryItems.add(this);
		if (!queryOnly) {
			items.add(this);
		}
	}
	protected InvoiceType(String name, int value, String desc) {
		this(name, value, false);
		descMap.put(value, desc);
	}
	
	public static InvoiceType getItem(int value){
		try {
			return (InvoiceType) InvoiceType.getResult(InvoiceType.class.getName(), value);
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
	public static List<InvoiceType> getItems() {
		return items;
	}
	public static List<InvoiceType> getItemsForQuery() {
		return queryItems;
	}
	
	public static final InvoiceType COMMON = new InvoiceType("COMMON", 0, "普通");
	public static final InvoiceType SPECIAL = new InvoiceType("SPECIAL", 1, "专用");
}
