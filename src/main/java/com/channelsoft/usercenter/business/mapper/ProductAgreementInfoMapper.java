package com.channelsoft.usercenter.business.mapper;

import java.sql.Blob;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.channelsoft.usercenter.business.po.BlobResult;
import com.channelsoft.usercenter.business.po.ProductAgreementInfo;
import com.channelsoft.usercenter.business.po.ProductAgreementInfoExample;

public interface ProductAgreementInfoMapper {
    int countByExample(ProductAgreementInfoExample example);

    int deleteByExample(ProductAgreementInfoExample example);

    int deleteByPrimaryKey(Integer agreementId);

    int insert(ProductAgreementInfo record);

    int insertSelective(ProductAgreementInfo record);

    List<ProductAgreementInfo> selectByExampleWithBLOBs(ProductAgreementInfoExample example);

    List<ProductAgreementInfo> selectByExample(ProductAgreementInfoExample example);

    ProductAgreementInfo selectByPrimaryKey(Integer agreementId);

    int updateByExampleSelective(@Param("record") ProductAgreementInfo record, @Param("example") ProductAgreementInfoExample example);

    int updateByExampleWithBLOBs(@Param("record") ProductAgreementInfo record, @Param("example") ProductAgreementInfoExample example);

    int updateByExample(@Param("record") ProductAgreementInfo record, @Param("example") ProductAgreementInfoExample example);

    int updateByPrimaryKeySelective(ProductAgreementInfo record);

    int updateByPrimaryKeyWithBLOBs(ProductAgreementInfo record);

    int updateByPrimaryKey(ProductAgreementInfo record);
    
    BlobResult selectImg(@Param("entId") String entId, @Param("productId") Integer productId);
    
    BlobResult selectDoc(@Param("entId") String entId, @Param("productId") Integer productId);
}