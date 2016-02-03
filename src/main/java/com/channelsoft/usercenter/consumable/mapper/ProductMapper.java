package com.channelsoft.usercenter.consumable.mapper;

import com.channelsoft.usercenter.business.po.EnterpriseProductAjax;
import com.channelsoft.usercenter.consumable.po.Product;
import com.channelsoft.usercenter.consumable.po.ProductExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface ProductMapper {
    int countByExample(ProductExample example);

    int deleteByExample(ProductExample example);

    int deleteByPrimaryKey(Integer productId);

    int insert(Product record);

    int insertSelective(Product record);

    List<Product> selectByExample(ProductExample example);

    Product selectByPrimaryKey(Integer productId);

    int updateByExampleSelective(@Param("record") Product record, @Param("example") ProductExample example);

    int updateByExample(@Param("record") Product record, @Param("example") ProductExample example);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);
    
    public List<Product> getProducts(int entId);
    
    public List<Product> getProductsNotOpen(String entId);
    
    public List<EnterpriseProductAjax> getProductsDetail(String entId);

}