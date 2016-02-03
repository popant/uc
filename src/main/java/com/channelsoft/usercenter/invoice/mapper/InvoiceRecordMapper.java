package com.channelsoft.usercenter.invoice.mapper;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.channelsoft.usercenter.invoice.po.InvoiceRecord;
import com.channelsoft.usercenter.invoice.po.InvoiceRecordExample;

public interface InvoiceRecordMapper {
    int countByExample(InvoiceRecordExample example);

    int deleteByExample(InvoiceRecordExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(InvoiceRecord record);

    int insertSelective(InvoiceRecord record);

    List<InvoiceRecord> selectByExample(InvoiceRecordExample example);

    InvoiceRecord selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") InvoiceRecord record, @Param("example") InvoiceRecordExample example);

    int updateByExample(@Param("record") InvoiceRecord record, @Param("example") InvoiceRecordExample example);

    int updateByPrimaryKeySelective(InvoiceRecord record);

    int updateByPrimaryKey(InvoiceRecord record);
    
    BigDecimal getSumInvoiceMoneyStatics(Integer entId);
}