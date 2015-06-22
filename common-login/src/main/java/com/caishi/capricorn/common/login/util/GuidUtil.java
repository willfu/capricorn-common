package com.caishi.capricorn.common.login.util;
import java.io.IOException;

import org.apache.commons.codec.binary.Base64;

import com.caishi.capricorn.common.login.dto.Guid;
import com.caishi.capricorn.common.login.data.PartnerType;
import com.caishi.capricorn.common.login.data.OsType;
import com.caishi.capricorn.common.login.data.Agent;
import com.caishi.capricorn.common.login.data.CreateMode;
import com.caishi.capricorn.common.login.data.DeviceType;

public class GuidUtil {
	public String Generator(Guid model){
		return new String(Base64.encodeBase64(model.toString().getBytes()));
	}
	
	private static Guid Parser(String guid){
		Guid model = new Guid();;
		if(Validation(guid,model)){
			return model;
		}
		return null;
	}
	
	public static Guid parserGuid(String guid,Boolean isCipherText) throws Exception{
		guid = isCipherText?new String(Base64.decodeBase64(guid)):guid;
		return Parser(guid);
	}
	
	protected static boolean Validation(String guid,Guid model){
		guid = guid.trim();
		int len = Guid.DeviceIdMaxLength+Guid.TimeStampMaxLength+Guid.SequenceMaxLength+18;
		if(guid.length()==len){
			if(guid.startsWith("{",0)&&guid.startsWith("}",10)&&guid.startsWith("-",11)&&guid.startsWith("{",12)&&guid.startsWith("}",63)&&guid.startsWith("-",64)&&guid.startsWith("{",65)&&guid.startsWith("-",86)&&guid.startsWith("}",97)){
				String val = guid.substring(1,2);
				if(Agent.validation(val));{
					model.setAgent(Agent.getEnum(val));
					val = guid.substring(2,4);
					if(CreateMode.validation(val)){
						model.setCreateMode(CreateMode.getEnum(val));
						val = guid.substring(4,6);
						if(PartnerType.validation(val)){
							model.setPartnerType(PartnerType.getEnum(val));
							val = guid.substring(6, 8);
							if(DeviceType.validation(val))
								model.setDeviceType(DeviceType.getEnum(val));
								val = guid.substring(8,10);
								if(OsType.validation(val)){
									model.setOsType(OsType.getEnum(val));
									model.setDeviceId(guid.substring(13, 63));
									model.setTimeStamp(guid.substring(66, 86));
									model.setSequence(guid.substring(87, 97));
									model.setIsValidate(true);
								}
						}
					}
				}
			}
		}
		return model.getIsValidate();
	}
}
