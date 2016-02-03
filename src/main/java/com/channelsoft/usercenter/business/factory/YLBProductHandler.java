/**
 * 
 */
package com.channelsoft.usercenter.business.factory;

import java.io.IOException;
import java.math.BigDecimal;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSONObject;
import com.channelsoft.usercenter.account.po.UserInfo;
import com.channelsoft.usercenter.business.po.EnterpriseProductAjax;
import com.channelsoft.usercenter.business.po.status.ProductStatus;
import com.channelsoft.usercenter.business.service.IBusinessService;
import com.channelsoft.usercenter.common.exception.HandlerException;
import com.channelsoft.usercenter.common.exception.ServiceException;
import com.channelsoft.usercenter.consumable.po.ConsumableStatistic;
import com.channelsoft.usercenter.consumable.po.EnterpriseProductRela;
import com.channelsoft.usercenter.consumable.service.IConsumeService;

/**
 * <dl>
 * <dt>YLBProductHandler</dt>
 * <dd>Description:云联宝产品处理类</dd>
 * <dd>Copyright: Copyright (C) 2016</dd>
 * <dd>Company: 青牛（北京）技术有限公司</dd>
 * <dd>CreateDate: 2016年1月15日</dd>
 * </dl>
 * 
 * @author cy
 */
@Component("yLBProductHandler")
public class YLBProductHandler implements ProductHandler {
	
	protected Logger logger = Logger.getLogger(getClass());
	
	@Autowired
	private IBusinessService businessService;
	@Autowired
	private IConsumeService consumeService;
	//查询产品状态信息接口地址
	private String STATUS_INTERFACE = "http://localhost:8080/usercenter/test/status";
	//查询产品剩余使用时间接口地址
	private String TIME_INTERFACE = "http://localhost:8080/usercenter/test/remainTime";
	//注册产品接口地址
	private String REG_PRODUCT_INTERFACE = "http://localhost:8080/usercenter/test/regProduct";
	//申请商用接口地址
	private String FOR_COMMERCIAL_INTERFACE = "http://localhost:8080/usercenter/test/commercial";
	
	//申请商用地址,后面需要附加上产品id,例如:/business/commercial/{productId}
	private String COMMERCIAL_URL = "/business/commercial";
	//立即充值地址
	private String DEPOSIT_URL = "/purchase/gotoPurchase";
	//申请合同地址,后面还需要加上企业id和产品id,例如:/agreement/display/{entId}/{productId}
	private String AGREEMENT_URL = "/agreement/display";
	
	private Short productId = 1;
	
	public YLBProductHandler() {
		super();
	}

	public YLBProductHandler(Short productId) {
		super();
		this.productId = productId;
	}

