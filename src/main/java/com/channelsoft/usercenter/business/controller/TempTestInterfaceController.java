/**
 * 
 */
package com.channelsoft.usercenter.business.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.channelsoft.usercenter.business.po.status.ProductStatus;

/**
 * <dl>
 * <dt>TempTestInterfaceController</dt>
 * <dd>Description:TODO</dd>
 * <dd>Copyright: Copyright (C) 2016</dd>
 * <dd>Company: 青牛（北京）技术有限公司</dd>
 * <dd>CreateDate: 2016年1月14日</dd>
 * </dl>
 * 
 * @author cy
 */
@Controller
@RequestMapping(value="/test")
public class TempTestInterfaceController {
	
	@ResponseBody
	@RequestMapping(value="/status")
	public String getStatus(){
		JSONObject jo = new JSONObject();
		jo.put("status", ProductStatus.TRY.getValue());
		return jo.toString();
	}
	
	@ResponseBody
	@RequestMapping(value="/remainTime")
	public String getTime(){
		JSONObject jo = new JSONObject();
		jo.put("time", 100);
		return jo.toString();
	}
	
	@ResponseBody
	@RequestMapping(value="/regProduct")
	public String registerProduct(){
		JSONObject jo = new JSONObject();
		jo.put("ret", "00");
		jo.put("msg", "注册成功");
		return jo.toString();
	}
	
	@ResponseBody
	@RequestMapping(value="/commercial")
	public String forCommercial(){
		JSONObject jo = new JSONObject();
		jo.put("ret", "00");
		jo.put("msg", "申请成功");
		return jo.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(" ".isEmpty());
	}

}
