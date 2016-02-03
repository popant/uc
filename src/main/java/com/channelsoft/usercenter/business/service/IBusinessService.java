/**
 * 
 */
package com.channelsoft.usercenter.business.service;

import java.util.List;

import com.channelsoft.usercenter.common.exception.ServiceException;
import com.channelsoft.usercenter.consumable.po.EnterpriseProductRela;
import com.channelsoft.usercenter.consumable.po.EnterpriseProductRelaExample;

/**
 * <dl>
 * <dt>BusinessService</dt>
 * <dd>Description:产品开通service接口</dd>
 * <dd>Copyright: Copyright (C) 2016</dd>
 * <dd>Company: 青牛（北京）技术有限公司</dd>
 * <dd>CreateDate: 2016年1月14日</dd>
 * </dl>
 * 
 * @author cy
 */
public interface IBusinessService {
	
	/**
	 * 通过企业id查询产品企业关联信息
	 * @param entId
	 * @return
	 * @throws ServiceException
	 */
	public List<EnterpriseProductRela> getProductRelaByEnterpriseId(String entId) throws ServiceException;
	/**
	 * 更新产品企业关联信息
	 * @param entProductRela
	 * @param expl
	 * @return
	 * @throws ServiceException
	 */
	public Integer updateEnterpriseProductRela(EnterpriseProductRela entProductRela, EnterpriseProductRelaExample expl) throws ServiceException;
	/**
	 * 按照主键更新企业开通产品的状态信息
	 * @param id
	 * @param remoteStatus
	 * @return
	 * @throws ServiceException
	 */
	public Integer updateProductStatus(Integer id, Integer remoteStatus) throws ServiceException;
	/**
	 * 按照企业id和产品id更新企业开通产品的状态信息
	 * @param entId
	 * @param productId
	 * @param remoteStatus
	 * @return
	 * @throws ServiceException
	 */
	public Integer updateProductStatus(Integer entId, Integer productId, Integer remoteStatus) throws ServiceException;
	/**
	 * 保存企业产品关联信息
	 * @param entProductRela
	 * @return
	 * @throws ServiceException
	 */
	public Integer insertEnterpriseProductRela(EnterpriseProductRela entProductRela)throws ServiceException;
	
}