	/**
	 * 获取剩余使用时间
	 * @return
	 * @throws HandlerException
	 */
	private Integer getRemainTime() throws HandlerException {
		String ret = null;
		Integer status = null;
		try {
			logger.info("进入YLBProductHandler.getRemainTime()");
			HttpClient client = HttpClientBuilder.create().build();
			HttpGet get = new HttpGet(TIME_INTERFACE);
			HttpResponse resp =client.execute(get);
			ret = EntityUtils.toString(resp.getEntity());
			JSONObject jo = JSONObject.parseObject(ret);
			status = jo.getInteger("time");
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		return status;
	}

	/**
	 * 获取产品状态信息
	 * @return
	 * @throws HandlerException
	 */
	private Integer getEntStatus() throws HandlerException {
		String ret = null;
		Integer status = null;
		try {
			logger.info("进入YLBProductHandler.getEntStatus()");
			HttpClient client = HttpClientBuilder.create().build();
			HttpGet get = new HttpGet(STATUS_INTERFACE);
			HttpResponse resp =client.execute(get);
			ret = EntityUtils.toString(resp.getEntity());
			JSONObject jo = JSONObject.parseObject(ret);
			status = jo.getInteger("status");
			//TODO实际上可能接口返回的状态码,需要解析判断一下
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		return status;
	}

	/**
	 * 注册产品
	 * @return
	 * @throws HandlerException
	 */
	private String registerProduct() throws HandlerException {
		String ret = null;
		try {
			logger.info("进入YLBProductHandler.registerProduct()");
			HttpClient client = HttpClientBuilder.create().build();
			HttpGet get = new HttpGet(REG_PRODUCT_INTERFACE);
			HttpResponse resp =client.execute(get);
			ret = EntityUtils.toString(resp.getEntity());
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		return ret;
	}

	/**
	 * 申请商用
	 */
	public String forCommercial() throws HandlerException {
		String ret = null;
		try {
			logger.info("进入YLBProductHandler.forCommercial()");
			HttpClient client = HttpClientBuilder.create().build();
			HttpGet get = new HttpGet(FOR_COMMERCIAL_INTERFACE);
			HttpResponse resp =client.execute(get);
			ret = EntityUtils.toString(resp.getEntity());
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		return ret;
	}

	/**
	 * 获取坐席数
	 * @return
	 * @throws HandlerException
	 */
	private Integer getAgentNum() throws HandlerException {
		logger.info("进入YLBProductHandler.getAgentNum()");
		return null;
	}

	/**
	 * 开通产品
	 */
	@Override
	public String openBusiness(UserInfo userInfo) throws HandlerException {
		try {
			logger.info("进入BusinessController.openBusiness()");
			logger.info("=======获取的用户信息:"+userInfo.toString());
			logger.info("得到产品id:"+productId);
			//调用注册接口
			String resp = registerProduct();
			JSONObject ret = JSONObject.parseObject(resp);
			if(StringUtils.hasText(ret.getString("ret"))&&ret.getString("ret").equals("00")){
				//成功
				logger.debug("企业["+userInfo.getEnterpriseId()+"]开通产品["+productId+"]成功,注册操作返回结果:"+ ret.toString());
				//增加user对应企业的产品关联表中的记录
				EnterpriseProductRela entProductRela = new EnterpriseProductRela();
				entProductRela.setEnterpriseId(userInfo.getEnterpriseId().toString());
				entProductRela.setProductId(productId);
				businessService.insertEnterpriseProductRela(entProductRela);
				//初始化一条消费 记录
				ConsumableStatistic record = new ConsumableStatistic();
				record.setEnterpriseId(userInfo.getEnterpriseId());
				record.setProductId(productId.intValue());
				record.setConsumableMoney(new BigDecimal(0));
				record.setConsumableResource(0l);
				consumeService.insertInitConsumableStatics(record);
				//返回给前端的结果信息
				JSONObject jo = new JSONObject();
				jo.put("ret", "00");
				jo.put("msg", "成功");
				return jo.toString();
			}else{
				//失败
				logger.debug("企业["+userInfo.getEnterpriseId()+"]开通产品["+productId+"]失败,注册操作返回结果:"+ ret.toString());
				JSONObject jo = new JSONObject();
				jo.put("ret", "-1");
				jo.put("msg", "失败");
				return jo.toString();
			}
		} catch (NumberFormatException e) {
			logger.error("注册产品时发生格式转换异常",e);
		} catch (HandlerException e) {
			logger.error("注册产品时调用远端接口异常",e);
		} catch (ServiceException e) {
			logger.error("保存记录异常",e);
			//TODO 这里实际上目前需要对远端接口进行回退
		} catch (Exception e){
			logger.error("注册产品时发生错误:"+e.getMessage(),e);
		}
		JSONObject jo = new JSONObject();
		jo.put("ret", "-1");
		jo.put("msg", "发生异常");
		return jo.toString();
	}

	/**
	 * 产品开通页初始化数据
	 */
	@Override
	public void initValue(EnterpriseProductAjax productRela) throws HandlerException {
		try {
			//当前产品的状态
			Integer curStatus = productRela.getStatus().getValue();
			//调用远端接口查询企业剩余使用时间
			Integer remainTime = getRemainTime();
			if(remainTime==null){
				throw new HandlerException("查询企业剩余时间失败");
			}
			productRela.setRemainCallTime(remainTime);
			logger.debug("查询到企业产品id["+productRela.getProductId()+"]剩余时间:"+remainTime);
			
			if(curStatus==ProductStatus.TRY.getValue()){
				//试用
				if(remainTime<=0){
					//剩余时间为0,试用结束
					curStatus = ProductStatus.TRY_OUT.getValue();
					//更新本地状态
					businessService.updateProductStatus(productRela.getId(), curStatus);
					productRela.setStatus(ProductStatus.TRY_OUT);
				}
				productRela.setCommercial(true);
			}else if(curStatus==ProductStatus.TRY_OUT.getValue()){
				productRela.setCommercial(true);
			}else if(curStatus==ProductStatus.COMMERCIAL.getValue()){
				//商用
				if(remainTime<=0){
					//剩余时间为0,商用暂停结束
					curStatus = ProductStatus.COMMERCIAL_PAUSE.getValue();
					//更新本地状态
					businessService.updateProductStatus(productRela.getId(), curStatus);
					productRela.setStatus(ProductStatus.COMMERCIAL_PAUSE);
				}
				productRela.setDeposit(true);
				productRela.setAgreement(true);
			}else if(curStatus==ProductStatus.COMMERCIAL_PAUSE.getValue()){
				//商用暂停
				if(remainTime>0){
					//充值了时间,恢复商用状态
					curStatus = ProductStatus.COMMERCIAL.getValue();
					//更新本地状态
					businessService.updateProductStatus(productRela.getId(), curStatus);
					productRela.setStatus(ProductStatus.COMMERCIAL);
				}
				productRela.setDeposit(true);
				productRela.setAgreement(true);
			}else if(curStatus==ProductStatus.PENDING_COMMERCIAL.getValue()){
				//申请商用
				//调用远端接口查询企业最新状态信息
				//TODO 调用接口,这里需要判断接口是否调用成功
				Integer remoteStatus = getEntStatus();
				if(remoteStatus==null){
					throw new RuntimeException("查询企业状态信息失败");
				}
				logger.info("调用远端接口查询到企业最新状态:"+remoteStatus);
				//如果远端状态为商用,则证明通过申请,更新本地状态
				if(remoteStatus==ProductStatus.COMMERCIAL.getValue()){
					businessService.updateProductStatus(productRela.getId(), remoteStatus);
					productRela.setStatus(ProductStatus.COMMERCIAL);
					productRela.setDeposit(true);
					productRela.setAgreement(true);
				}
			}
			//初始化申请商用地址
			productRela.setCommercialUrl(COMMERCIAL_URL+"/"+productRela.getProductId());
			//初始化立即充值地址
			productRela.setDepositUrl(DEPOSIT_URL);
			//初始化申请合同地址
			productRela.setAgreementUrl(AGREEMENT_URL+"/"+productRela.getProductId());
		} catch (Exception e) {
			throw new HandlerException("云联宝产品开通页初始化数据异常",e);
		}
	}

}
