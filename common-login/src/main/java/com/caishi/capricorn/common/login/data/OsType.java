package com.caishi.capricorn.common.login.data;

/**
 * 操作系统类型枚举类
 * @see 操作系统包括：安卓操作系统（Android），苹果移动操作系统（IOS），苹果电脑操作系统（MAC），Windows电脑操作系统（Window），Window移动操作系统（WinPhone）和未知操作系统（UnKnown）
 */
public enum OsType {
	/**
	 * 未知操作系统
	 */
	Unknown,
	
	/**
	 * 安卓操作系统
	 */
	Android,
	
	/**
	 * 苹果移动操作系统
	 */
	IOS,
	
	/**
	 * 苹果电脑操作系统
	 */
	Mac,
	
	/**
	 * Windows电脑操作系统
	 */
	Window,
	
	/**
	 * Window移动操作系统
	 */
	WinPhone;
	
	/**
	 * 根据操作系统枚举类获取操作系统类型标识码
	 * @param type 操作系统类型枚举类对象
	 * @return 操作系统类型标识码
	 */
	public static final String getValue(OsType obj){
		String val = "00";
		switch(obj){
			case Unknown:
			{
				val = "00";
				break;
			}
			case Android:
			{
				val = "01";
				break;
			}
			case IOS:
			{
				val = "02";
				break;
			}
			case Mac:
			{
				val = "03";
				break;
			}
			case Window:
			{
				val = "04";
				break;
			}
			case WinPhone:
			{
				val = "05";
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
	 * 根据操作系统类型标识码获取操作系统类型枚举对象
	 * @param val 操作系统类型标识码
	 * @return 操作系统类型枚举对象
	 */
	public final static OsType getEnum(String val){
		val = val.trim();
		if(val.equalsIgnoreCase("00")){
			return Unknown;
		}else if(val.equalsIgnoreCase("01")){
			return Android;
		}else if(val.equalsIgnoreCase("02")){
			return IOS;
		}else if(val.equals("03")){
			return Mac;
		}else if(val.equalsIgnoreCase("04")){
			return Window;
		}else if(val.equalsIgnoreCase("05")){
			return WinPhone;
		}else{
			return null;
		}
	}
	
	/**
	 * 验证操作系统类型标识码的合法性
	 * @param val 操作系统类型标识码
	 * @return 验证通过（true）；验证失败（false）
	 */
	public static final boolean validation(String val){
		return getEnum(val)!=null;
	}
}
