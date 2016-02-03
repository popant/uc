package com.channelsoft.usercenter.consumable.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.channelsoft.usercenter.common.controller.BaseController;
import com.channelsoft.usercenter.consumable.service.IConsumeService;
import com.channelsoft.usercenter.consumable.service.IProductService;
import com.channelsoft.usercenter.consumable.service.IPurchaseService;


@Controller
@RequiresAuthentication
@RequestMapping("/consume")
public class ConsumeController extends BaseController{
	
	private Logger logger = Logger.getLogger(getClass());
	
	@Autowired
	private IPurchaseService purchaseService;
	
	@Autowired
	private IProductService productService;
	
	@Autowired
	private IConsumeService consumeService;
	
	
	/**
	 * 前往消费统计页面
	 *
	 * String
	 * 张辰熇
	 * 2016年1月18日
	 */
	@RequestMapping("/gotoStatics")
	public String gotoStatics(HttpServletRequest request,HttpServletResponse response){
		logger.info("进入ConsumeController的gotoStatics()方法...");
		try {
			request.setAttribute("statics", purchaseService.getConsumableStatics(getUserInfo().getEnterpriseId()));
			request.setAttribute("products", productService.getProductsByEntId(getUserInfo().getEnterpriseId()));
		} catch (Exception e) {
			logger.error("获取消费统计相关数据失败:" + e.getCause().getMessage());
			request.setAttribute("error", e.getCause().getMessage());
			return "consumable/consumableError";
		}
        return "consumable/statics";
    }
	
	/**
	 * 消费统计明细
	 *
	 * String
	 * 张辰熇
	 * 2016年1月20日
	 */
	@RequestMapping("/gotoStaticsDetail")
	public String gotoConsumeDetail(HttpServletRequest request,HttpServletResponse response){
		logger.info("进入ConsumeController的gotoConsumeDetail()方法...");
		try {
			request.setAttribute("staticsDetails", consumeService.getConsumableOrders(getUserInfo().getEnterpriseId()));
			request.setAttribute("statics", purchaseService.getConsumableStatics(getUserInfo().getEnterpriseId()));
			request.setAttribute("products", productService.getProductsByEntId(getUserInfo().getEnterpriseId()));
		} catch (Exception e) {
			logger.error("获取消费明细相关数据失败:" + e.getCause().getMessage());
			request.setAttribute("error", e.getCause().getMessage());
			return "consumable/consumableError";
		}
		return "consumable/staticsDetail";
	}
	
	
	@RequestMapping("/gotoMetronic")
	public String gotoMetronic(HttpServletRequest request,HttpServletResponse response){
		return "/zchShow";
	}
}
