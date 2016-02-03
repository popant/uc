package com.channelsoft.usercenter.invoice.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.channelsoft.usercenter.invoice.po.InvoiceInfo;
import com.channelsoft.usercenter.invoice.po.InvoiceInfoExample;

public interface InvoiceInfoMapper {
    int countByExample(InvoiceInfoExample example);

    int deleteByExample(InvoiceInfoExample example);

    int deleteByPrimaryKey(Integer invoiceId);

    int insert(InvoiceInfo record);

    int insertSelective(InvoiceInfo record);

    List<InvoiceInfo> selectByExampleWithBLOBs(InvoiceInfoExample example);

    List<InvoiceInfo> selectByExample(InvoiceInfoExample example);

    InvoiceInfo selectByPrimaryKey(Integer invoiceId);

    int updateByExampleSelective(@Param("record") InvoiceInfo record, @Param("example") InvoiceInfoExample example);

    int updateByExampleWithBLOBs(@Param("record") InvoiceInfo record, @Param("example") InvoiceInfoExample example);

    int updateByExample(@Param("record") InvoiceInfo record, @Param("example") InvoiceInfoExample example);

    int updateByPrimaryKeySelective(InvoiceInfo record);

    int updateByPrimaryKeyWithBLOBs(InvoiceInfo record);

    int updateByPrimaryKey(InvoiceInfo record);
}