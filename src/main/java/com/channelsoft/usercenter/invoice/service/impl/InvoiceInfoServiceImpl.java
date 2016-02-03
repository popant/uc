/**
 * 
 */
package com.channelsoft.usercenter.invoice.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.channelsoft.usercenter.account.po.status.AuditStatus;
import com.channelsoft.usercenter.common.exception.ServiceException;
import com.channelsoft.usercenter.invoice.mapper.InvoiceInfoMapper;
import com.channelsoft.usercenter.invoice.po.InvoiceInfo;
import com.channelsoft.usercenter.invoice.po.InvoiceInfoExample;
import com.channelsoft.usercenter.invoice.po.status.InvoiceAuditStatus;
import com.channelsoft.usercenter.invoice.service.IInvoiceInfoService;

/**
 * <dl>
 * <dt>InvoiceInfoServiceImpl</dt>
 * <dd>Description:发票信息service实现类</dd>
 * <dd>Copyright: Copyright (C) 2016</dd>
 * <dd>Company: 青牛（北京）技术有限公司</dd>
 * <dd>CreateDate: 2016年1月19日</dd>
 * </dl>
 * 
 * @author cy
 */
@Service
public class InvoiceInfoServiceImpl implements IInvoiceInfoService {
	@Autowired
	private InvoiceInfoMapper infoMapper;
	
	protected Logger logger = Logger.getLogger(getClass());
	

	/* (non-Javadoc)
	 * @see com.channelsoft.usercenter.invoice.service.InvoiceInfoService#saveInvoiceInfo(com.channelsoft.usercenter.invoice.po.InvoiceInfo)
	 */
	@Override
	public Integer saveInvoiceInfo(InvoiceInfo invoiceInfo) throws ServiceException  {
		InvoiceInfoExample exp = new InvoiceInfoExample();
		exp.createCriteria().andEnterpriseIdEqualTo(invoiceInfo.getEnterpriseId());
		InvoiceInfo old = getInvoiceInfo(exp);
		if(invoiceInfo.getBusinessLicence()!=null&&invoiceInfo.getBusinessLicence().length==0){
			invoiceInfo.setBusinessLicence(null);
		}
		if(invoiceInfo.getTaxRegistration()!=null&&invoiceInfo.getTaxRegistration().length==0){
			invoiceInfo.setTaxRegistration(null);
		}
		if(invoiceInfo.getGeneralTaxQua()!=null&&invoiceInfo.getGeneralTaxQua().length==0){
			invoiceInfo.setGeneralTaxQua(null);
		}
		if(old!=null){
			invoiceInfo.setInvoiceId(old.getInvoiceId());
			if(invoiceInfo.getAuditStatus().getValue()!=AuditStatus.FAIL_AUDIT.getValue()){
				invoiceInfo.setAuditInfo("");
			}
			return infoMapper.updateByPrimaryKeySelective(invoiceInfo);
		}
		return infoMapper.insertSelective(invoiceInfo);
	}



	/* (non-Javadoc)
	 * @see com.channelsoft.usercenter.invoice.service.IInvoiceInfoService#getInvoiceInfo(java.lang.Integer)
	 */
	@Override
	public InvoiceInfo getInvoiceInfo(InvoiceInfoExample exp) throws ServiceException {
		logger.info("进入InvoiceInfoServiceImpl.getInvoiceInfo()");
		List<InvoiceInfo> infos = infoMapper.selectByExample(exp);
		if(infos!=null&&infos.size()==1){
			return infos.get(0);
		}else{
			return null;
		}
	}



	/* (non-Javadoc)
	 * @see com.channelsoft.usercenter.invoice.service.IInvoiceInfoService#getInvoiceInfoWithBlob(java.lang.Integer)
	 */
	@Override
	public InvoiceInfo getInvoiceInfoWithBlob(Integer entId)
			throws ServiceException {
		logger.info("进入InvoiceInfoServiceImpl.getInvoiceInfoWithBlob()");
		InvoiceInfoExample exp = new InvoiceInfoExample();
		exp.createCriteria().andEnterpriseIdEqualTo(entId.toString());
		List<InvoiceInfo> infos = infoMapper.selectByExampleWithBLOBs(exp);
		if(infos!=null&&infos.size()>=1){
			return infos.get(0);
		}else{
			return null;
		}
	}



	/* (non-Javadoc)
	 * @see com.channelsoft.usercenter.invoice.service.IInvoiceInfoService#getPassAuditInvoiceInfo(java.lang.Integer)
	 */
	@Override
	public InvoiceInfo getPassAuditInvoiceInfo(Integer entId)
			throws ServiceException {
		InvoiceInfoExample exp = new InvoiceInfoExample();
		exp.createCriteria().andEnterpriseIdEqualTo(entId.toString()).andAuditStatusEqualTo(InvoiceAuditStatus.PASS_AUDIT);
		return getInvoiceInfo(exp);
	}

}
