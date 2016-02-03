/**
 * 
 */
package com.channelsoft.usercenter.invoice.po.typeHandler;

import java.beans.PropertyEditorSupport;

import com.channelsoft.usercenter.invoice.po.status.InvoiceKindType;

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
public class InvoiceKindTypeEditor extends PropertyEditorSupport {

	@Override
	public String getAsText() {
		InvoiceKindType to = (InvoiceKindType)getValue();
		return String.valueOf(to.getValue());
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		InvoiceKindType to = InvoiceKindType.getItem(Integer.parseInt(text));
		setValue(to);
	}
	
	


}
