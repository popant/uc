/**
 * 
 */
package com.channelsoft.usercenter.invoice.service.impl;

import java.math.BigDecimal;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.channelsoft.usercenter.common.exception.ServiceException;
import com.channelsoft.usercenter.invoice.mapper.InvoiceRecordMapper;
import com.channelsoft.usercenter.invoice.po.InvoiceRecord;
import com.channelsoft.usercenter.invoice.service.IInvoiceRecordService;

/**
 * <dl>
 * <dt>InvoiceInfoServiceImpl</dt>
 * <dd>Description:索取发票记录service实现类</dd>
 * <dd>Copyright: Copyright (C) 2016</dd>
 * <dd>Company: 青牛（北京）技术有限公司</dd>
 * <dd>CreateDate: 2016年1月19日</dd>
 * </dl>
 * 
 * @author cy
 */
@Service
public class InvoiceRecordServiceImpl implements IInvoiceRecordService {
	@Autowired
	private InvoiceRecordMapper recordMapper;
	
	protected Logger logger = Logger.getLogger(getClass());


	/* (non-Javadoc)
	 * @see com.channelsoft.usercenter.invoice.service.IInvoiceInfoService#getSumInvoiceMoneyStatics(java.lang.Integer)
	 */
	@Override
	public BigDecimal getSumInvoiceMoneyStatics(Integer entId) {
		logger.info("进入InvoiceRecordServiceImpl.getSumInvoiceMoneyStatics()");
		return recordMapper.getSumInvoiceMoneyStatics(entId);
	}
	
	/* (non-Javadoc)
	 * @see com.channelsoft.usercenter.invoice.service.IInvoiceInfoService#saveInvoiceRecord(com.channelsoft.usercenter.invoice.po.InvoiceRecord)
	 */
	@Override
	public Integer saveInvoiceRecord(InvoiceRecord invoiceRecord) throws ServiceException  {
		logger.info("进入InvoiceRecordServiceImpl.saveInvoiceRecord()");
		return recordMapper.insertSelective(invoiceRecord);
	}

}
