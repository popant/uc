package com.channelsoft.usercenter.common.exception;

public class ConsumableException extends RuntimeException {

	
	private static final long serialVersionUID = -497353080526583254L;
	
	
	private int code;

	public ConsumableException() {
		super();
	}

	public ConsumableException(String message) {
		super(message);
	}

	public ConsumableException(String message, Throwable cause) {
		super(message, cause);
	}

	public ConsumableException(Throwable cause) {
		super(cause);
	}
	
	public ConsumableException(int code, String message) {
		super(message);
		this.code = code;
	}

	public ConsumableException(int code, String message, Throwable cause) {
		super(message, cause);
		this.code = code;
	}

	public ConsumableException(int code, Throwable cause) {
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