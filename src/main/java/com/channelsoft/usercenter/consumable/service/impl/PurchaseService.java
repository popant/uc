package com.channelsoft.usercenter.consumable.service.impl;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.channelsoft.usercenter.consumable.mapper.ConsumableMapper;
import com.channelsoft.usercenter.consumable.mapper.ConsumableOrderMapper;
import com.channelsoft.usercenter.consumable.mapper.ConsumableStatisticMapper;
import com.channelsoft.usercenter.consumable.mapper.ConsumableSubOrderMapper;
import com.channelsoft.usercenter.consumable.mapper.EnterpriseProductRelaMapper;
import com.channelsoft.usercenter.consumable.po.Consumable;
import com.channelsoft.usercenter.consumable.po.ConsumableFormPo;
import com.channelsoft.usercenter.consumable.po.ConsumableOrder;
import com.channelsoft.usercenter.consumable.po.ConsumableStatistic;
import com.channelsoft.usercenter.consumable.po.ConsumableSubOrder;
import com.channelsoft.usercenter.consumable.po.EnterpriseProductRela;
import com.channelsoft.usercenter.consumable.service.IPurchaseService;

@Service
public class PurchaseService implements IPurchaseService{
	
	private Logger logger = Logger.getLogger(getClass());
	
	@Autowired
	private ConsumableMapper consumableMapper;
	
	@Autowired
	private ConsumableOrderMapper consumableOrderMapper;
	
	@Autowired
	private ConsumableSubOrderMapper consumableSubOrderMapper;
	
	@Autowired
	private ConsumableStatisticMapper consumableStatisticMapper;
	
	@Autowired
	private EnterpriseProductRelaMapper enterpriseProductMapper;
	/**
	 * 根据当前企业查询开通产品下的消费品
	 *
	 * List<Consumable>
	 * 张辰熇
	 * 2016年1月12日
	 */
	public List<Consumable> queryConsumableByProductId(int productId) throws Exception{
		logger.info("进入PurchaseService的queryConsumableByEntId()方法...");
		List<Consumable> result = null;
		result = consumableMapper.queryConsumables(productId);
		return result;
	}
	
	/**
	 * 添加订单及统计数据
	 *
	 * void
	 * 张辰熇
	 * 2016年1月13日
	 */
	@Transactional
	public int addOrder(ConsumableFormPo consumableFormPo)throws Exception{
		logger.info("进入PurchaseService的addOrder()方法...");
		ConsumableSubOrder consumableSubOrder;
		ConsumableOrder consumableOrder;
		int orderId = 0;
		consumableSubOrder = new ConsumableSubOrder();
		
		BigDecimal consumePrice = new BigDecimal(consumableFormPo.getConsumablePrice());
		BigDecimal totalPrice = consumePrice.multiply(new BigDecimal(consumableFormPo.getConsumableNumber()));
		consumableSubOrder.setTotalPrice(totalPrice);
		
		//插入订单数据
		consumableOrder = new ConsumableOrder();
		consumableOrder.setProductId(Integer.parseInt(consumableFormPo.getProductId()));
		consumableOrder.setTotlePrice(totalPrice);
		BigDecimal resources = new BigDecimal(consumableFormPo.getConsumableResource()).multiply(new BigDecimal(consumableFormPo.getConsumableNumber()));
		consumableOrder.setTotalResource(resources.longValue());
		consumableOrder.setOrderStatus((short)0);
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		consumableOrder.setCreateTime(format.parse(format.format(new Date())));
		consumableOrder.setEnterpriseId(consumableFormPo.getEntId());
		consumableOrderMapper.insertSelective(consumableOrder);
		
		//获取刚刚插入的主键
		orderId = consumableOrderMapper.getInsertPK();
		
		//插入子订单数据
		consumableSubOrder.setProductId(Short.parseShort(consumableFormPo.getProductId()));
		consumableSubOrder.setConsumableId(Integer.parseInt(consumableFormPo.getConsumableId()));
		consumableSubOrder.setConsumableName(consumableFormPo.getConsumableName());
		consumableSubOrder.setConsumableNumber(Integer.parseInt(consumableFormPo.getConsumableNumber()));
		consumableSubOrder.setConsumablePrice(new BigDecimal(consumableFormPo.getConsumablePrice()));
		consumableSubOrder.setTotalPrice(totalPrice);
		consumableSubOrder.setOrderId(orderId);
		consumableSubOrder.setEnterpriseId(1);
		consumableSubOrderMapper.insert(consumableSubOrder);
		return orderId;
	}
	
	
	/**
	 * 增加消费总金额
	 *
	 * void
	 * 张辰熇
	 * 2016年1月13日
	 */
	public synchronized void addConsume(ConsumableStatistic consumableStatistic)throws Exception{
		logger.info("进入PurchaseService的addConsume()方法...");
		consumableStatisticMapper.addConsumable(consumableStatistic);
	}
	
	
	/**
	 * 获得消费统计数据
	 *
	 * List<ConsumableStatistic>
	 * 张辰熇
	 * 2016年1月18日
	 */
	public List<ConsumableStatistic> getConsumableStatics(int entId) throws Exception{
		logger.info("进入PurchaseService的getConsumableStatics()方法...");
		List<ConsumableStatistic> result = null;
		result = consumableStatisticMapper.getConsumableStatics(entId);
		return result;
	}
	
	/***
	 * 判断该产品是否已开通
	 *
	 * boolean
	 * 张辰熇
	 * 2016年2月1日
	 */
	public boolean validProduct(int entId,int productId)throws Exception{
		logger.info("进入PurchaseService的validProduct()方法...");
		
		EnterpriseProductRela param = new EnterpriseProductRela();
		param.setEnterpriseId(entId+"");
		param.setProductId((short)productId);
		
		if(enterpriseProductMapper.validProduct(param) == null){
			return false;
		}else{
			return true;
		}
	}
}
