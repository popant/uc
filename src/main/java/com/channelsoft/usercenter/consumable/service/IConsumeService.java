package com.channelsoft.usercenter.consumable.service;

import java.math.BigDecimal;
import java.util.List;

import com.channelsoft.usercenter.consumable.po.ConsumableOrder;
import com.channelsoft.usercenter.consumable.po.ConsumableStatistic;

public interface IConsumeService {
	
	public List<ConsumableStatistic> getConsumableStatics(int entId) throws Exception;
	
	public List<ConsumableOrder> getConsumableOrders(int entId) throws Exception;
	
	public BigDecimal getSumConsumableOrders(int entId) throws Exception;
	/**
	 * 生成企业的初始化消费记录信息
	 * @param consumableStatics
	 * @return
	 * @throws Exception
	 */
	public Integer insertInitConsumableStatics(ConsumableStatistic consumableStatics) throws Exception;
}
