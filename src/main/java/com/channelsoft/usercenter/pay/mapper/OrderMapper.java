package com.channelsoft.usercenter.pay.mapper;

import org.springframework.dao.DataAccessException;
import com.channelsoft.usercenter.pay.po.Order;

public interface OrderMapper {
	public Order query(Order order) throws DataAccessException;
	public Integer add(Order order)throws DataAccessException;
	public Integer update(Order order)throws DataAccessException;
	public Integer delete(Order order)throws DataAccessException;
}