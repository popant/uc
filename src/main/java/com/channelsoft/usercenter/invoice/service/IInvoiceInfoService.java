/**
 * 
 */
package com.channelsoft.usercenter.invoice.service;

import com.channelsoft.usercenter.common.exception.ServiceException;
import com.channelsoft.usercenter.invoice.po.InvoiceInfo;
import com.channelsoft.usercenter.invoice.po.InvoiceInfoExample;

/**
 * <dl>
 * <dt>InvoiceInfoService</dt>
 * <dd>Description:发票信息service接口</dd>
 * <dd>Copyright: Copyright (C) 2016</dd>
 * <dd>Company: 青牛（北京）技术有限公司</dd>
 * <dd>CreateDate: 2016年1月19日</dd>
 * </dl>
 * 
 * @author cy
 */
public interface IInvoiceInfoService {
	/**
	 * 保存发票信息
	 * @param invoiceInfo
	 * @return
	 * @throws ServiceException
	 */
	public Integer saveInvoiceInfo(InvoiceInfo invoiceInfo) throws ServiceException ;
	/**
	 * 获取通过审核的发票信息
	 * @param entId
	 * @return
	 * @throws ServiceException
	 */
	public InvoiceInfo getPassAuditInvoiceInfo(Integer entId) throws ServiceException ;
	/**
	 * 获取发票信息
	 * @param entId
	 * @return
	 * @throws ServiceException
	 */
	public InvoiceInfo getInvoiceInfo(InvoiceInfoExample exp) throws ServiceException ;
	/**
	 * 获取发票信息(带blob图片文档信息)
	 * @param entId
	 * @return
	 * @throws ServiceException
	 */
	public InvoiceInfo getInvoiceInfoWithBlob(Integer entId) throws ServiceException ;

}
