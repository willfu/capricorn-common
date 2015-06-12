package com.caishi.capricorn.common.login.dto;

/**
 * ҵ���߼��쳣
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
	 * �쳣����
	 */
	private String code;
	
	/**
	 * ��ȡ�쳣����
	 * @return �쳣����
	 */
	public String getCode() {
		return code;
	}

	/**
	 * �����쳣����
	 * @param code �쳣����
	 */
	public void setCode(String code) {
		this.code = code;
	}
	
	/**
	 * �쳣���
	 */
	private Object data;

	/**
	 * ��ȡ�쳣���
	 * @return �쳣���
	 */
	public Object getData() {
		return data;
	}

	/**
	 * �����쳣���
	 * @param data �쳣���
	 */
	public void setData(Object data) {
		this.data = data;
	}
}
