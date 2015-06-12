package com.caishi.capricorn.common.login.util;

import java.util.regex.Pattern;

/**
 * ������ʽ������
 */
public class RegexUtil {
	
	/**
	 * ���ع��캯��
	 */
	private RegexUtil(){}
	
	/**
	 * ��֤�����ַ���
	 * @param data ����֤���ַ���
	 * @return ��֤���
	 */
	public static boolean checkNumber(String data){
		data = data.trim();
		String regex = "^[0-9]*$";
		return Pattern.compile(regex).matcher(data).matches();
	}
	
	/**
	 * ��֤�ֻ�����
	 * @param data ����֤���ַ���
	 * @return ��֤���
	 */
	public static boolean checkMobile(String data){
		data = data.trim();
		return checkNumber(data)&&data.length()==11;
	}
	
	/**
	 * ֻ�����������ֺ�26��Ӣ����ĸ��ɵ��ַ���
	 * @param data ����֤���ַ���
	 * @return ��֤���
	 */
	public static boolean checkNumberAndChar(String data){
		data = data.trim();
		String regex = "^[A-Za-z0-9]+$";
		return Pattern.compile(regex).matcher(data).matches();
	}
	
	/**
	 * ֻ�����������ֺ�26��Ӣ����ĸ��ɵ��ַ���
	 * @param data ����֤���ַ���
	 * @param minLen ��С����
	 * @param maxLen ��󳤶�
	 * @return ��֤���
	 */
	public static boolean checkNumberAndChar(String data,int minLen,int maxLen){
		data = data.trim();
		String regex = "^[A-Za-z0-9]+$";
		if(Pattern.compile(regex).matcher(data).matches()){
			return data.length()>=minLen&&data.length()<=maxLen;
		};
		return false;
	}
}
