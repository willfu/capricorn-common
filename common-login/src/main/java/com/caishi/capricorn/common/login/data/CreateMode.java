package com.caishi.capricorn.common.login.data;

/**
 * 账户生成类型枚举类
 * @see 账户生成类型包括：系统自动创建(Automatic)，用户自动创建(Human)，第三方账户(Partner)及未知方式(UnKnown)
 */
public enum CreateMode {
	/**
	 * 系统自动创建
	 */
	Automatic,
	
	/**
	 * 用户自动创建
	 */
	Human,
	
	/**
	 * 第三方账户
	 */
	Partner,
	
	/**
	 * 未知方式
	 */
	Unknown;
	
	/**
	 * 获取创建方式标识码
	 * @param mode 创建方式标枚举类
	 * @return 创建方式标识码
	 */
	public static final String getValue(CreateMode obj){
		String val = "00";
		switch (obj) {
			case Human:{
				val = "01";
				break;
			}
			case Automatic:{
				val = "02";
				break;
			}
			case Partner:{
				val = "03";
				break;
			}
			case Unknown:{
				val = "00";
				break;
			}
			default:{
				val = "00";
				break;
			}
		}
		return val;
	}
	
	/**
	 * 根据创建方式标识码获取创建方式枚举类
	 * @param val 创建方式标识码
	 * @return 创建方式枚举类
	 */
	public static final CreateMode getEnum(String val){
		val = val.trim();
		if(val.equalsIgnoreCase("00")){
			return Unknown;
		}else if(val.equalsIgnoreCase("01")){
			return Human;
		}else if(val.equalsIgnoreCase("02")){
			return Automatic;
		}else if(val.equalsIgnoreCase("03")){
			return Partner;
		}else{
			return null;
		}
	}
	
	/**
	 * 验证创建方式标识码的合法性
	 * @param val 创建方式标识码
	 * @return 验证通过(true)，验证失败(false)
	 */
	public static boolean validation(String val){
		return getEnum(val)!=null;
	}
}
