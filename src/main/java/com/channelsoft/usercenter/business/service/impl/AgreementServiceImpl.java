/**
 * 
 */
package com.channelsoft.usercenter.business.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.channelsoft.usercenter.business.mapper.ProductAgreementInfoMapper;
import com.channelsoft.usercenter.business.po.BlobResult;
import com.channelsoft.usercenter.business.po.ProductAgreementInfo;
import com.channelsoft.usercenter.business.po.ProductAgreementInfoExample;
import com.channelsoft.usercenter.business.service.IAgreementService;
import com.channelsoft.usercenter.common.exception.ServiceException;

/**
 * <dl>
 * <dt>AgreementService</dt>
 * <dd>Description:合同service实现类</dd>
 * <dd>Copyright: Copyright (C) 2016</dd>
 * <dd>Company: 青牛（北京）技术有限公司</dd>
 * <dd>CreateDate: 2016年1月18日</dd>
 * </dl>
 * 
 * @author cy
 */
@Service
public class AgreementServiceImpl implements IAgreementService {
	@Autowired
	private ProductAgreementInfoMapper mapper;
	
	protected Logger logger = Logger.getLogger(getClass());

	/* (non-Javadoc)
	 * @see com.channelsoft.usercenter.business.service.IAgreementService#getAgreementByEntIdAndProductId(java.lang.String, java.lang.String)
	 */
	@Override
	public ProductAgreementInfo getAgreementByEntIdAndProductId(String entId,
			Integer productId) throws ServiceException {
		logger.info("进入AgreementServiceImpl.getAgreementByEntIdAndProductId()");
		ProductAgreementInfoExample expl = new ProductAgreementInfoExample();
		expl.createCriteria().andEnterpriseIdEqualTo(entId).andProductIdEqualTo(productId);
		List<ProductAgreementInfo> agree = mapper.selectByExampleWithBLOBs(expl);
		if(agree==null){
			throw new ServiceException("无此合同文件");
		}else if(agree!=null&&agree.size()>1){
			throw new ServiceException("合同文件不唯一");
		}else{
			return agree.get(0);
		}
	}

	/* (non-Javadoc)
	 * @see com.channelsoft.usercenter.business.service.IAgreementService#addAgreementInfo(com.channelsoft.usercenter.business.po.ProductAgreementInfo)
	 */
	@Override
	public Integer addAgreementInfo(ProductAgreementInfo info)
			throws ServiceException {
		logger.info("进入AgreementServiceImpl.addAgreementInfo()");
		return mapper.insertSelective(info);
	}

	/* (non-Javadoc)
	 * @see com.channelsoft.usercenter.business.service.IAgreementService#getImg(java.lang.String, java.lang.Integer)
	 */
	@Override
	public byte[] getImg(String entId, Integer productId){
		logger.info("进入AgreementServiceImpl.getImg()");
		BlobResult b =  mapper.selectImg(entId, productId);
		return b.getResult();
	}

	/* (non-Javadoc)
	 * @see com.channelsoft.usercenter.business.service.IAgreementService#getDoc(java.lang.String, java.lang.Integer)
	 */
	@Override
	public byte[] getDoc(String entId, Integer productId)
			throws ServiceException {
		logger.info("进入AgreementServiceImpl.getDoc()");
		BlobResult b =  mapper.selectDoc(entId, productId);
		return b.getResult();
	}
	
	

}
