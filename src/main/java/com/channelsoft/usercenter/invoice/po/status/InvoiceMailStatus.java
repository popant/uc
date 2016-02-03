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
 * <dd>Description:发票邮寄状态</dd>
 * <dd>Copyright: Copyright (C) 2006</dd>
 * <dd>Company: 青牛（北京）技术有限公司</dd>
 * <dd>CreateDate: 2016年1月10日</dd>
 * </dl>
 * 
 * @author 安宁
 */
public class InvoiceMailStatus extends IntegerBeanLabelItem {

	private static final long serialVersionUID = 1L;

	private static final Log logger = LogFactory.getLog(InvoiceMailStatus.class);

	private static List<InvoiceMailStatus> items = new ArrayList<InvoiceMailStatus>();
	private static List<InvoiceMailStatus> queryItems = new ArrayList<InvoiceMailStatus>();
	private static Map<Integer, String> descMap = new HashMap<Integer, String>();
	protected InvoiceMailStatus(String name, int value, boolean queryOnly) {
		super(InvoiceMailStatus.class.getName(), name, value);
		queryItems.add(this);
		if (!queryOnly) {
			items.add(this);
		}
	}
	protected InvoiceMailStatus(String name, int value, String desc) {
		this(name, value, false);
		descMap.put(value, desc);
	}
	
	public static InvoiceMailStatus getItem(int value){
		try {
			return (InvoiceMailStatus) InvoiceMailStatus.getResult(InvoiceMailStatus.class.getName(), value);
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
	public static List<InvoiceMailStatus> getItems() {
		return items;
	}
	public static List<InvoiceMailStatus> getItemsForQuery() {
		return queryItems;
	}
	
	public static final InvoiceMailStatus NOT_MAIL = new InvoiceMailStatus("NOT_MAIL", 1, "未寄出");
	public static final InvoiceMailStatus MAILING = new InvoiceMailStatus("MAILING", 2, "已寄出");
	public static final InvoiceMailStatus ARRIVED = new InvoiceMailStatus("ARRIVED", 3, "已送达");
	public static final InvoiceMailStatus LOST = new InvoiceMailStatus("LOST", 3, "丢件");

}
