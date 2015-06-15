package com.caishi.capricorn.common.login.util;

import java.io.IOException;
import java.util.Date;
import com.caishi.capricorn.common.login.dto.Guid;
import com.caishi.capricorn.common.login.data.PartnerType;

/**
 * 用户凭证信息工具类
 */
public class CredentialUtil {

    /**
     * 验证用户凭证信息是否过期
     *
     * @param credential 户凭证信息
     * @return 正常(true)；过期(false);
     * @throws IOException
     */
    public final static boolean check(String credential) throws Exception {
        credential = DataUtil.decorderByBase64(credential);
        String[] dataSource = credential.split("@");
        long timeStamp = Long.parseLong(dataSource[1]);
        Date expire = new Date(timeStamp);
        return expire.compareTo(new Date()) < 0;
    }

    /**
     * 从用户凭证信息中抽取用户全局唯一编码
     *
     * @param credential 用户凭证
     * @return 用户全局唯一编码
     * @throws IOException
     */
    public final static String getGuid(String credential) throws Exception {
        credential = DataUtil.decorderByBase64(credential);
        String[] dataSource = credential.split("@");
        return dataSource[0];
    }

    /**
     * 从用户凭证信息中抽取第三方账户的UUID
     *
     * @param credential 用户凭证
     * @return 第三方账户的UUID
     * @throws Exception
     */
    public final static String getPartnerUId(String credential) throws Exception {
        credential = DataUtil.decorderByBase64(credential);
        String[] dataSource = credential.split("@");
        return dataSource.length == 3 ? dataSource[2] : null;
    }

    /**
     * 从用户凭证信息中抽取属于本系统范围内的UUID
     *
     * @param credential 用户凭证信息
     * @return 本系统范围内的UUID
     * @throws Exception
     */
    public final static String getCurrentUId(String credential) throws Exception {
        String guid = getGuid(credential);
        return DataUtil.encorderByMd5(guid);
    }

    /**
     * 从用户凭证信息中获取第三方账号类型
     * @param credential 用户凭证信息
     * @return 第三方账号类型
     * @throws Exception
     */
    public final static PartnerType getPartnerType(String credential) throws Exception {
        Guid guid = GuidUtil.parserGuid(getGuid(credential), false);
        return guid.getPartnerType();
    }

    /**
     * 根据全局用户唯一编号生成用户凭证信息
     * @param guid 全局用户唯一编号
     * @param partnerUId 第三方账户全局唯一编号
     * @return 用户凭证信息
     * @throws IOException
     */
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
        return DataUtil.encorderByBase64(stringBuilder.toString());
    }

    /**
     * 重新创建一个用户凭证信息
     * @param credential 用户凭证信息
     * @return 用户凭证信息
     * @throws Exception
     */
    public final static String renew(String credential) throws Exception {
        String guidStr = getGuid(credential);
        Guid guid = GuidUtil.parserGuid(guidStr, false);
        if (guid.getPartnerType() != PartnerType.Unknown) {
            return getCredential(guidStr, getPartnerUId(credential));
        }
        return getCredential(guidStr, null);
    }
}
