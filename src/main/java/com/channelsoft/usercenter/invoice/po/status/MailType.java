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
 * <dd>Description:邮寄类型</dd>
 * <dd>Copyright: Copyright (C) 2006</dd>
 * <dd>Company: 青牛（北京）技术有限公司</dd>
 * <dd>CreateDate: 2016年1月10日</dd>
 * </dl>
 * 
 * @author 安宁
 */
public class MailType extends IntegerBeanLabelItem {

	private static final long serialVersionUID = 1L;

	private static final Log logger = LogFactory.getLog(MailType.class);

	private static List<MailType> items = new ArrayList<MailType>();
	private static List<MailType> queryItems = new ArrayList<MailType>();
	private static Map<Integer, String> descMap = new HashMap<Integer, String>();
	protected MailType(String name, int value, boolean queryOnly) {
		super(MailType.class.getName(), name, value);
		queryItems.add(this);
		if (!queryOnly) {
			items.add(this);
		}
	}
	protected MailType(String name, int value, String desc) {
		this(name, value, false);
		descMap.put(value, desc);
	}
	
	public static MailType getItem(int value){
		try {
			return (MailType) MailType.getResult(MailType.class.getName(), value);
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
	public static List<MailType> getItems() {
		return items;
	}
	public static List<MailType> getItemsForQuery() {
		return queryItems;
	}
	
	public static final MailType SF_EXPRESS = new MailType("SF_EXPRESS", 1, "顺丰");
	public static final MailType STO_EXPRESS = new MailType("STO_EXPRESS", 2, "申通");
	public static final MailType YUNDA_EXPRESS = new MailType("YUNDA_EXPRESS", 3, "韵达");
	public static final MailType YTO_EXPRESS = new MailType("YTO_EXPRESS", 4, "圆通");
	public static final MailType ZTO_EXPRESS = new MailType("ZTO_EXPRESS", 5, "中通");

}
