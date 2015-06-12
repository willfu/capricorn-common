package com.caishi.capricorn.common.login.data;

/**
 * ����ϵͳ����ö����
 * @see ����ϵͳ��������׿����ϵͳ��Android����ƻ���ƶ�����ϵͳ��IOS����ƻ�����Բ���ϵͳ��MAC����Windows���Բ���ϵͳ��Window����Window�ƶ�����ϵͳ��WinPhone����δ֪����ϵͳ��UnKnown��
 */
public enum OsType {
	/**
	 * δ֪����ϵͳ
	 */
	Unknown,
	
	/**
	 * ��׿����ϵͳ
	 */
	Android,
	
	/**
	 * ƻ���ƶ�����ϵͳ
	 */
	IOS,
	
	/**
	 * ƻ�����Բ���ϵͳ
	 */
	Mac,
	
	/**
	 * Windows���Բ���ϵͳ
	 */
	Window,
	
	/**
	 * Window�ƶ�����ϵͳ
	 */
	WinPhone;
	
	/**
	 * ���ݲ���ϵͳö�����ȡ����ϵͳ���ͱ�ʶ��
	 * @param type ����ϵͳ����ö�������
	 * @return ����ϵͳ���ͱ�ʶ��
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
	 * ���ݲ���ϵͳ���ͱ�ʶ���ȡ����ϵͳ����ö�ٶ���
	 * @param val ����ϵͳ���ͱ�ʶ��
	 * @return ����ϵͳ����ö�ٶ���
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
	 * ��֤����ϵͳ���ͱ�ʶ��ĺϷ���
	 * @param val ����ϵͳ���ͱ�ʶ��
	 * @return ��֤ͨ����true������֤ʧ�ܣ�false��
	 */
	public static final boolean validation(String val){
		return getEnum(val)!=null;
	}
}
