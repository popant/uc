/**
 * 
 */
package com.channelsoft.usercenter.business.controller;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.channelsoft.usercenter.account.po.EnterpriseInfo;
import com.channelsoft.usercenter.account.po.UserInfo;
import com.channelsoft.usercenter.account.po.status.AuditStatus;
import com.channelsoft.usercenter.account.service.IEnterpriseInfoService;
import com.channelsoft.usercenter.business.factory.ProductHandlerFactory;
import com.channelsoft.usercenter.business.po.EnterpriseProductAjax;
import com.channelsoft.usercenter.business.po.status.ProductStatus;
import com.channelsoft.usercenter.business.service.IBusinessService;
import com.channelsoft.usercenter.common.controller.BaseController;
import com.channelsoft.usercenter.common.exception.HandlerException;
import com.channelsoft.usercenter.consumable.po.Product;
import com.channelsoft.usercenter.consumable.service.IProductService;

/**
 * <dl>
 * <dt>BusinessController</dt>
 * <dd>Description:产品开通Controller类</dd>
 * <dd>Copyright: Copyright (C) 2016</dd>
 * <dd>Company: 青牛（北京）技术有限公司</dd>
 * <dd>CreateDate: 2016年1月13日</dd>
 * </dl>
 * 
 * @author cy
 */
@Controller
@RequestMapping(value="/business")
public class BusinessController extends BaseController {
	
	@Autowired
	private IEnterpriseInfoService enterpriseInfoService;
	@Autowired
	private IProductService productService;
	@Autowired
	private ProductHandlerFactory productHandlerFactory;
	@Autowired
	private IBusinessService businessService;
	
	/**
	 * 产品开通展示页
	 * @return
	 */
	@RequiresAuthentication
	@RequestMapping(value="/list")
	public String gotoBusiness(){
		return "new_business/businessList";
	}
	
	/**
	 * 开通产品
	 * @param productId
	 * @return
	 */
	@RequiresAuthentication
	@ResponseBody
	@RequestMapping(value="/open")
	public String openBusiness(@RequestParam("id")String productId){
		logger.info("进入BusinessController.openBusiness()");
		UserInfo userInfo = getUserInfo();
		return productHandlerFactory.getProductHandler(productId).openBusiness(userInfo);
	}
	
	/**
	 * 产品开通展示页中需要初始化的数据.包含开通产品和未开通产品的信息
	 * @return
	 */
	@RequiresAuthentication
	@ResponseBody
	@RequestMapping(value="/init")
	public String initValue(){
		try {
			logger.info("进入BusinessController.initValue()");
			//查询企业本地数据状态
			UserInfo userInfo = getUserInfo();
			Integer entId = userInfo.getEnterpriseId();
			EnterpriseInfo enterpriseInfo = enterpriseInfoService.selectById(entId);
			//企业的认证状态
			Integer auditStatus = enterpriseInfo.getAuditStatus().getValue();
			logger.info("企业认证状态:"+auditStatus);
			
			//企业注册的所有产品详细信息
			List<EnterpriseProductAjax> productRelas = productService.getProductsDetail(entId.toString());
			logger.debug("===========企业注册的产品详细信息为:"+productRelas);
			for(EnterpriseProductAjax productRela:productRelas){
				//判断企业是否通过认证
				if(auditStatus==AuditStatus.PASS_AUDIT.getValue()){
					productRela.setPassAudit(true);
				}else{
					productRela.setPassAudit(false);
				}
				//此处调用各个产品服务的对应初始化方法进行初始化,结果塞入productRela中
				productHandlerFactory.getProductHandler(productRela.getProductId().toString()).initValue(productRela);
			}
			
			//搜集页面展示数据
			//所有未开通产品信息
			List<Product> notOpen = productService.getProductsNotOpenedByEntId(enterpriseInfo.getEnterpriseId().toString());
			//页面展示数据
			JSONObject ret = new JSONObject();
			ret.put("openedProducts", productRelas);
			ret.put("notOpenProducts", notOpen);
			ret.put("ret", "00");
			logger.debug("当前企业详细信息为:"+ret.toJSONString());
			return JSON.toJSONString(ret,SerializerFeature.DisableCircularReferenceDetect);
		}  catch (HandlerException e) {
			logger.error(e.getMessage(),e);
		}  catch (Exception e){
			logger.error(e.getMessage(),e);
		}
		JSONObject ret = new JSONObject();
		ret.put("ret", "-1");
		logger.debug("产品开通页初始化数据异常");
		return ret.toString();
	}
	
	/**
	 * 申请商用
	 * @param productId
	 * @return
	 */
	@RequiresAuthentication
	@ResponseBody
	@RequestMapping(value="/commercial/{productId}")
	public String forCommercial(@PathVariable("productId")String productId){
		try {
			logger.info("进入BusinessController.forCommercial()");
			logger.debug("接收到产品["+productId+"]的申请商用请求");
			UserInfo userInfo = getUserInfo();
			String ret = productHandlerFactory.getProductHandler(productId).forCommercial();
			if(StringUtils.hasText(ret)){
				JSONObject jo = JSONObject.parseObject(ret);
				if(jo.getString("ret").equals("00")){
					//申请成功,修改 本地企业状态为申请商用中
					businessService.updateProductStatus(userInfo.getEnterpriseId(), Integer.parseInt(productId), ProductStatus.PENDING_COMMERCIAL.getValue());
					JSONObject resp = new JSONObject();
					resp.put("ret", "00");
					resp.put("msg", "申请商用成功");
					return resp.toJSONString();
				}else{
					logger.info("申请商用失败");
				}
			}
		} catch (HandlerException e) {
			logger.error("申请商用异常",e);
		}
		JSONObject resp = new JSONObject();
		resp.put("ret", "-1");
		resp.put("msg", "申请商用失败");
		return resp.toJSONString();
	}

}
