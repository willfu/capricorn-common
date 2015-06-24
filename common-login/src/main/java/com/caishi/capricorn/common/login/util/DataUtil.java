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

	public final static String getConsName(int consId){
		String consName = null;
		switch (consId){
			case 1:{
                consName="%e6%b0%b4%e7%93%b6%e5%ba%a7";
				break;
			}
			case 2:{
                consName="%e5%8f%8c%e9%b1%bc%e5%ba%a7";
				break;
			}
			case 3:{
                consName="%e7%99%bd%e7%be%8a%e5%ba%a7";
				break;
			}
			case 4:{
                consName="%e9%87%91%e7%89%9b%e5%ba%a7";
				break;
			}
			case 5:{
                consName="%e5%8f%8c%e5%ad%90%e5%ba%a7";
				break;
			}
			case 6:{
                consName="%e5%b7%a8%e8%9f%b9%e5%ba%a7";
				break;
			}
			case 7:{
                consName="%e7%8b%ae%e5%ad%90%e5%ba%a7";
				break;
			}
			case 8:{
                consName="%e5%a4%84%e5%a5%b3%e5%ba%a7";
				break;
			}
			case 9:{
                consName="%e5%a4%a9%e7%a7%a4%e5%ba%a7";
				break;
			}
			case 10:{
				consName="%e5%a4%a9%e8%9d%8e%e5%ba%a7";
				break;
			}
			case 11:{
                consName="%e5%b0%84%e6%89%8b%e5%ba%a7";
				break;
			}
			case 12:{
                consName="%e9%ad%94%e7%be%af%e5%ba%a7";
				break;
			}
		}
        return consName.toUpperCase();
	}

    public final static String encodeConverter(String data, String sourceEncode,String targetEncode) throws Exception {
        return new String(data.getBytes(sourceEncode),targetEncode);
    }
}
