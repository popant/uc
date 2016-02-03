package com.channelsoft.usercenter.consumable.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.channelsoft.usercenter.consumable.mapper.ConsumableOrderMapper;

public class DeleteOrderService {
	
	private Logger logger = Logger.getLogger(getClass());
	
	@Autowired
	private ConsumableOrderMapper consumableOrderMapper;
	
	/**
	 * 删除超时的订单  订单状态为未支付,且创建时间距今超过30分钟
	 *
	 * void
	 * 张辰熇
	 * 2016年1月14日
	 */
	public void deleteOrderOutTime(){
		logger.info("开始删除逾期未支付的订单数据...");
		try {
			consumableOrderMapper.deleteOrderOutTime();
		} catch (Exception e) {
			logger.error("逾期订单删除失败:" + e.getCause().getMessage());
		}
	}
		
}
