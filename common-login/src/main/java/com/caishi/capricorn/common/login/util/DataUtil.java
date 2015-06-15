package com.caishi.capricorn.common.login.util;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

/**
 * 常用工具类
 */
public class DataUtil {

	/**
	 * 隐藏构造函数
	 */
	private DataUtil() {}

	/**
	 * 随机生成固定长度字符串序列字符串
	 * @param len 固定长度
	 * @return 字符串序列字符串
	 */
	public static String getRandomString(int len) {
		String buffer = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		int range = buffer.length();
		for (int i = 0; i < len; i++) {
			sb.append(buffer.charAt(random.nextInt(range)));
		}
		return sb.toString().trim();
	}
	
	/**
	 * 随机生成固定长度数字序列字符串
	 * @param len 固定长度
	 * @return 数字序列字符串
	 */
	public static String getRandomNumber(int len){
		String buffer = "0123456789";
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		int range = buffer.length();
		for (int i = 0; i < len; i++) {
			sb.append(buffer.charAt(random.nextInt(range)));
		}
		return sb.toString().trim();
	}

	/**
	 * Base64 加密
	 * @param source 明文
	 * @return 密文
	 */

	public static String encorderByBase64(String source) {
		source = source.trim();
		if (source != null && source.length() > 0) {
			sun.misc.BASE64Encoder encoder = new sun.misc.BASE64Encoder();
			return encoder.encodeBuffer(source.getBytes());
		}
		return null;
	}

	/**
	 * Base64 解密
	 * @param source 密文
	 * @return 明文
	 * @throws IOException
	 */
	public static String decorderByBase64(String source) throws IOException {
		source = source.trim();
		if (source != null && source.length() > 0) {
			sun.misc.BASE64Decoder decorder = new sun.misc.BASE64Decoder();
			return new String(decorder.decodeBuffer(source));
		}
		return null;
	}

	/**
	 * MD5加密
	 * @param source 密文
	 * @return 明文
	 * @throws NoSuchAlgorithmException
	 */
	public static String encorderByMd5(String source) throws NoSuchAlgorithmException {
		MessageDigest messageDigest = MessageDigest.getInstance("MD5");
		messageDigest.update(source.getBytes());
		byte[] buffer = messageDigest.digest();
		int i;
		StringBuilder stringBuilder = new StringBuilder();
		for (int offset = 0; offset < buffer.length; offset++) {
			i = buffer[offset];
			if (i < 0) {
				i += 256;
			}
			if (i < 16) {
				stringBuilder.append("0");
			}
			stringBuilder.append(Integer.toHexString(i));
		}
		return stringBuilder.toString();
	}
}
