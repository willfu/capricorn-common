package com.caishi.capricorn.common.login.data;

/**
 * 终端设备类型
 * @see 终端设备类型包括：手机终端(Mobile)，平板终端(Tablet)，电脑终端(Computer)及未知终端(Unknown)
 */
public enum DeviceType {
	/**
	 * 未知终端
	 */
	Unknown,
	
	/**
	 * 手机终端
	 */
	Mobile,
	
	/**
	 * 平板终端
	 */
	Tablet,
	
	/**
	 * 电脑终端
	 */
	Computer;
	
	/**
	 * 根据终端设备类型枚举对象获取终端设备标识码
	 * @param type 终端设备枚举类
	 * @return 终端设备标识码
	 */
	public static final String getValue(DeviceType obj){
		String val = "00";
		switch(obj){
			case Mobile:
			{
				val = "01";
				break;
			}
			case Tablet:
			{
				val = "02";
				break;
			}
			case Computer:
			{
				val = "03";
				break;
			}
			case Unknown:
			{
				val = "00";
				break;
			}
		}
		return val;
	}
	
	/**
	 * 根据终端设备标识码获取终端设备枚举对象
	 * @param val 终端设备标识码
	 * @return 终端设备枚举对象
	 */
	public static final DeviceType getEnum(String val){
		val = val.trim();
		if(val.equalsIgnoreCase("00")){
			return Unknown;
		}else if(val.equalsIgnoreCase("01")){
			return Mobile;
		}else if(val.equalsIgnoreCase("02")){
			return Tablet;
		}else if(val.equalsIgnoreCase("03")){
			return Computer;
		}else{
			return null;
		}
	}
	
	/**
	 * 验证终端设备标识码的合法性
	 * @param val 终端设备标识码
	 * @return 验证通过（true）；验证失败（false）
	 */
	public static final boolean validation(String val){
		return getEnum(val)!=null;
	}
}
