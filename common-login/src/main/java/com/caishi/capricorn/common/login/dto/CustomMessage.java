package com.caishi.capricorn.common.login.dto;

/**
 * 业务逻辑异常
 */
public class CustomMessage extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	public CustomMessage(String code,Object data){
		super();
		this.setCode(code);
		this.setData(data);
	}
	
	public CustomMessage(String code,Object data,String message){
		super(message);
		this.setCode(code);
		this.setData(data);
	}
	
	/**
	 * 异常编码
	 */
	private String code;
	
	/**
	 * 获取异常编码
	 * @return 异常编码
	 */
	public String getCode() {
		return code;
	}

	/**
	 * 设置异常编码
	 * @param code 异常编码
	 */
	public void setCode(String code) {
		this.code = code;
	}
	
	/**
	 * 异常结果
	 */
	private Object data;

	/**
	 * 获取异常结果
	 * @return 异常结果
	 */
	public Object getData() {
		return data;
	}

	/**
	 * 设置异常结果
	 * @param data 异常结果
	 */
	public void setData(Object data) {
		this.data = data;
	}
}
