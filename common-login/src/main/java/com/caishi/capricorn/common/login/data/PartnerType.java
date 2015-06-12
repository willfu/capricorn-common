package com.caishi.capricorn.common.login.data;


/**
 * �������˺�����ö����
 *	@see �������˻���������ѶQQ��QQ����΢�ţ�WebChat��������΢����SinaBlog�������꣨DouBan����δ֪���ͣ�UnKnown��
 */
public enum PartnerType {
	/**
	 * ��ѶQQ
	 */
	QQ,
	
	/**
	 * ��Ѷ΢��
	 */
	WebChat,
	
	/**
	 * ����΢��
	 */
	WeiBo,
	
	/**
	 * ����
	 */
	DouBan,
	
	/**
	 * δ֪�˻�
	 */
	Unknown;
	
	/**
	 * ��ȡ�������˻����ͱ�ʶ��
	 * @param type �������˻����ͱ�ö�ٶ���
	 * @return �������˻����ͱ�ʶ��
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
	 * ���ݵ������˻����ͱ�ʶ���ȡ�������˻����ͱ�ö�ٶ���
	 * @param val �������˻����ͱ�ʶ��
	 * @return �������˻����ͱ�ö�ٶ���
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
	 * ��֤�������˻����ͱ�ʶ��ĺϷ���
	 * @param val �������˻����ͱ�ʶ��
	 * @return ��֤ͨ����true������֤ʧ�ܣ�false��
	 */
	public static final boolean validation(String val){
		return getEnum(val)!=null;
	}
}
