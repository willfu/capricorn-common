package com.caishi.capricorn.common.push.constants;

public enum PushReceiverGroup {

    /**
     * all the device in development
     */
    DEV(1, "LiudaDev", "开发测试用户"),

    /**
     * all the device in online
     */
    ONLINE(2, "LiudaOnline", "线上所有用户");

    /**
     * constructors
     *
     * @param id          push group id
     * @param name        push group name
     * @param description push group description
     */
    PushReceiverGroup(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    /**
     * push group id
     */
    private int id;

    public int getId() {
        return id;
    }

    /**
     * push group name
     */
    private String name;

    public String getName() {
        return name;
    }

    /**
     * push group description
     */
    private String description;

    public String getDescription() {
        return description;
    }

    /**
     * get push group by id
     *
     * @param id push group id
     * @return push group
     */
    public final static PushReceiverGroup getPushReceiverGroupById(int id) {
        if (id > 0) {
            for (PushReceiverGroup pushReceiverGroup : PushReceiverGroup.values()) {
                if (pushReceiverGroup.getId() == id) {
                    return pushReceiverGroup;
                }
            }
        }
        return null;
    }

    /**
     * get push group id
     *
     * @param name push group id
     * @return push group
     */
    public final static PushReceiverGroup getPushReceiverGroupByName(String name) {
        if (name != null && (!(name = name.replace(" ", "")).isEmpty())) {
            for (PushReceiverGroup pushReceiverGroup : PushReceiverGroup.values()) {
                if (pushReceiverGroup.getName().equalsIgnoreCase(name)) {
                    return pushReceiverGroup;
                }
            }
        }
        return null;
    }

    /**
     * make validation by push group id
     *
     * @param id push group id
     * @return validation status
     */
    public final boolean validation(int id) {
        return getPushReceiverGroupById(id) != null;
    }

    /**
     * make validation by push group name
     *
     * @param name push group name
     * @return validation status
     */
    public final boolean validation(String name) {
        return getPushReceiverGroupByName(name) != null;
    }
}
