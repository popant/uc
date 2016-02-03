package com.channelsoft.usercenter.consumable.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.channelsoft.usercenter.common.controller.BaseController;
import com.channelsoft.usercenter.consumable.po.ConsumableFormPo;
import com.channelsoft.usercenter.consumable.po.Product;
import com.channelsoft.usercenter.consumable.service.IProductService;
import com.channelsoft.usercenter.consumable.service.IPurchaseService;


@Controller
@RequiresAuthentication
@RequestMapping("/purchase")
public class PurchaseController extends BaseController{
	
	private Logger logger = Logger.getLogger(getClass());
	
	@Autowired
	private IPurchaseService purchaseService;
	
	@Autowired
	private IProductService productService;
	
	/**
	 * 获取特定消费品
	 *
	 * String
	 * 张辰熇
	 * 2016年1月13日
	 */
	@RequestMapping("/getConsumables")
    public String getConsumables(HttpServletRequest request,HttpServletResponse response,int productId){
		logger.info("进入PurchaseController的getConsumables()方法...");
		try {
			request.setAttribute("consumables", purchaseService.queryConsumableByProductId(productId));
		} catch (Exception e) {
			logger.error("获取购买相关数据失败:" + e.getCause().getMessage());
			request.setAttribute("error", e.getCause().getMessage());
			return "consumable/consumableError";
		}
        return "consumable/purchase";
    }
	
	/**
	 * 跳转支付页面
	 *
	 * String
	 * 张辰熇
	 * 2016年1月13日
	 */
	@RequestMapping("/gotoPay")
	public String gotoPay(HttpServletRequest request,HttpServletResponse response,ConsumableFormPo consumableFormPo){
		logger.info("进入PurchaseController的gotoPay()方法...");
		int orderId = 0;
		try {
			consumableFormPo.setEntId(getUserInfo().getEnterpriseId());
			orderId = purchaseService.addOrder(consumableFormPo);
		} catch (Exception e) {
			logger.error("添加订单相关数据失败:" + e.getCause().getMessage());
			request.setAttribute("error", e.getCause().getMessage());
			return "consumable/consumableError";
		}
		return "redirect:/pay/payorder?orderId="+orderId; 
	}
	
	/**
	 * 获取产品列表
	 *
	 * String
	 * 张辰熇
	 * 2016年1月21日
	 */
	@RequestMapping("/getProducts")
	public String getProducts(HttpServletRequest request,HttpServletResponse response){
		logger.info("进入PurchaseController的getProducts()方法...");
		try {
			request.setAttribute("products", productService.getProductsByEntId(getUserInfo().getEnterpriseId()));
		} catch (Exception e) {
			logger.error("获取产品数据失败:" + e.getCause().getMessage());
			request.setAttribute("error", e.getCause().getMessage());
			return "consumable/consumableError";
		}
        return "consumable/left";
	}
	
	/**
	 * 跳转购买页面
	 *
	 * String
	 * 张辰熇
	 * 2016年1月21日
	 */
	@RequestMapping("/gotoFrame")
	public String gotoPurchase(HttpServletRequest request,HttpServletResponse response,Integer productId){
		try {
			List<Product> products = productService.getProductsByEntId(getUserInfo().getEnterpriseId());
			if(products.size() == 0){//没有产品
				
			}else{
				request.setAttribute("products", products);
				if(productId != null){
					request.setAttribute("consumables", purchaseService.queryConsumableByProductId(productId));
				}else{
					request.setAttribute("consumables", purchaseService.queryConsumableByProductId(products.get(0).getProductId()));
				}
				request.setAttribute("currentId", productId == null ? products.get(0).getProductId() : productId);
			}
		} catch (Exception e) {
			logger.error("获取产品数据失败:" + e.getCause().getMessage());
			request.setAttribute("error", e.getCause().getMessage());
			return "consumable/consumableError";
		}
		return "/consumable/left";
	}
}
