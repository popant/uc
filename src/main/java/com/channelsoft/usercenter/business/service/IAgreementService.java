/**
 * 
 */
package com.channelsoft.usercenter.business.service;

import com.channelsoft.usercenter.business.po.ProductAgreementInfo;
import com.channelsoft.usercenter.common.exception.ServiceException;

/**
 * <dl>
 * <dt>agreementService</dt>
 * <dd>Description:合同service接口</dd>
 * <dd>Copyright: Copyright (C) 2016</dd>
 * <dd>Company: 青牛（北京）技术有限公司</dd>
 * <dd>CreateDate: 2016年1月18日</dd>
 * </dl>
 * 
 * @author cy
 */
public interface IAgreementService {
	/**
	 * 根据企业id和产品id获取合同信息
	 * @param entId
	 * @param productId
	 * @return
	 * @throws ServiceException
	 */
	public ProductAgreementInfo getAgreementByEntIdAndProductId(String entId, Integer productId) throws ServiceException;
	/**
	 * 增加合同信息
	 * @param info
	 * @return
	 * @throws ServiceException
	 */
	public Integer addAgreementInfo(ProductAgreementInfo info) throws ServiceException;
	/**
	 * 获取合同的扫描件图
	 * @param entId
	 * @param productId
	 * @return
	 * @throws ServiceException
	 */
	public byte[] getImg(String entId, Integer productId) throws ServiceException;
	/**
	 * 获取合同文档信息
	 * @param entId
	 * @param productId
	 * @return
	 * @throws ServiceException
	 */
	public byte[] getDoc(String entId, Integer productId) throws ServiceException;

}
