package com.channelsoft.usercenter.consumable.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.channelsoft.usercenter.consumable.mapper.ConsumableOrderMapper;
import com.channelsoft.usercenter.consumable.mapper.ConsumableStatisticMapper;
import com.channelsoft.usercenter.consumable.po.ConsumableOrder;
import com.channelsoft.usercenter.consumable.po.ConsumableOrderExample;
import com.channelsoft.usercenter.consumable.po.ConsumableStatistic;
import com.channelsoft.usercenter.consumable.po.ConsumableStatisticExample;
import com.channelsoft.usercenter.consumable.service.IConsumeService;

@Service
public class ConsumableService implements IConsumeService{
	
	private Logger logger = Logger.getLogger(getClass());
	
	@Autowired
	private ConsumableStatisticMapper consumableStatisticMapper;
	
	@Autowired
	private ConsumableOrderMapper consumableOrderMapper;
	
	/**
	 * 获得消费统计的数据
	 */
	public List<ConsumableStatistic> getConsumableStatics(int entId) throws Exception{
		logger.info("进入ConsumableService的getConsumableStatics()方法...");
		
		ConsumableStatisticExample consumableStatisticExample = new ConsumableStatisticExample();
		consumableStatisticExample.createCriteria().andEnterpriseIdEqualTo(entId);
		
		return consumableStatisticMapper.selectByExample(consumableStatisticExample);
	}
	
	/**
	 * 获取消费订单列表
	 *
	 * List<ConsumableOrder>
	 * 张辰熇
	 * 2016年1月19日
	 */
	public List<ConsumableOrder> getConsumableOrders(int entId)throws Exception{
		logger.info("进入ConsumableService的getConsumableOrders()方法...");
		List<ConsumableOrder> result = null;
		
		ConsumableOrderExample consumableOrderExample = new ConsumableOrderExample();
		consumableOrderExample.createCriteria().andEnterpriseIdEqualTo(entId).andOrderStatusEqualTo((short)2);
		result = consumableOrderMapper.selectByExample(consumableOrderExample);
		
		return result;
	}

	/* (non-Javadoc)
	 * @see com.channelsoft.usercenter.consumable.service.IConsumeService#getSumConsumableOrders(int)
	 */
	@Override
	public BigDecimal getSumConsumableOrders(int entId) throws Exception {
		return consumableStatisticMapper.getSumConsumableStatics(entId);
	}

	/* (non-Javadoc)
	 * @see com.channelsoft.usercenter.consumable.service.IConsumeService#insertInitConsumableStatics(com.channelsoft.usercenter.consumable.po.ConsumableStatistic)
	 */
	@Override
	public Integer insertInitConsumableStatics(
			ConsumableStatistic consumableStatics) throws Exception {
		return consumableStatisticMapper.insertSelective(consumableStatics);
	}

}
