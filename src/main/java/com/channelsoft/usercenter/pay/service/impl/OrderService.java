package com.channelsoft.usercenter.pay.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.channelsoft.usercenter.common.exception.ServiceException;
import com.channelsoft.usercenter.pay.mapper.OrderMapper;
import com.channelsoft.usercenter.pay.po.Order;
import com.channelsoft.usercenter.pay.service.InterfaceOrderService;

@Service
public class OrderService implements InterfaceOrderService {

	@Autowired
	private OrderMapper mapper;

	@Override
	@Transactional
	public Order  getOrder(Order order) throws ServiceException {
		return mapper.query(order);
	}

	@Override
	public void addOrder(Order order) throws ServiceException {
		mapper.add(order);
	}

	@Override
	public void updateOrder(Order order) throws ServiceException {
		mapper.update(order);
	}

	@Override
	public void deleteOrder(Order order) throws ServiceException {
		 mapper.delete(order);

	}

}
