package com.channelsoft.usercenter.mailaddress.mapper;

import com.channelsoft.usercenter.mailaddress.po.MailAddress;
import org.springframework.dao.DataAccessException;

import java.util.List;

/**
 * 寄送地址信息管理
 *
 */
public interface MailAddressMapper {
	public List<MailAddress> query(MailAddress mailAddress) throws DataAccessException;
	public Integer add(MailAddress mailAddress)throws DataAccessException;
	public Integer update(MailAddress mailAddress)throws DataAccessException;
	public Integer delete(MailAddress mailAddress)throws DataAccessException;
	public List<String> selectInvoiceAddress(Integer entId)throws DataAccessException;
}
