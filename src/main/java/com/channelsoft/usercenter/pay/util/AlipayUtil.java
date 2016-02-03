package com.channelsoft.usercenter.pay.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.channelsoft.usercenter.pay.config.AlipayConfig;

public class AlipayUtil {
	/**
	 * 同步通知需要转码
	 */
	public static Map<String, String> getParams(HttpServletRequest request,
			boolean isISO_8859_1) {

		Map<String, String> params = new HashMap<String, String>();
		Map requestParams = request.getParameterMap();
		for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext();) {
			String name = (String) iter.next();
			String[] values = (String[]) requestParams.get(name);
			String valueStr = "";
			for (int i = 0; i < values.length; i++) {
				valueStr = (i == values.length - 1) ? valueStr + values[i]
						: valueStr + values[i] + ",";
			}

			if (isISO_8859_1) {
				try {
					valueStr = new String(valueStr.getBytes("ISO-8859-1"),
							"utf-8");
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}

			params.put(name, valueStr);
		}
		System.out.println(params);
		return params;
	}

	/**
	 * 创建提交表单自动提交
	 * 
	 * @param params
	 * @param resp
	 */
	public static void buildForm(Map<String, String> params,
			HttpServletResponse resp) {
		// 支付类型
		String payment_type = "1";
		String out_trade_no = params.get("orderId");
		// 订单名称
		String subject = null;
		subject = params.get("subject");
		System.out.println(subject);
		String total_fee = params.get("totalFee");
		String body = params.get("body");
		// 防钓鱼时间戳
		String anti_phishing_key = "";
		// 若要使用请调用类文件submit中的query_timestamp函数
		// 客户端的IP地址
		String exter_invoke_ip = "";
		// 把请求参数打包成数组
		Map<String, String> sParaTemp = new HashMap<String, String>();
		sParaTemp.put("service", "create_direct_pay_by_user");
		sParaTemp.put("partner", AlipayConfig.partner);
		sParaTemp.put("seller_email", AlipayConfig.seller_email);
		sParaTemp.put("_input_charset", AlipayConfig.input_charset);
		sParaTemp.put("payment_type", payment_type);
		sParaTemp.put("notify_url", AlipayConfig.notify_url);
		sParaTemp.put("return_url", AlipayConfig.return_url);
		sParaTemp.put("out_trade_no", out_trade_no);
		sParaTemp.put("subject", subject);
		sParaTemp.put("total_fee", total_fee);
		sParaTemp.put("body", body);
		sParaTemp.put("anti_phishing_key", anti_phishing_key);
		sParaTemp.put("exter_invoke_ip", exter_invoke_ip);
		// 建立请求
		String sHtmlText = AlipaySubmit.buildRequest(sParaTemp, "post", "确认");
		String headHtml = "<html><head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\"><title>支付宝即时到账交易接口</title></head>";
		String tailHtml = "<body></body></html>";
		try {
			resp.setCharacterEncoding("utf-8");
			resp.getWriter().write(headHtml + sHtmlText + tailHtml);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 
	 */
	public static void write(Writer out, String msg) {

		try {
			out.write(msg);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
