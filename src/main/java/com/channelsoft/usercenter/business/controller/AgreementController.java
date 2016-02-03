/**
 * 
 */
package com.channelsoft.usercenter.business.controller;

import java.io.IOException;
import java.util.Date;

import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.channelsoft.usercenter.account.po.UserInfo;
import com.channelsoft.usercenter.business.po.ProductAgreementInfo;
import com.channelsoft.usercenter.business.service.IAgreementService;
import com.channelsoft.usercenter.common.controller.BaseController;
import com.channelsoft.usercenter.common.exception.ServiceException;

/**
 * <dl>
 * <dt>AgreementController</dt>
 * <dd>Description:合同controller类</dd>
 * <dd>Copyright: Copyright (C) 2016</dd>
 * <dd>Company: 青牛（北京）技术有限公司</dd>
 * <dd>CreateDate: 2016年1月16日</dd>
 * </dl>
 * 
 * @author cy
 */
@Controller
@RequestMapping(value = "/agreement")
public class AgreementController extends BaseController {
	@Autowired
	private IAgreementService agreementService;
    
	@RequiresAuthentication
	@RequestMapping(value = "/control")
	public String gotoAgreementControl2() {
		return "business/agreement";
	}
	
	/**
	 * 申请合同
	 * @param entId
	 * @param productId
	 * @param model
	 * @return
	 */
	@RequiresAuthentication
	@RequestMapping(value = "/display/{productId}")
	public String gotoAgreementControl(@PathVariable("productId") String productId, Model model) {
		logger.debug("进入AgreementController.gotoAgreementControl()");
		UserInfo userInfo = getUserInfo();
		model.addAttribute("entId", userInfo.getEnterpriseId());
		model.addAttribute("productId", productId);
		return "new_business/downloadAgreement";
	}

	@RequestMapping(value = "/uploadAgreement", method = RequestMethod.POST)
	public String uploadAgreement(@RequestParam("agreeFile") MultipartFile file,@RequestParam("imgFile") MultipartFile img) {
		try {
			logger.debug("进入AgreementController.uploadAgreement()");
			ProductAgreementInfo agree = new ProductAgreementInfo();
			agree.setCreatePerson("tester");
			agree.setCreateTime(new Date());
			agree.setEnterpriseId("1");
			agree.setProductId(1);
			agree.setAgreementDoc(file.getBytes());
			agree.setDocScan(img.getBytes());
			logger.debug("========byte[]:"+agree.getAgreementDoc());
			Integer ret = agreementService.addAgreementInfo(agree);
			logger.debug("成功条数:" + ret);
		} catch (ServiceException e) {
			logger.error(e);
		} catch (IOException e) {
			logger.error(e);
		}
		return "business/ok";
	}
	
	/**
	 * 下载合同文档
	 * @param entId
	 * @param productId
	 * @return
	 * @throws IOException
	 */
	@RequiresAuthentication
	@RequestMapping(value="/download/{productId}")  
    public ResponseEntity<byte[]> downLoadDoc(@PathVariable("productId") String productId) throws IOException {  
    	logger.debug("进入AgreementController.downLoadDoc()");
    	UserInfo userInfo = getUserInfo();
    	HttpHeaders headers = new HttpHeaders();  
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);    
        headers.setContentDispositionFormData("attachment", "test.doc");  
        return new ResponseEntity<byte[]>(agreementService.getDoc(userInfo.getEnterpriseId().toString(), Integer.parseInt(productId)),    
                                              headers, HttpStatus.CREATED);    
    }  
    
    /**
     * 下载合同扫描件
     * @param entId
     * @param productId
     * @return
     * @throws IOException
     */
    @RequiresAuthentication
	@RequestMapping(value="/loadImg/{productId}")  
    public ResponseEntity<byte[]> downLoadImg(@PathVariable("productId") String productId) throws IOException {  
    	logger.debug("进入AgreementController.downLoadImg()");
    	UserInfo userInfo = getUserInfo();
    	HttpHeaders headers = new HttpHeaders();  
        headers.setContentType(MediaType.IMAGE_JPEG);    
        headers.setContentDispositionFormData("attachment", "test.jpg");  
        return new ResponseEntity<byte[]>(agreementService.getImg(userInfo.getEnterpriseId().toString(), Integer.parseInt(productId)),    
                                              headers, HttpStatus.OK);    
    }  

}
