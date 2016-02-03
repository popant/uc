package com.channelsoft.usercenter.consumable.service;

import java.util.List;

import com.channelsoft.usercenter.consumable.po.Consumable;
import com.channelsoft.usercenter.consumable.po.ConsumableFormPo;
import com.channelsoft.usercenter.consumable.po.ConsumableStatistic;

public interface IPurchaseService {
	
	public List<Consumable> queryConsumableByProductId(int productId) throws Exception;
	
	public int addOrder(ConsumableFormPo consumableFormPo) throws Exception;
	
	public List<ConsumableStatistic> getConsumableStatics(int entId) throws Exception;

	public void addConsume(ConsumableStatistic consumableStatistic)throws Exception;

	public boolean validProduct(int entId,int productId)throws Exception;
}
