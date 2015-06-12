package com.caishi.capricorn.common.login.data;


/**
 * 第三方账号类型枚举类
 *	@see 第三方账户包括：腾讯QQ（QQ），微信（WebChat），新浪微博（SinaBlog），豆瓣（DouBan）及未知类型（UnKnown）
 */
public enum PartnerType {
	/**
	 * 腾讯QQ
	 */
	QQ,
	
	/**
	 * 腾讯微信
	 */
	WebChat,
	
	/**
	 * 新浪微博
	 */
	WeiBo,
	
	/**
	 * 豆瓣
	 */
	DouBan,
	
	/**
	 * 未知账户
	 */
	Unknown;
	
	/**
	 * 获取第三方账户类型标识码
	 * @param type 第三方账户类型标枚举对象
	 * @return 第三方账户类型标识码
	 */
	public static final String getValue(PartnerType obj){
		String val = "00";
		switch (obj) {
			case QQ:
			{
				val = "01";
				break;
			}
			case WebChat:
			{
				val = "02";
				break;
			}
			case WeiBo:{
				val = "03";
				break;
			}
			case DouBan:{
				val="04";
				break;
			}
			case Unknown:
			{
				val = "00";
				break;
			}
			default:
			{
				val = "00";
				break;
			}
		}
		return val;
	}
	
	/**
	 * 根据第三方账户类型标识码获取第三方账户类型标枚举对象
	 * @param val 第三方账户类型标识码
	 * @return 第三方账户类型标枚举对象
	 */
	public static final PartnerType getEnum(String val){
		val = val.trim();
		if(val.equalsIgnoreCase("00")){
			return Unknown;
		}else if(val.equalsIgnoreCase("01")){
			return QQ;
		}else if(val.equalsIgnoreCase("02")){
			return WebChat;
		}else if(val.equals("03")){
			return WeiBo;
		}else if(val.equals("04")){
			return DouBan;
		}else{
			return null;
		}
	}
	
	/**
	 * 验证第三方账户类型标识码的合法性
	 * @param val 第三方账户类型标识码
	 * @return 验证通过（true）；验证失败（false）
	 */
	public static final boolean validation(String val){
		return getEnum(val)!=null;
	}
}
