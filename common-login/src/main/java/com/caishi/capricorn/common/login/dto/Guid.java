package com.caishi.capricorn.common.login.dto;

import com.caishi.capricorn.common.login.data.*;

/**
 * 用户全局唯一标识码构造对象
 */
public class Guid {

    /**
     * GUID对象的结构是否合法
     */
    private boolean _isValidate = false;

    /**
     * 获取GUID属性结构是否合法
     *
     * @return true：合法；false：违法
     */
    public boolean getIsValidate() {
        return _isValidate;
    }

    /**
     * 设置GUID属性结构的是否合法性
     *
     * @param isValidate GUID属性结构的合法性
     * @see true：合法；false：违法
     */
    public void setIsValidate(boolean isValidate) {
        this._isValidate = isValidate;
    }

    /**
     * 用户注册账户的入口类型
     *
     * @see 入口类型包括：浏览器(Browse)和移动应用(App)
     */
    private Agent _agent;

    /**
     * 获取用户注册账户的入口类型信息
     *
     * @return 入口类型枚举对象
     */
    public Agent getAgent() {
        return _agent;
    }

    /**
     * 获取用户注册账号的入口类型信息
     *
     * @param agent 入口类型枚举对象
     */
    public void setAgent(Agent agent) {
        this._agent = agent;
    }

    /**
     * 账户注册时的注册方式
     *
     * @see 账户注册方式：自动生成，用户注册和第三方登录
     */
    private CreateMode _createMode;

    /**
     * 获取账户注册时的注册方式
     *
     * @return 账户注册当时枚举对象
     */
    public CreateMode getCreateMode() {
        return _createMode;
    }

    /**
     * 设置账号注册时的注册当时
     *
     * @param createMode 账户注册当时枚举对象
     */
    public void setCreateMode(CreateMode createMode) {
        this._createMode = createMode;
    }

    /**
     * 第三方账户类型
     *
     * @see 第三方账户类型包括：QQ，微信等
     */
    private PartnerType _partnerType;

    /**
     * 获取第三方账户类型信息
     *
     * @return 第三方账户类型枚举对象
     */
    public PartnerType getPartnerType() {
        return _partnerType;
    }

    /**
     * 设置第三方账户类型信息
     *
     * @param partnerType 第三方账户类型枚举对象
     */
    public void setPartnerType(PartnerType partnerType) {
        this._partnerType = partnerType;
    }

    /**
     * 注册终端的类型信息
     */
    private DeviceType _deviceType;

    /**
     * 获取注册终端类型信息
     *
     * @return 终端类型枚举对象
     */
    public DeviceType getDeviceType() {
        return _deviceType;
    }

    /**
     * 设置注册终端类型信息
     *
     * @param deviceType 终端类型枚举对象
     */
    public void setDeviceType(DeviceType deviceType) {
        this._deviceType = deviceType;
    }

    /**
     * 注册终端所搭载的操作系统
     */
    private OsType _osType;

    /**
     * 获取注册终端所搭载的操作系统信息
     *
     * @return 操作系统类型枚举对象
     */
    public OsType getOsType() {
        return _osType;
    }

    /**
     * 设置注册终端所搭载的操作系统信息
     *
     * @param oSType 操作系统类型枚举类
     */
    public void setOsType(OsType osType) {
        this._osType = osType;
    }

    /**
     * 注册终端信息：区分大小写，固定长度为50个字符，右对齐左补全，占位符为#
     *
     * @see 旨在记录GUID生成时用户所使用的终端类型，同时引入该设备信息可以提高GUID的混淆度
     */
    private String _deviceId;

    /**
     * 注册终端信息字符串的固定长度
     */
    public static int DeviceIdMaxLength = 50;

    /**
     * 注册终端信息的占位字符(左补全字符)
     */
    public static char DeviceIdPlaceHolder = '#';

    /**
     * 获取终端信息
     *
     * @return 终端信息字符串
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
     * 设置终端信息
     *
     * @param deviceId 终端信息字符串
     */
    public void setDeviceId(String deviceId) {
        this._deviceId = deviceId.replaceAll((DeviceIdPlaceHolder + "").trim(), "").trim();
    }

    /**
     * 时间戳，时间戳字符串
     *
     * @see 旨在记录GUID生成的时间同时可从该时间戳推断出账户的生成时间
     */
    private String _timeStamp;

    /**
     * 时间戳字符串的固定长度
     */
    public static int TimeStampMaxLength = 20;

    /**
     * 时间戳字符串的占位字符(左补全字符)
     */
    public static char TimeStampPlaceHolder = '#';

    /**
     * 时间戳：取值
     *
     * @return 时间戳字符串
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
     * 时间戳：赋值
     *
     * @param timeStamp 时间戳字符串
     */
    public void setTimeStamp(String timeStamp) {
        this._timeStamp = timeStamp.replaceAll((TimeStampPlaceHolder + "").trim(), "").trim();
    }

    /**
     * 随机序列，区分大小写，长度限制在10个字符
     *
     * @see 旨在增加GUID的全局混淆度
     */
    private String _sequence;

    /**
     * 随机序列的固定长度
     */
    public static int SequenceMaxLength = 10;

    /**
     * 随机序列：取值
     *
     * @return 随机序列字符串
     */
    public String getSequence() {
        return _sequence;
    }

    /**
     * 随机序列：赋值
     *
     * @param 随机序列字符串
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
