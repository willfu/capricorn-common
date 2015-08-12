package com.caishi.capricorn.common.login.util;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
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
		}
		return userAgentInfo;
	}

	public final static String getConsName(int consId){
		String consName = null;
		switch (consId){
			case 1:{
                consName="水瓶座";
				break;
			}
			case 2:{
                consName="双鱼座";
				break;
			}
			case 3:{
                consName="白羊座";
				break;
			}
			case 4:{
                consName="金牛座";
				break;
			}
			case 5:{
                consName="双子座";
				break;
			}
			case 6:{
                consName="巨蟹座";
				break;
			}
			case 7:{
                consName="狮子座";
				break;
			}
			case 8:{
                consName="处女座";
				break;
			}
			case 9:{
                consName="天秤座";
				break;
			}
			case 10:{
				consName="天蝎座";
				break;
			}
			case 11:{
                consName="射手座";
				break;
			}
			case 12:{
                consName="摩羯座";
				break;
			}
		}
        return consName.trim();
	}

    public final static String encodeConverter(String data, String sourceEncode,String targetEncode) throws Exception {
        return new String(data.getBytes(sourceEncode),targetEncode);

    }

	public final static byte[] serialize(Object object) throws Exception {
		byte[] bytes = null;
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		try{
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
			objectOutputStream.writeObject(object);
			objectOutputStream.flush();
			bytes = byteArrayOutputStream.toByteArray ();
			objectOutputStream.close();
			byteArrayOutputStream.close();
		}catch (Exception ex){
			throw  ex;
		}
		return bytes;
	}


	public final static Object deserialize(byte[] bytes) throws Exception {
		Object obj = null;
		try{
			ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
			ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
			obj = objectInputStream.readObject();
			objectInputStream.close();
			byteArrayInputStream.close();
		}catch (Exception ex){
			throw  ex;
		}
		return obj;
	}
}
