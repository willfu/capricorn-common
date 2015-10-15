package com.caishi.capricorn.common.comment.constants;

public enum AuditLevel {

    /**
     * 评审
     */
    REVIEW(1, "REVIEW", "评审"),

    /**
     * 监测
     */
    MONITOR(2, "MONITOR", "监测");

    /**
     * structure
     *
     * @param id          audit level id
     * @param name        audit level name
     * @param description audit level description
     */
    AuditLevel(int id, String name, String description) {
        setId(id);
        setName(name);
        setDescription(description);
    }

    /**
     * audit level id
     */
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /**
     * audit level name
     */
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * audit level description
     */
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * get audit level info by id
     *
     * @param id audit level id
     * @return audit level info
     */
    public final static AuditLevel getById(int id) {
        AuditLevel result = null;
        for (AuditLevel auditLevel : AuditLevel.values()) {
            if (result.getId() == id) {
                result = auditLevel;
                break;
            }
        }
        return result;
    }

    /**
     * get audit level info by name
     *
     * @param name audit level name
     * @return audit level info
     */
    public final static AuditLevel getByName(String name) {
        AuditLevel result = null;
        if (name != null && name.length() > 0) {
            for (AuditLevel auditLevel : AuditLevel.values()) {
                if (auditLevel.getName().equalsIgnoreCase(name)) {
                    result = auditLevel;
                    break;
                }
            }
        }
        return result;
    }

    /**
     * make validation by audit level id
     *
     * @param id audit level id
     * @return audit level info
     */
    public final static boolean validation(int id) {
        AuditLevel auditLevel = getById(id);
        return auditLevel != null;
    }

    /**
     * make validation by audit level name
     *
     * @param name audit level name
     * @return audit level info
     */
    public final static boolean validation(String name) {
        AuditLevel auditLevel = getByName(name);
        return auditLevel != null;
    }
}