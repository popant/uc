/**
 * 
 */
package com.channelsoft.usercenter.business.factory;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.channelsoft.usercenter.common.exception.HandlerException;

/**
 * <dl>
 * <dt>InterfaceFactory</dt>
 * <dd>Description:产品处理类的工厂类</dd>
 * <dd>Copyright: Copyright (C) 2016</dd>
 * <dd>Company: 青牛（北京）技术有限公司</dd>
 * <dd>CreateDate: 2016年1月15日</dd>
 * </dl>
 * 
 * @author cy
 */
@Component
public class ProductHandlerFactory {
	/**
	 * 处理类的映射信息,key为产品id,value为处理类
	 */
	@Resource(name="productHandlerMapping")
	private Map<String,ProductHandler> handlerMap;
	
	/**
	 * 根据产品id返回对应产品的处理类
	 * @param productId
	 * @return
	 */
	public ProductHandler getProductHandler(String productId){
		if(handlerMap.containsKey(productId)){
			return handlerMap.get(productId);
		}else{
			throw new HandlerException("不存在此产品");
		}
	}

}
