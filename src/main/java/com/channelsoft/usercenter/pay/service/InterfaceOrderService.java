package com.channelsoft.usercenter.pay.service;

import java.util.List;
import com.channelsoft.usercenter.common.exception.ServiceException;
import com.channelsoft.usercenter.pay.po.Order;

/**
 * <dl>
 * <dd>Description:</dd>
 * <dd>Copyright: Copyright (C) 2006</dd>
 * <dd>Company: 青牛（北京）技术有限公司</dd>
 * <dd>CreateDate: 2016年1月15日</dd>
 * </dl>
 *
 * @author 贾学雷
 */
public interface InterfaceOrderService {
    public Order getOrder(Order order) throws ServiceException;

    public void addOrder(Order order) throws ServiceException;

    public void updateOrder(Order order) throws ServiceException;

    public void deleteOrder(Order order) throws ServiceException;
}
