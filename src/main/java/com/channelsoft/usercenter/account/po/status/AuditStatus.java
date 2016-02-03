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
 * <dd>Description:审核状态</dd>
 * <dd>Copyright: Copyright (C) 2006</dd>
 * <dd>Company: 青牛（北京）技术有限公司</dd>
 * <dd>CreateDate: 2016年1月10日</dd>
 * </dl>
 * 
 * @author 安宁
 */
public class AuditStatus extends IntegerBeanLabelItem {

	private static final long serialVersionUID = 1L;

	private static final Log logger = LogFactory.getLog(AuditStatus.class);

	private static List<AuditStatus> items = new ArrayList<AuditStatus>();
	private static List<AuditStatus> queryItems = new ArrayList<AuditStatus>();
	private static Map<Integer, String> descMap = new HashMap<Integer, String>();
	protected AuditStatus(String name, int value, boolean queryOnly) {
		super(AuditStatus.class.getName(), name, value);
		queryItems.add(this);
		if (!queryOnly) {
			items.add(this);
		}
	}
	protected AuditStatus(String name, int value, String desc) {
		this(name, value, false);
		descMap.put(value, desc);
	}
	
	public static AuditStatus getItem(int value){
		try {
			return (AuditStatus) AuditStatus.getResult(AuditStatus.class.getName(), value);
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
	public static List<AuditStatus> getItems() {
		return items;
	}
	public static List<AuditStatus> getItemsForQuery() {
		return queryItems;
	}
	
	public static final AuditStatus NOT_AUDIT = new AuditStatus("NO_AUDIT", 1, "未审核");
	public static final AuditStatus AUDITING = new AuditStatus("AUDITING", 2, "审核中");
	public static final AuditStatus PASS_AUDIT = new AuditStatus("PASS_AUDIT", 3, "通过审核");
	public static final AuditStatus FAIL_AUDIT = new AuditStatus("FAIL_AUDIT", 4, "审核失败");

}
