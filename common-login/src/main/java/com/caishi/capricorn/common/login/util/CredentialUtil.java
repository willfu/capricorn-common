package com.caishi.capricorn.common.login.util;

import java.io.IOException;
import java.util.Date;
import com.caishi.capricorn.common.login.dto.Guid;
import com.caishi.capricorn.common.login.data.PartnerType;

/**
 * �û�ƾ֤��Ϣ������
 */
public class CredentialUtil {

    /**
     * ��֤�û�ƾ֤��Ϣ�Ƿ����
     *
     * @param credential ��ƾ֤��Ϣ
     * @return ����(true)������(false);
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
     * ���û�ƾ֤��Ϣ�г�ȡ�û�ȫ��Ψһ����
     *
     * @param credential �û�ƾ֤
     * @return �û�ȫ��Ψһ����
     * @throws IOException
     */
    public final static String getGuid(String credential) throws Exception {
        credential = DataUtil.decorderByBase64(credential);
        String[] dataSource = credential.split("@");
        return dataSource[0];
    }

    /**
     * ���û�ƾ֤��Ϣ�г�ȡ�������˻���UUID
     *
     * @param credential �û�ƾ֤
     * @return �������˻���UUID
     * @throws Exception
     */
    public final static String getPartnerUId(String credential) throws Exception {
        credential = DataUtil.decorderByBase64(credential);
        String[] dataSource = credential.split("@");
        return dataSource.length == 3 ? dataSource[2] : null;
    }

    /**
     * ���û�ƾ֤��Ϣ�г�ȡ���ڱ�ϵͳ��Χ�ڵ�UUID
     *
     * @param credential �û�ƾ֤��Ϣ
     * @return ��ϵͳ��Χ�ڵ�UUID
     * @throws Exception
     */
    public final static String getCurrentUId(String credential) throws Exception {
        String guid = getGuid(credential);
        return DataUtil.encorderByMd5(guid);
    }

    /**
     * ���û�ƾ֤��Ϣ�л�ȡ�������˺�����
     * @param credential �û�ƾ֤��Ϣ
     * @return �������˺�����
     * @throws Exception
     */
    public final static PartnerType getPartnerType(String credential) throws Exception {
        Guid guid = GuidUtil.parserGuid(getGuid(credential), false);
        return guid.getPartnerType();
    }

    /**
     * ����ȫ���û�Ψһ��������û�ƾ֤��Ϣ
     * @param guid ȫ���û�Ψһ���
     * @param partnerUId �������˻�ȫ��Ψһ���
     * @return �û�ƾ֤��Ϣ
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
     * ���´���һ���û�ƾ֤��Ϣ
     * @param credential �û�ƾ֤��Ϣ
     * @return �û�ƾ֤��Ϣ
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
