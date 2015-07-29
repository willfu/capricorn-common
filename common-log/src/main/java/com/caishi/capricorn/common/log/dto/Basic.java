package com.caishi.capricorn.common.log.dto;

import com.caishi.capricorn.common.login.data.DeviceType;

public class Basic {

    /**
     * 用户ID
     */
    private String userId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * 是否是匿名账户
     */
    private boolean isTemp;

    public boolean isTemp() {
        return isTemp;
    }

    public void setIsTemp(boolean isTemp) {
        this.isTemp = isTemp;
    }

    /**
     * 设备ID
     */
    private String deviceId;

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    /**
     * 设备类型
     */
    private String deviceTypeId;

    public String getDeviceTypeId() {
        return deviceTypeId;
    }

    public void setDeviceTypeId(String deviceTypeId) {
        this.deviceTypeId = deviceTypeId;
    }

    /**
     * 发生时间
     */
    private String createTime;

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    /**
     * 数据校验
     * @return 数据校验结果
     */
    public boolean makeValidation(){
        boolean status = userId!=null&&userId.length()>0;
        if(status){
            status = deviceId!=null&&deviceId.length()>0;
            if(status){
                status = DeviceType.validation(deviceTypeId);
                if(status){
                    status = createTime!=null&&createTime.length()==12;
                }
            }
        }
        return status;
    }
}
