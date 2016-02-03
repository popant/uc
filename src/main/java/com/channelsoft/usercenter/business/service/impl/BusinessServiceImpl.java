/**
 * 
 */
package com.channelsoft.usercenter.business.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.channelsoft.usercenter.account.mapper.EnterpriseInfoMapper;
import com.channelsoft.usercenter.account.mapper.UserInfoMapper;
import com.channelsoft.usercenter.business.po.status.ProductStatus;
import com.channelsoft.usercenter.business.service.IBusinessService;
import com.channelsoft.usercenter.common.exception.ServiceException;
import com.channelsoft.usercenter.consumable.mapper.EnterpriseProductRelaMapper;
import com.channelsoft.usercenter.consumable.mapper.ProductMapper;
import com.channelsoft.usercenter.consumable.po.EnterpriseProductRela;
import com.channelsoft.usercenter.consumable.po.EnterpriseProductRelaExample;

/**
 * <dl>
 * <dt>BusinessServiceImpl</dt>
 * <dd>Description:产品开通service实现类</dd>
 * <dd>Copyright: Copyright (C) 2016</dd>
 * <dd>Company: 青牛（北京）技术有限公司</dd>
 * <dd>CreateDate: 2016年1月14日</dd>
 * </dl>
 * 
 * @author cy
 */
@Service
public class BusinessServiceImpl implements IBusinessService {
	
	@Autowired
	private EnterpriseInfoMapper enterpriseInfoMapper;
	@Autowired
	private EnterpriseProductRelaMapper enterpriseProductRelMapper;
	@Autowired
	private ProductMapper productMapper;
	@Autowired
	private UserInfoMapper userInfoMapper;
	
	protected Logger logger = Logger.getLogger(getClass());

	
	/**
	 * 根据企业id获取企业开通的所有产品关联信息
	 */
	public List<EnterpriseProductRela> getProductRelaByEnterpriseId(String entId){
		logger.info("进入BusinessServiceImpl.getProductRelaByEnterpriseId()");
		try {
			EnterpriseProductRelaExample example = new EnterpriseProductRelaExample();
			example.createCriteria().andEnterpriseIdEqualTo(entId);
			return enterpriseProductRelMapper.selectByExample(example);
		} catch (Exception e) {
			throw new ServiceException("获取企业开通的所有产品关联信息异常");
		}
	}

	/* (non-Javadoc)
	 * @see com.channelsoft.usercenter.business.service.IBusinessService#updateEnterpriseProductRela(com.channelsoft.usercenter.consumable.po.EnterpriseProductRela)
	 */
	@Override
	public Integer updateEnterpriseProductRela(
			EnterpriseProductRela entProductRela, EnterpriseProductRelaExample expl) throws ServiceException {
		logger.info("进入BusinessServiceImpl.updateEnterpriseProductRela()");
		try {
			return enterpriseProductRelMapper.updateByExampleSelective(entProductRela, expl);
		} catch (Exception e) {
			throw new ServiceException("修改企业产品关联信息异常");
		}
	}
	
	/**
	 * 根据主键更新企业产品关联表中的产品状态
	 */
	public Integer updateProductStatus(Integer id, Integer remoteStatus) throws ServiceException {
		logger.info("进入BusinessServiceImpl.updateProductStatus()");
		try {
			//根据远端的状态更新本地状态
			EnterpriseProductRela relaToUpdate = new EnterpriseProductRela();
			relaToUpdate.setStatus(ProductStatus.getItem(remoteStatus));
			EnterpriseProductRelaExample expl = new EnterpriseProductRelaExample();
			expl.createCriteria().andIdEqualTo(id);
			return updateEnterpriseProductRela(relaToUpdate, expl);
		} catch (Exception e) {
			throw new ServiceException("更新企业产品当前状态异常");
		}
	}
	
	/**
	 * 根据企业id和产品id更新企业产品关联表中的产品状态
	 */
	public Integer updateProductStatus(Integer entId, Integer productId, Integer remoteStatus) throws ServiceException {
		logger.info("进入BusinessServiceImpl.updateProductStatus()");
		try {
			//根据远端的状态更新本地状态
			EnterpriseProductRela relaToUpdate = new EnterpriseProductRela();
			relaToUpdate.setStatus(ProductStatus.getItem(remoteStatus));
			EnterpriseProductRelaExample expl = new EnterpriseProductRelaExample();
			expl.createCriteria().andProductIdEqualTo(productId.shortValue()).andEnterpriseIdEqualTo(entId.toString());
			return updateEnterpriseProductRela(relaToUpdate, expl);
		} catch (Exception e) {
			throw new ServiceException("更新企业产品当前状态异常");
		}
	}
	
	/**
	 * 增加一条企业产品关联记录
	 */
	public Integer insertEnterpriseProductRela(EnterpriseProductRela entProductRela)throws ServiceException{
		logger.info("进入BusinessServiceImpl.insertEnterpriseProductRela()");
		try {
			return enterpriseProductRelMapper.insertSelective(entProductRela);
		} catch (Exception e) {
			throw new ServiceException("保存企业新开通的产品关联信息异常");
		}
	}

}
