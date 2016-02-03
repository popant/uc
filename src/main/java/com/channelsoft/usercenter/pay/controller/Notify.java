package com.channelsoft.usercenter.pay.controller;

import java.io.Writer;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.channelsoft.usercenter.account.po.Email;
import com.channelsoft.usercenter.account.util.SendEmailUtil;
import com.channelsoft.usercenter.common.controller.BaseController;
import com.channelsoft.usercenter.consumable.po.ConsumableStatistic;
import com.channelsoft.usercenter.consumable.service.IPurchaseService;
import com.channelsoft.usercenter.pay.po.Order;
import com.channelsoft.usercenter.pay.service.InterfaceOrderService;
import com.channelsoft.usercenter.pay.util.AlipayNotify;
import com.channelsoft.usercenter.pay.util.AlipayUtil;

@Controller
@RequestMapping("/notify")
public class Notify extends BaseController {
	@Value("${email.host}")
	private String host; // 服务器地址
	@Value("${email.sender}")
	private  String sender; // 发件人的邮箱
	@Value("${email.name}")
	private  String name; // 发件人昵称
	@Value("${email.username}")
	private  String username; // 账号
	@Value("${email.password}")
	private  String password; // 密码
	@Value("${email.subject}")
	private  String subject; // 主题
	@Value("${email.receiver}")
	private  String receiver;
	@Autowired
	private InterfaceOrderService orderService;

	@Autowired
	private IPurchaseService purchaseService;

	/**
	 * 处理支付宝异步通知 通知频率 5s,2m,10m,15m,1h,2h,6h,15h
	 * 
	 * @throws Exception
	 */
	@RequestMapping("/asyncnotify")
	public void alipayAsyncNotify(HttpServletRequest request, Writer out) {
		// 获取支付宝POST过来反馈信息
		Map<String, String> params = AlipayUtil.getParams(request, false);
		String total_fee = params.get("total_fee");
		String out_trade_no = params.get("out_trade_no");
		String trade_status = params.get("trade_status");
		String notifyTime = params.get("notify_time");

		if (AlipayNotify.verify(params)) {// 验证成功

			if (trade_status.equals("TRADE_SUCCESS")) {// 付款成功通知

				Order order = new Order();
				order.setOrder_id(Integer.parseInt(out_trade_no));
				order = orderService.getOrder(order);

				if (total_fee.equals(String.valueOf(order.getTotle_price()))) {

					order.setOrder_status(Short.valueOf("2"));// 更新订单状态为已支付
					Date temp=null;
					try {
						temp = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss")
								.parse(notifyTime);
						Timestamp payTime = new Timestamp(temp.getTime());
						order.setPay_time(payTime);// 更新支付时间
						orderService.updateOrder(order);
					} catch (ParseException e) {
						// 时间格式化异常不可能出现。。。
						e.printStackTrace();
					} catch (Exception e) {
						logger.error("数据库连接异常....");
						e.printStackTrace();
						sendMail("您好，数据库异常，请及时处理。订单：" + out_trade_no
								+ " 已支付,状态未改变！");
						AlipayUtil.write(out, "fail");
						return;
					}
					
					ConsumableStatistic statistic = new ConsumableStatistic();// 增加统计记录
					statistic.setEnterpriseId(order.getEnterprise_id());
					statistic.setConsumableMoney(BigDecimal.valueOf(order
							.getTotle_price()));
					statistic.setProductId(order.getProduct_id());
					statistic.setConsumableResource(order.getTotal_resource());
					
					try {
						purchaseService.addConsume(statistic);
					} catch (Exception e) {
						logger.error("数据库连接异常....");
						e.printStackTrace();
						sendMail("您好，数据库异常，请及时处理。订单：" + out_trade_no
								+ " 已支付,未能增加统计！");
						AlipayUtil.write(out, "fail");
						return;
					}
					AlipayUtil.write(out, "success");// 通知支付宝成功处理，不需要再次通知
				}

			}
		} else {// 验证失败
			AlipayUtil.write(out, "fail");
		}
	}

	/**
	 * 处理同步通知
	 */
	@RequestMapping("/syncnotify")
	public String alipaySyncNotify(HttpServletRequest request, Writer out) {
		// 获取支付宝GET过来反馈信息
		Map<String, String> params = AlipayUtil.getParams(request, true);

		String trade_status = params.get("trade_status");
		String out_trade_no = params.get("out_trade_no");
		String total_fee = params.get("total_fee");
		String body = params.get("body");
		// 检测是否支付宝官方通知
		boolean verify_result = AlipayNotify.verify(params);

		if (verify_result && trade_status.equals("TRADE_SUCCESS")) {// 验证成功
			request.setAttribute("out_trade_no", out_trade_no);
			request.setAttribute("total_fee", total_fee);
			request.setAttribute("body", body);

			return "/pay/paysuccess";
		} else {
			return "/pay/payfail";
		}
	}

	public void sendMail(String msg) {
		logger.info("发送邮件...内容为:"+msg);
		Email email = new Email();
		email.setHost(host);
		email.setSender(sender);
		email.setReceiver(receiver);
		email.setName(name);
		email.setUsername(username);
		email.setPassword(password);
		email.setSubject(subject);
		email.setMessage(msg);
		new SendEmailUtil().send(email);
	}
}
