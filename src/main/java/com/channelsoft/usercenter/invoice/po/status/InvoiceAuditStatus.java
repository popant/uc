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
 * <dd>Description:发票审核状态</dd>
 * <dd>Copyright: Copyright (C) 2006</dd>
 * <dd>Company: 青牛（北京）技术有限公司</dd>
 * <dd>CreateDate: 2016年1月10日</dd>
 * </dl>
 * 
 * @author 安宁
 */
public class InvoiceAuditStatus extends IntegerBeanLabelItem {

	private static final long serialVersionUID = 1L;

	private static final Log logger = LogFactory.getLog(InvoiceAuditStatus.class);

	private static List<InvoiceAuditStatus> items = new ArrayList<InvoiceAuditStatus>();
	private static List<InvoiceAuditStatus> queryItems = new ArrayList<InvoiceAuditStatus>();
	private static Map<Integer, String> descMap = new HashMap<Integer, String>();
	protected InvoiceAuditStatus(String name, int value, boolean queryOnly) {
		super(InvoiceAuditStatus.class.getName(), name, value);
		queryItems.add(this);
		if (!queryOnly) {
			items.add(this);
		}
	}
	protected InvoiceAuditStatus(String name, int value, String desc) {
		this(name, value, false);
		descMap.put(value, desc);
	}
	
	public static InvoiceAuditStatus getItem(int value){
		try {
			return (InvoiceAuditStatus) InvoiceAuditStatus.getResult(InvoiceAuditStatus.class.getName(), value);
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
	public static List<InvoiceAuditStatus> getItems() {
		return items;
	}
	public static List<InvoiceAuditStatus> getItemsForQuery() {
		return queryItems;
	}
	
	public static final InvoiceAuditStatus AUDITING = new InvoiceAuditStatus("AUDITING", 1, "审核中");
	public static final InvoiceAuditStatus PASS_AUDIT = new InvoiceAuditStatus("PASS_AUDIT", 2, "通过审核");
	public static final InvoiceAuditStatus FAIL_AUDIT = new InvoiceAuditStatus("FAIL_AUDIT", 3, "审核失败");

}
