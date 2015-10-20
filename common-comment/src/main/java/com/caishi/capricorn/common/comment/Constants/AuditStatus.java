package com.caishi.capricorn.common.comment.constants;

public enum AuditStatus {

    /**
     * 评审完毕
     */
    DONE(1, "DONE", "评审完毕"),

    /**
     * 暂未评审
     */
    UNDONE(2, "UNDONE", "暂未评审");

    /**
     * structure
     *
     * @param id          audit status id
     * @param name        audit status name
     * @param description audit status description
     */
    AuditStatus(int id, String name, String description) {
        setId(id);
        setName(name);
        setDescription(description);
    }

    /**
     * audit status
     */
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /**
     * audit status name
     */
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * audit status description
     */
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * get audit status info by id
     *
     * @param id audit status id
     * @return audit status info
     */
    public final static AuditStatus getById(int id) {
        AuditStatus result = null;
        for (AuditStatus auditStatus : AuditStatus.values()) {
            if (auditStatus.getId() == id) {
                result = auditStatus;
                break;
            }
        }
        return result;
    }

    /**
     * get audit status info by name
     *
     * @param name audit status name
     * @return audit status info
     */
    public final static AuditStatus getByName(String name) {
        AuditStatus result = null;
        if (name != null && (name = name.replace(" ", "")).length() > 0) {
            for (AuditStatus auditStatus : AuditStatus.values()) {
                if (auditStatus.getName().equalsIgnoreCase(name)) {
                    result = auditStatus;
                    break;
                }
            }
        }
        return result;
    }

    /**
     * make validation by id
     *
     * @param id audit status id
     * @return status (true or false)
     */
    public final static boolean validation(int id) {
        return getById(id) != null;
    }

    /**
     * make validation by name
     *
     * @param name audit status name
     * @return status (true or false)
     */
    public final static boolean validation(String name) {
        return getByName(name) != null;
    }
}