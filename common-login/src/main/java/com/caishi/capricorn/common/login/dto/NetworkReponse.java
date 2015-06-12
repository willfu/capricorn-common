package com.caishi.capricorn.common.login.dto;

import java.io.UnsupportedEncodingException;

/**
 * �ͻ��˷������󷵻ؽṹ
 */
public class NetworkReponse<T> {
	
	private final String defaultMessage = "���������������Ǿ��������";
	
	/**
	 * ����������״̬����
	 */
	private String code = "10000";
	
	/**
	 * ��ȡ����������״̬����
	 * @return ����������״̬����
	 */
	public String getCode() {
		return code;
	}

	/**
	 * ���ò���������״̬����
	 * @param code ����������״̬����
	 */
	public void setCode(String code) {
		this.code = code;
	}
	
	/**
	 * ���������ý������
	 */
	private T data;
	

	/**
	 * ��ȡ���������ý������
	 * @return ���������ý������
	 */
	public T getData() {
		return data;
	}

	/**
	 * ���ò��������ý������
	 * @param data ���������ý������
	 */
	public void setData(T data) {
		this.data = data;
	}
	
	/**
	 * ��Ϣ����
	 * @see �ɹ���ʾ��������Ϣ
	 */
	private String message;
	
	/**
	 * ��ȡ��Ϣ����
	 * @return ��Ϣ����
	 * @throws UnsupportedEncodingException 
	 */
	public String getMessage() throws UnsupportedEncodingException {
		if(message==null){
			byte[] buffer = defaultMessage.getBytes("ISO-8859-1");
			message = new String(buffer,"UTF-8");
		}
		return message;
	}

	/**
	 * ������Ϣ����
	 * @param message ��Ϣ����
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	
	/**
	 * ������Ϣ
	 */
	private Object attached;

	/**
	 * ��ȡ������Ϣ
	 * @return ������Ϣ
	 */
	public Object getAttached() {
		return attached;
	}

	/**
	 * ���ø�����Ϣ
	 * @param attached ������Ϣ
	 */
	public void setAttached(Object attached) {
		this.attached = attached;
	}
}
