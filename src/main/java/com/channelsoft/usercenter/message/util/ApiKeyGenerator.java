/**
 * 
 */
package com.channelsoft.usercenter.message.util;

import java.util.Random;

import org.springframework.util.StringUtils;

import com.channelsoft.usercenter.pay.util.MD5;

/**
 * <dl>
 * <dt>ApiKeyGenerator</dt>
 * <dd>Description:TODO</dd>
 * <dd>Copyright: Copyright (C) 2016</dd>
 * <dd>Company: 青牛（北京）技术有限公司</dd>
 * <dd>CreateDate: 2016年1月22日</dd>
 * </dl>
 * 
 * @author cy
 */
public class ApiKeyGenerator {
	
	public static String generateApiKey(String phoneNum, String secretKey, String charset){
		if(StringUtils.hasText(charset)){
			charset = "UTF-8";
		}
		return MD5.sign(phoneNum, secretKey, charset);
	}
	
	public static String generateSecretKey(Integer length){
		String base = "abcdefghijklmnopqrstuvwxyz0123456789";   
		Random random = new Random();   
		StringBuffer sb = new StringBuffer();   
		for (int i = 0; i < length; i++) {   
		   int number = random.nextInt(base.length());   
		   sb.append(base.charAt(number));   
		}   
		return sb.toString();  
	}

}
