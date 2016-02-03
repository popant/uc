package com.channelsoft.usercenter.consumable.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.channelsoft.usercenter.business.po.EnterpriseProductAjax;
import com.channelsoft.usercenter.consumable.mapper.ProductMapper;
import com.channelsoft.usercenter.consumable.po.Product;
import com.channelsoft.usercenter.consumable.po.ProductExample;
import com.channelsoft.usercenter.consumable.service.IProductService;

@Service
public class ProductService implements IProductService{
	
	private Logger logger = Logger.getLogger(getClass());
	
	@Autowired
	private ProductMapper productMapper;
	
	/**
	 * 查找当前企业开通的产品
	 */
	public List<Product> getProductsByEntId(int entId)throws Exception{
		logger.info("进入ProductService的getProductsByEntId()方法...");
		List<Product> result = null;
		result = productMapper.getProducts(entId);
		return result;
	}
	
	/**
	 * 得到当前企业
	 */
	public List<Product> getAllProducts()throws Exception{
		logger.info("进入ProductService的getAllProducts()方法...");
		ProductExample example = new ProductExample();
		example.createCriteria().getAllCriteria();
		return productMapper.selectByExample(example);
	}
	
	public List<EnterpriseProductAjax> getProductsDetail(String entId)throws Exception{
		return productMapper.getProductsDetail(entId);
	}
	
	public List<Product> getProductsNotOpenedByEntId(String entId)throws Exception{
		return productMapper.getProductsNotOpen(entId);
	}
}
