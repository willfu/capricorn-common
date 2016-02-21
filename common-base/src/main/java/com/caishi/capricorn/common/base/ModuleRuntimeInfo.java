package com.caishi.capricorn.common.base;

import java.io.Serializable;

public class ModuleRuntimeInfo implements Serializable {

    /**
     * id
     */
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    /**
     * name
     */
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * module runtime type
     */
    private ModuleRuntimeType moduleRuntimeType;

    public ModuleRuntimeType getModuleRuntimeType() {
        return moduleRuntimeType;
    }

    public void setModuleRuntimeType(ModuleRuntimeType moduleRuntimeType) {
        this.moduleRuntimeType = moduleRuntimeType;
    }

    /**
     * create time
     */
    private long createTime = System.currentTimeMillis();

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    /**
     * modify time
     */
    private long modifyTime = System.currentTimeMillis();

    public long getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(long modifyTime) {
        this.modifyTime = modifyTime;
    }

    /**
     * lock status
     */
    private LockStatus lockStatus = LockStatus.UNLOCK;

    public LockStatus getLockStatus() {
        return lockStatus;
    }

    public void setLockStatus(LockStatus lockStatus) {
        this.lockStatus = lockStatus;
    }
}