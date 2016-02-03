package com.channelsoft.usercenter.common.exception;
/**
 * 
 * <dl>
 * <dt>HandlerException</dt>
 * <dd>Description:产品处理异常类</dd>
 * <dd>Copyright: Copyright (C) 2016</dd>
 * <dd>Company: 青牛（北京）技术有限公司</dd>
 * <dd>CreateDate: 2016年1月24日</dd>
 * </dl>
 * 
 * @author cy
 */
public class HandlerException extends RuntimeException {

	private static final long serialVersionUID = -4857002819389571330L;
	
	private int code;

	public HandlerException() {
		super();
	}

	public HandlerException(String message) {
		super(message);
	}

	public HandlerException(String message, Throwable cause) {
		super(message, cause);
	}

	public HandlerException(Throwable cause) {
		super(cause);
	}
	
	public HandlerException(int code, String message) {
		super(message);
		this.code = code;
	}

	public HandlerException(int code, String message, Throwable cause) {
		super(message, cause);
		this.code = code;
	}

	public HandlerException(int code, Throwable cause) {
		super(cause);
		this.code = code;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}
}