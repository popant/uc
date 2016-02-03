/**
 * 
 */
package com.channelsoft.usercenter.invoice.service;

import java.math.BigDecimal;

import com.channelsoft.usercenter.common.exception.ServiceException;
import com.channelsoft.usercenter.invoice.po.InvoiceRecord;

/**
 * <dl>
 * <dt>InvoiceInfoService</dt>
 * <dd>Description:索取发票记录service接口</dd>
 * <dd>Copyright: Copyright (C) 2016</dd>
 * <dd>Company: 青牛（北京）技术有限公司</dd>
 * <dd>CreateDate: 2016年1月19日</dd>
 * </dl>
 * 
 * @author cy
 */
public interface IInvoiceRecordService {
	/**
	 * 获取可开发票最大消费金额
	 * @param entId
	 * @return
	 * @throws ServiceException
	 */
	public BigDecimal getSumInvoiceMoneyStatics(Integer entId) throws ServiceException ;
	/**
	 * 保存索取发票记录信息
	 * @param invoiceRecord
	 * @return
	 * @throws ServiceException
	 */
	public Integer saveInvoiceRecord(InvoiceRecord invoiceRecord) throws ServiceException ;

}
