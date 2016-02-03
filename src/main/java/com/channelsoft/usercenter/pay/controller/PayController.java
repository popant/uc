package com.channelsoft.usercenter.pay.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.channelsoft.usercenter.common.controller.BaseController;
import com.channelsoft.usercenter.pay.po.Order;
import com.channelsoft.usercenter.pay.service.InterfaceOrderService;
import com.channelsoft.usercenter.pay.util.AlipayUtil;

/**
 * <dl>
 * <dd>Description:</dd>
 * <dd>Copyright: Copyright (C) 2006</dd>
 * <dd>Company: 青牛（北京）技术有限公司</dd>
 * <dd>CreateDate: 2016年01月10日</dd>
 * </dl>
 * @author 贾学雷
 */
@Controller
@RequestMapping("/pay")
public class PayController extends BaseController {
	@Autowired
	private InterfaceOrderService orderService;

	/**
	 * 支付订单页 , method = RequestMethod.POST
	 */
	@RequiresAuthentication
	@RequestMapping(value = "/payorder", params = { "orderId" })
	public String payOrder(HttpServletRequest request,
			@RequestParam(value = "orderId") String orderId) {

		if (orderId.equals("")) {
			return "error";
		}
		Order order = new Order();
		try {
			order.setOrder_id(Integer.parseInt(orderId));
		} catch (NumberFormatException e) {
			e.printStackTrace();
			return "error";
		}

		order = orderService.getOrder(order);
		if (order == null) {
			return "error";
		}
		request.setAttribute("order", order);

		return "pay/orderlist";
	}

	@RequestMapping("/table")
public String test(){
	return "pay/table";
}
	/**
	 * 构造支付参数，跳转去支付
	 */
	@RequiresAuthentication
	@RequestMapping(value = "/topay")
	public void payteset(HttpServletResponse  resp,
			@RequestParam(value = "orderId") String orderId,
			@RequestParam(value = "totalFee") String totalFee) {

		if (orderId.equals("") || totalFee.equals("")) {
		}
		Map<String, String> params = new HashMap<String, String>();
		params.put("orderId", orderId);
		params.put("totalFee", totalFee);
		params.put("subject", "测试");
		params.put("body", "青牛服务商品");

		AlipayUtil.buildForm(params, resp);
	}
}
