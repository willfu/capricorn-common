package com.caishi.capricorn.common.login.util;
import java.util.Random;
import com.caishi.capricorn.common.login.dto.CustomMessage;
import com.caishi.capricorn.common.login.dto.UserAgentInfo;

public class DataUtil {

	private DataUtil() {}

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
	
	public final static UserAgentInfo getUserAgentInfo(String userAgentContent) throws Exception{
		String productName = "Liuda";
		String itemSplit = ";";
		String keyValueSplit = ":";
		String defaultValue = "null";
		UserAgentInfo userAgentInfo = null;
		int beginIndex = userAgentContent.indexOf(productName);
		if(beginIndex>=0){
			userAgentInfo = new UserAgentInfo();
			userAgentContent = userAgentContent.substring(beginIndex);
			beginIndex = userAgentContent.indexOf("/");
			int endIndex = userAgentContent.indexOf("(");
			userAgentInfo.setVersion(userAgentContent.substring(beginIndex+1, endIndex).trim());
			userAgentContent = userAgentContent.substring(endIndex+1);
			endIndex = userAgentContent.indexOf(")");
			userAgentContent = userAgentContent.substring(0, endIndex);
			String[] items = userAgentContent.split(itemSplit);
			for(String item : items){
				String[] ds = item.split(keyValueSplit);
				if(ds.length==2){
					String key = ds[0].trim();
					String val = ds[1].trim();
					if(val!=null&&!val.equalsIgnoreCase(defaultValue)&&val.length()>0){
						if(key.equalsIgnoreCase("agent"))
						{
							userAgentInfo.setAgent(val);
						}
						
						if(key.equalsIgnoreCase("credential"))
						{
							userAgentInfo.setCredential(val);
						};
						
						if(key.equalsIgnoreCase("channel"))
						{
							userAgentInfo.setChannel(val);
						};
						
						if(key.equalsIgnoreCase("deviceId")){
							userAgentInfo.getDeviceInfo().setDeviceId(val);
						}
						
						if(key.equalsIgnoreCase("osTypeId")){
							userAgentInfo.getDeviceInfo().setOsTypeId(val);
						}
						
						if(key.equalsIgnoreCase("osVersion")){
							userAgentInfo.getDeviceInfo().setOsVersion(val);
						}
						
						if(key.equalsIgnoreCase("simTypeId")){
							userAgentInfo.getDeviceInfo().setSimTypeId(val);
						}
						
						if(key.equalsIgnoreCase("idfa")){
							userAgentInfo.getDeviceInfo().setIdfa(val);
						}
						
						if(key.equalsIgnoreCase("netTypeId")){
							userAgentInfo.getDeviceInfo().setNetTypeId(val);
						}
								
						if(key.equalsIgnoreCase("detailInfo")){
							userAgentInfo.getDeviceInfo().setDetailInfo(val);
						}
						
						if(key.equalsIgnoreCase("deviceTypeId")){
							userAgentInfo.getDeviceInfo().setDeviceTypeId(val);
						}
					}
				}
			}
			if(userAgentInfo!=null){
				return userAgentInfo;	
			}			
		}
		throw new CustomMessage("10015");
	}
}
