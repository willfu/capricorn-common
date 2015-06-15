package com.caishi.capricorn.common.login.dto;

import com.caishi.capricorn.common.login.data.*;

/**
 * �û�ȫ��Ψһ��ʶ�빹�����
 */
public class Guid {

    /**
     * GUID����Ľṹ�Ƿ�Ϸ�
     */
    private boolean _isValidate = false;

    /**
     * ��ȡGUID���Խṹ�Ƿ�Ϸ�
     *
     * @return true���Ϸ���false��Υ��
     */
    public boolean getIsValidate() {
        return _isValidate;
    }

    /**
     * ����GUID���Խṹ���Ƿ�Ϸ���
     *
     * @param isValidate GUID���Խṹ�ĺϷ���
     * @see true���Ϸ���false��Υ��
     */
    public void setIsValidate(boolean isValidate) {
        this._isValidate = isValidate;
    }

    /**
     * �û�ע���˻����������
     *
     * @see ������Ͱ����������(Browse)���ƶ�Ӧ��(App)
     */
    private Agent _agent;

    /**
     * ��ȡ�û�ע���˻������������Ϣ
     *
     * @return �������ö�ٶ���
     */
    public Agent getAgent() {
        return _agent;
    }

    /**
     * ��ȡ�û�ע���˺ŵ����������Ϣ
     *
     * @param agent �������ö�ٶ���
     */
    public void setAgent(Agent agent) {
        this._agent = agent;
    }

    /**
     * �˻�ע��ʱ��ע�᷽ʽ
     *
     * @see �˻�ע�᷽ʽ���Զ����ɣ��û�ע��͵�������¼
     */
    private CreateMode _createMode;

    /**
     * ��ȡ�˻�ע��ʱ��ע�᷽ʽ
     *
     * @return �˻�ע�ᵱʱö�ٶ���
     */
    public CreateMode getCreateMode() {
        return _createMode;
    }

    /**
     * �����˺�ע��ʱ��ע�ᵱʱ
     *
     * @param createMode �˻�ע�ᵱʱö�ٶ���
     */
    public void setCreateMode(CreateMode createMode) {
        this._createMode = createMode;
    }

    /**
     * �������˻�����
     *
     * @see �������˻����Ͱ�����QQ��΢�ŵ�
     */
    private PartnerType _partnerType;

    /**
     * ��ȡ�������˻�������Ϣ
     *
     * @return �������˻�����ö�ٶ���
     */
    public PartnerType getPartnerType() {
        return _partnerType;
    }

    /**
     * ���õ������˻�������Ϣ
     *
     * @param partnerType �������˻�����ö�ٶ���
     */
    public void setPartnerType(PartnerType partnerType) {
        this._partnerType = partnerType;
    }

    /**
     * ע���ն˵�������Ϣ
     */
    private DeviceType _deviceType;

    /**
     * ��ȡע���ն�������Ϣ
     *
     * @return �ն�����ö�ٶ���
     */
    public DeviceType getDeviceType() {
        return _deviceType;
    }

    /**
     * ����ע���ն�������Ϣ
     *
     * @param deviceType �ն�����ö�ٶ���
     */
    public void setDeviceType(DeviceType deviceType) {
        this._deviceType = deviceType;
    }

    /**
     * ע���ն������صĲ���ϵͳ
     */
    private OsType _osType;

    /**
     * ��ȡע���ն������صĲ���ϵͳ��Ϣ
     *
     * @return ����ϵͳ����ö�ٶ���
     */
    public OsType getOsType() {
        return _osType;
    }

    /**
     * ����ע���ն������صĲ���ϵͳ��Ϣ
     *
     * @param oSType ����ϵͳ����ö����
     */
    public void setOsType(OsType osType) {
        this._osType = osType;
    }

    /**
     * ע���ն���Ϣ�����ִ�Сд���̶�����Ϊ50���ַ����Ҷ�����ȫ��ռλ��Ϊ#
     *
     * @see ּ�ڼ�¼GUID����ʱ�û���ʹ�õ��ն����ͣ�ͬʱ������豸��Ϣ�������GUID�Ļ�����
     */
    private String _deviceId;

    /**
     * ע���ն���Ϣ�ַ����Ĺ̶�����
     */
    public static int DeviceIdMaxLength = 50;

    /**
     * ע���ն���Ϣ��ռλ�ַ�(��ȫ�ַ�)
     */
    public static char DeviceIdPlaceHolder = '#';

    /**
     * ��ȡ�ն���Ϣ
     *
     * @return �ն���Ϣ�ַ���
     */
    public String getDeviceId() {
        StringBuilder stringBuilder = new StringBuilder();
        int len = this._deviceId.length();
        int start = 1;
        int end = DeviceIdMaxLength - len;
        for (int i = start; i <= end; i++) {
            stringBuilder.append(DeviceIdPlaceHolder);
        }
        for (char c : this._deviceId.toCharArray()) {
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }

    /**
     * �����ն���Ϣ
     *
     * @param deviceId �ն���Ϣ�ַ���
     */
    public void setDeviceId(String deviceId) {
        this._deviceId = deviceId.replaceAll((DeviceIdPlaceHolder + "").trim(), "").trim();
    }

    /**
     * ʱ�����ʱ����ַ���
     *
     * @see ּ�ڼ�¼GUID���ɵ�ʱ��ͬʱ�ɴӸ�ʱ����ƶϳ��˻�������ʱ��
     */
    private String _timeStamp;

    /**
     * ʱ����ַ����Ĺ̶�����
     */
    public static int TimeStampMaxLength = 20;

    /**
     * ʱ����ַ�����ռλ�ַ�(��ȫ�ַ�)
     */
    public static char TimeStampPlaceHolder = '#';

    /**
     * ʱ�����ȡֵ
     *
     * @return ʱ����ַ���
     */
    public String getTimeStamp() {
        StringBuilder stringBuilder = new StringBuilder();
        int len = this._timeStamp.length();
        int start = 1;
        int end = TimeStampMaxLength - len;
        for (int i = start; i <= end; i++) {
            stringBuilder.append(TimeStampPlaceHolder);
        }
        for (char c : this._timeStamp.toCharArray()) {
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }

    /**
     * ʱ�������ֵ
     *
     * @param timeStamp ʱ����ַ���
     */
    public void setTimeStamp(String timeStamp) {
        this._timeStamp = timeStamp.replaceAll((TimeStampPlaceHolder + "").trim(), "").trim();
    }

    /**
     * ������У����ִ�Сд������������10���ַ�
     *
     * @see ּ������GUID��ȫ�ֻ�����
     */
    private String _sequence;

    /**
     * ������еĹ̶�����
     */
    public static int SequenceMaxLength = 10;

    /**
     * ������У�ȡֵ
     *
     * @return ��������ַ���
     */
    public String getSequence() {
        return _sequence;
    }

    /**
     * ������У���ֵ
     *
     * @param ��������ַ���
     */
    public void setSequence(String sequence) {
        this._sequence = sequence;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("{");
        result.append(Agent.getValue(this.getAgent()));
        result.append(CreateMode.getValue(this.getCreateMode()));
        result.append(PartnerType.getValue(this.getPartnerType()));
        result.append(DeviceType.getValue(this.getDeviceType()));
        result.append(OsType.getValue(this.getOsType()));
        result.append("}");
        result.append("-");
        result.append("{");
        result.append(this.getDeviceId());
        result.append("}");
        result.append("-");
        result.append("{");
        result.append(this.getTimeStamp());
        result.append("-");
        result.append(this.getSequence());
        result.append("}");
        return result.toString();
    }
}
