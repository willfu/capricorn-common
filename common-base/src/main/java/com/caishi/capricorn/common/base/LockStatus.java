package com.caishi.capricorn.common.base;

public enum LockStatus {

    /**
     * 已锁定
     */
    LOCKED("LS001", "LOCKED", "已锁定"),

    /**
     * 未锁定
     */
    UNLOCK("LS002", "UNLOCK", "未锁定");

    /**
     * constructors
     *
     * @param id          lock status id
     * @param name        lock status name
     * @param description lock status description
     */
    LockStatus(String id, String name, String description) {
        setId(id);
        setName(name);
        setDescription(description);
    }

    /**
     * lock status id
     */
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    /**
     * lock status name
     */
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * lock status name
     */
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * get lock status by lock status id
     *
     * @param id lock status id
     * @return lock status
     */
    public final static LockStatus getLockStatusById(String id) {
        if (id != null && !(id = id.replace(" ", "")).isEmpty()) {
            for (LockStatus lockStatus : LockStatus.values()) {
                if (lockStatus.getId().equalsIgnoreCase(id)) {
                    return lockStatus;
                }
            }
        }
        return null;
    }

    /**
     * get lock status by lock status name
     *
     * @param name lock status name
     * @return lock status
     */
    public final static LockStatus getLockStatusByName(String name) {
        if (name != null && !(name = name.replace(" ", "")).isEmpty()) {
            for (LockStatus lockStatus : LockStatus.values()) {
                if (lockStatus.getName().equalsIgnoreCase(name)) {
                    return lockStatus;
                }
            }
        }
        return null;
    }

    /**
     * make validation by lock status id
     *
     * @param id lock status id
     * @return validation status
     */
    public final static boolean makeValidationById(String id) {
        return getLockStatusById(id) != null;
    }

    /**
     * make validation by lock status name
     *
     * @param name lock status name
     * @return validation result
     */
    public final static boolean makeValidationByName(String name) {
        return getLockStatusByName(name) != null;
    }
}