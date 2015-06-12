package com.caishi.capricorn.common.login.data;

/**
 * �ն��豸����
 * @see �ն��豸���Ͱ������ֻ��ն�(Mobile)��ƽ���ն�(Tablet)�������ն�(Computer)��δ֪�ն�(Unknown)
 */
public enum DeviceType {
	/**
	 * δ֪�ն�
	 */
	Unknown,
	
	/**
	 * �ֻ��ն�
	 */
	Mobile,
	
	/**
	 * ƽ���ն�
	 */
	Tablet,
	
	/**
	 * �����ն�
	 */
	Computer;
	
	/**
	 * �����ն��豸����ö�ٶ����ȡ�ն��豸��ʶ��
	 * @param type �ն��豸ö����
	 * @return �ն��豸��ʶ��
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
	 * �����ն��豸��ʶ���ȡ�ն��豸ö�ٶ���
	 * @param val �ն��豸��ʶ��
	 * @return �ն��豸ö�ٶ���
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
	 * ��֤�ն��豸��ʶ��ĺϷ���
	 * @param val �ն��豸��ʶ��
	 * @return ��֤ͨ����true������֤ʧ�ܣ�false��
	 */
	public static final boolean validation(String val){
		return getEnum(val)!=null;
	}
}
