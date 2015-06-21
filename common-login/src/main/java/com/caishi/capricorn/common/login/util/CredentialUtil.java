package com.caishi.capricorn.common.login.util;

import java.io.IOException;
import java.util.Date;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;

import com.caishi.capricorn.common.login.dto.Guid;
import com.caishi.capricorn.common.login.data.PartnerType;

public class CredentialUtil {

    public final static boolean check(String credential) throws Exception {
    	credential = new String(Base64.decodeBase64(credential));
        String[] dataSource = credential.split("@");
        long timeStamp = Long.parseLong(dataSource[1]);
        Date expire = new Date(timeStamp);
        return expire.compareTo(new Date()) < 0;
    }

    public final static String getGuid(String credential) throws Exception {
    	credential = new String(Base64.decodeBase64(credential));
        String[] dataSource = credential.split("@");
        return dataSource[0];
    }

    public final static String getPartnerUId(String credential) throws Exception {
    	credential = new String(Base64.decodeBase64(credential));
        String[] dataSource = credential.split("@");
        return dataSource.length == 3 ? dataSource[2] : null;
    }

    public final static String getCurrentUId(String credential) throws Exception {
        String guid = getGuid(credential);
        return DigestUtils.md5Hex(guid);
    }

    public final static PartnerType getPartnerType(String credential) throws Exception {
        Guid guid = GuidUtil.parserGuid(getGuid(credential), false);
        return guid.getPartnerType();
    }

    public final static String getCredential(String guid, String partnerUId) throws Exception {
        Date now = new Date();
        now = new Date(now.getTime() + 3 * 30 * 24 * 60 * 60 * 1000);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(guid);
        stringBuilder.append("@");
        stringBuilder.append(now.getTime());
        Guid guid2 = GuidUtil.parserGuid(guid, false);
        if (guid2.getPartnerType() != PartnerType.Unknown) {
            stringBuilder.append("@");
            stringBuilder.append(partnerUId);
        }
        return new String(Base64.encodeBase64(stringBuilder.toString().getBytes()));
    }

    public final static String renew(String credential) throws Exception {
        String guidStr = getGuid(credential);
        Guid guid = GuidUtil.parserGuid(guidStr, false);
        if (guid.getPartnerType() != PartnerType.Unknown) {
            return getCredential(guidStr, getPartnerUId(credential));
        }
        return getCredential(guidStr, null);
    }
}
