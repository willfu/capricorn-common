package com.caishi.capricorn.common.login.data;

/**
 * �˻���������ö����
 * @see �˻��������Ͱ�����ϵͳ�Զ�����(Automatic)���û��Զ�����(Human)���������˻�(Partner)��δ֪��ʽ(UnKnown)
 */
public enum CreateMode {
	/**
	 * ϵͳ�Զ�����
	 */
	Automatic,
	
	/**
	 * �û��Զ�����
	 */
	Human,
	
	/**
	 * �������˻�
	 */
	Partner,
	
	/**
	 * δ֪��ʽ
	 */
	Unknown;
	
	/**
	 * ��ȡ������ʽ��ʶ��
	 * @param mode ������ʽ��ö����
	 * @return ������ʽ��ʶ��
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
	 * ���ݴ�����ʽ��ʶ���ȡ������ʽö����
	 * @param val ������ʽ��ʶ��
	 * @return ������ʽö����
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
	 * ��֤������ʽ��ʶ��ĺϷ���
	 * @param val ������ʽ��ʶ��
	 * @return ��֤ͨ��(true)����֤ʧ��(false)
	 */
	public static boolean validation(String val){
		return getEnum(val)!=null;
	}
}
