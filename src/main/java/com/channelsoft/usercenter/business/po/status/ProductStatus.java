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
public class ProductStatus extends IntegerBeanLabelItem {

	private static final long serialVersionUID = 1L;

	private static final Log logger = LogFactory.getLog(ProductStatus.class);

	private static List<ProductStatus> items = new ArrayList<ProductStatus>();
	private static List<ProductStatus> queryItems = new ArrayList<ProductStatus>();
	private static Map<Integer, String> descMap = new HashMap<Integer, String>();
	protected ProductStatus(String name, int value, boolean queryOnly) {
		super(ProductStatus.class.getName(), name, value);
		queryItems.add(this);
		if (!queryOnly) {
			items.add(this);
		}
	}
	protected ProductStatus(String name, int value, String desc) {
		this(name, value, false);
		descMap.put(value, desc);
	}
	
	public static ProductStatus getItem(int value){
		try {
			return (ProductStatus) ProductStatus.getResult(ProductStatus.class.getName(), value);
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
	public static List<ProductStatus> getItems() {
		return items;
	}
	public static List<ProductStatus> getItemsForQuery() {
		return queryItems;
	}
	
	public static final ProductStatus TRY = new ProductStatus("TRY", 1, "试用");
	public static final ProductStatus TRY_OUT = new ProductStatus("TRY_OUT", 2, "试用结束");
	public static final ProductStatus PENDING_COMMERCIAL = new ProductStatus("PENDING_COMMERCIAL", 3, "申请商用中");
	public static final ProductStatus COMMERCIAL = new ProductStatus("COMMERCIAL", 4, "商用");
	public static final ProductStatus COMMERCIAL_PAUSE = new ProductStatus("COMMERCIAL_PAUSE", 5, "商用暂停");
}
