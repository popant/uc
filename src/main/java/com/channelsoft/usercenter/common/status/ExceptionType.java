/**
 * 
 */
package com.channelsoft.usercenter.common.status;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <dl>
 * <dt>UserType</dt>
 * <dd>Description:异常类型</dd>
 * <dd>Copyright: Copyright (C) 2006</dd>
 * <dd>Company: 青牛（北京）技术有限公司</dd>
 * <dd>CreateDate: 2016年1月10日</dd>
 * <dd>在这里，我们会在打异常的时候将其打出举个例子
 * catch(Exception e){
 *     logger.error(String.format("入库用户的时候出现异常:%s",ExceptionType.TEST.getValue()),e)
 * }
 * </dd>
 * </dl>
 * 
 * @author 安宁
 */
public class ExceptionType extends IntegerBeanLabelItem {

	private static final long serialVersionUID = 1L;

	private static final Log logger = LogFactory.getLog(ExceptionType.class);

	private static List<ExceptionType> items = new ArrayList<ExceptionType>();
	private static List<ExceptionType> queryItems = new ArrayList<ExceptionType>();
	private static Map<Integer, String> descMap = new HashMap<Integer, String>();
	protected ExceptionType(String name, int value, boolean queryOnly) {
		super(ExceptionType.class.getName(), name, value);
		queryItems.add(this);
		if (!queryOnly) {
			items.add(this);
		}
	}
	protected ExceptionType(String name, int value, String desc) {
		this(name, value, false);
		descMap.put(value, desc);
	}
	
	public static ExceptionType getItem(int value){
		try {
			return (ExceptionType) ExceptionType.getResult(ExceptionType.class.getName(), value);
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

	/**
	 * 获取完整的错误信息
	 * @return
	 */
	public String getErrMessage(){return this.getValue()+":"+this.getDesc();}
	public static List<ExceptionType> getItems() {
		return items;
	}
	public static List<ExceptionType> getItemsForQuery() {
		return queryItems;
	}

	/**
	 * 安宁使用的空间  0~100
	 */
	public static final ExceptionType TEST1= new ExceptionType("TEST-0x0000", 0, "这是一个测试");
	public static final ExceptionType REPEAT_LOGIN= new ExceptionType("UC-020001", 0, "重复登陆");
	/**
	 * 陈宇使用的空间 101~200
	 */
	public static final ExceptionType TEST2 = new ExceptionType("TEST-0x0101", 101, "这是一个测试");
	/**
	 * 张辰熇使用的空间 201~300
	 */
	public static final ExceptionType TEST3 = new ExceptionType("TEST-0x0201", 201, "这是一个测试");
	/**
	 * 肖迪使用的空间 301~400
	 */
	public static final ExceptionType TEST4 = new ExceptionType("TEST-0x0301", 301, "这是一个测试");
	/**
	 * 贾学雷使用的空间 401~无穷大
	 */
	public static final ExceptionType TEST5 = new ExceptionType("TEST-0x0401", 401, "这是一个测试");
}
