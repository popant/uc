package com.channelsoft.usercenter.consumable.service;

import java.util.List;

import com.channelsoft.usercenter.business.po.EnterpriseProductAjax;
import com.channelsoft.usercenter.consumable.po.Product;

public interface IProductService {
	public List<Product> getProductsByEntId(int entId) throws Exception;
	public List<Product> getAllProducts() throws Exception;
	/**
	 * 获取企业开通产品的详细信息
	 * @param entId 企业id
	 * @return
	 * @throws Exception
	 */
	public List<EnterpriseProductAjax> getProductsDetail(String entId) throws Exception;
	/**
	 * 获取企业未开通产品的信息
	 * @param entId 企业id
	 * @return
	 * @throws Exception
	 */
	public List<Product> getProductsNotOpenedByEntId(String entId) throws Exception;
}
