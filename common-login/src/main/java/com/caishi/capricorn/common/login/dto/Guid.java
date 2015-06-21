package com.caishi.capricorn.common.login.dto;

import com.caishi.capricorn.common.login.data.*;

public class Guid {

    private boolean _isValidate = false;

    public boolean getIsValidate() {
        return _isValidate;
    }

    public void setIsValidate(boolean isValidate) {
        this._isValidate = isValidate;
    }

    private Agent _agent;

    public Agent getAgent() {
        return _agent;
    }

    public void setAgent(Agent agent) {
        this._agent = agent;
    }

    private CreateMode _createMode;

    public CreateMode getCreateMode() {
        return _createMode;
    }

    public void setCreateMode(CreateMode createMode) {
        this._createMode = createMode;
    }

    private PartnerType _partnerType;

    public PartnerType getPartnerType() {
        return _partnerType;
    }

    public void setPartnerType(PartnerType partnerType) {
        this._partnerType = partnerType;
    }

    private DeviceType _deviceType;

    public DeviceType getDeviceType() {
        return _deviceType;
    }

    public void setDeviceType(DeviceType deviceType) {
        this._deviceType = deviceType;
    }

    private OsType _osType;

    public OsType getOsType() {
        return _osType;
    }

    public void setOsType(OsType osType) {
        this._osType = osType;
    }

    private String _deviceId;

    public static int DeviceIdMaxLength = 50;

    public static char DeviceIdPlaceHolder = '#';

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

    public void setDeviceId(String deviceId) {
        this._deviceId = deviceId.replaceAll((DeviceIdPlaceHolder + "").trim(), "").trim();
    }

    private String _timeStamp;

    public static int TimeStampMaxLength = 20;

    public static char TimeStampPlaceHolder = '#';

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

    public void setTimeStamp(String timeStamp) {
        this._timeStamp = timeStamp.replaceAll((TimeStampPlaceHolder + "").trim(), "").trim();
    }

    private String _sequence;

    public static int SequenceMaxLength = 10;

    public String getSequence() {
        return _sequence;
    }

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
