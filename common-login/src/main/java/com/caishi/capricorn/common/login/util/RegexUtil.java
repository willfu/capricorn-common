package com.caishi.capricorn.common.login.util;

import java.util.regex.Pattern;

/**
 * 正则表达式工具类
 */
public class RegexUtil {
	
	/**
	 * 隐藏构造函数
	 */
	private RegexUtil(){}
	
	/**
	 * 验证数字字符串
	 * @param data 待验证的字符串
	 * @return 验证结果
	 */
	public static boolean checkNumber(String data){
		data = data.trim();
		String regex = "^[0-9]*$";
		return Pattern.compile(regex).matcher(data).matches();
	}
	
	/**
	 * 验证手机号码
	 * @param data 待验证的字符串
	 * @return 验证结果
	 */
	public static boolean checkMobile(String data){
		data = data.trim();
		return checkNumber(data)&&data.length()==11;
	}
	
	/**
	 * 只能输入由数字和26个英文字母组成的字符串
	 * @param data 待验证的字符串
	 * @return 验证结果
	 */
	public static boolean checkNumberAndChar(String data){
		data = data.trim();
		String regex = "^[A-Za-z0-9]+$";
		return Pattern.compile(regex).matcher(data).matches();
	}
	
	/**
	 * 只能输入由数字和26个英文字母组成的字符串
	 * @param data 待验证的字符串
	 * @param minLen 最小长度
	 * @param maxLen 最大长度
	 * @return 验证结果
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
