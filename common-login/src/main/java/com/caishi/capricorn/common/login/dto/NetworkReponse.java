package com.caishi.capricorn.common.login.dto;

/**
 * 客户端访问请求返回结构
 */
public class NetworkReponse<T> {
	
	/**
	 * 操作请求处置状态编码
	 */
	private String code = "10000";
	
	/**
	 * 获取操作请求处置状态编码
	 * @return 操作请求处置状态编码
	 */
	public String getCode() {
		return code;
	}

	/**
	 * 设置操作请求处置状态编码
	 * @param code 操作请求处置状态编码
	 */
	public void setCode(String code) {
		this.code = code;
	}
	
	/**
	 * 操作请求处置结果对象
	 */
	private T data;
	

	/**
	 * 获取操作请求处置结果对象
	 * @return 操作请求处置结果对象
	 */
	public T getData() {
		return data;
	}

	/**
	 * 设置操作请求处置结果对象
	 * @param data 操作请求处置结果对象
	 */
	public void setData(T data) {
		this.data = data;
	}
	
	/**
	 * 消息内容
	 * @see 成功提示，错误信息
	 */
	private String message = "请求正常，让我们尽情的玩耍吧";
	
	/**
	 * 获取消息内容
	 * @return 消息内容
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * 设置消息内容
	 * @param message 消息内容
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	
	/**
	 * 附加信息
	 */
	private Object attached;

	/**
	 * 获取附加信息
	 * @return 附加信息
	 */
	public Object getAttached() {
		return attached;
	}

	/**
	 * 设置附加信息
	 * @param attached 附加信息
	 */
	public void setAttached(Object attached) {
		this.attached = attached;
	}
}
