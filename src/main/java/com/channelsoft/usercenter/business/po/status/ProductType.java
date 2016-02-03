/**
 * 
 */
package com.channelsoft.usercenter.business.po.status;

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
public class ProductType extends IntegerBeanLabelItem {

	private static final long serialVersionUID = 1L;

	private static final Log logger = LogFactory.getLog(ProductType.class);

	private static List<ProductType> items = new ArrayList<ProductType>();
	private static List<ProductType> queryItems = new ArrayList<ProductType>();
	private static Map<Integer, String> descMap = new HashMap<Integer, String>();
	protected ProductType(String name, int value, boolean queryOnly) {
		super(ProductType.class.getName(), name, value);
		queryItems.add(this);
		if (!queryOnly) {
			items.add(this);
		}
	}
	protected ProductType(String name, int value, String desc) {
		this(name, value, false);
		descMap.put(value, desc);
	}
	
	public static ProductType getItem(int value){
		try {
			return (ProductType) ProductType.getResult(ProductType.class.getName(), value);
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
	public static List<ProductType> getItems() {
		return items;
	}
	public static List<ProductType> getItemsForQuery() {
		return queryItems;
	}
	
	public static final ProductType YLB = new ProductType("YLB", 1, "云联保");
	public static final ProductType ONLINE_VIDEO = new ProductType("ONLINE_VIDEO", 2, "在线视频");
	public static final ProductType SMS_SERVICE = new ProductType("SMS_SERVICE", 3, "短信服务");
}
