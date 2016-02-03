/**
 * 
 */
package com.channelsoft.usercenter.invoice.po.typeHandler;

import org.springframework.core.convert.converter.Converter;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

/**
 * <dl>
 * <dt>InvoiceKindType</dt>
 * <dd>Copyright: Copyright (C) 2016</dd>
 * <dd>Company: 青牛（北京）技术有限公司</dd>
 * <dd>CreateDate: 2016年1月19日</dd>
 * </dl>
 * 
 * @author cy
 */
public class MultipartFileToByteArrayEditor implements  Converter<CommonsMultipartFile,byte[]> {

	/* (non-Javadoc)
	 * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
	 */
	@Override
	public byte[] convert(CommonsMultipartFile source) {
		return source.getBytes();
	}

	
	

}
