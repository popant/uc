package com.channelsoft.usercenter.pay.config;

public class AlipayConfig {
	
	// 合作身份者ID，以2088开头由16位纯数字组成的字符串
	public static String partner = "2088711910222544";
	
	// 收款支付宝账号，一般情况下收款账号就是签约账号
	public static String seller_email = "ccod@channelsoft.com";
	// 商户的私钥
	public static String key = "ouy8xyhtqx9ep9piclijwa6qipppx23x";

	public static String notify_url = "http://t01.cephchina.com/usercenter/notify/asyncnotify";

	//页面跳转同步通知页面路径
	public static String return_url = "http://t01.cephchina.com/usercenter/notify/syncnotify";
	
	//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑
	

	// 调试用，创建TXT日志文件夹路径
	public static String log_path = "D:\\";

	// 字符编码格式 目前支持 gbk 或 utf-8
	public static String input_charset = "utf-8";
	
	// 签名方式 不需修改
	public static String sign_type = "MD5";

}
