package com.caishi.capricorn.common.push.constants;

public enum PushStatus {

    /**
     * WAITING
     */
    WAITING(1, "WAITING", "等待被发送"),

    /**
     * RUNNING
     */
    RUNNING(2, "RUNNING", "正在被发送"),

    /**
     * SUCCESS
     */
    SUCCESS(3, "SUCCESS", "发送成功"),

    /**
     * FAILED
     */
    FAILED(4, "FAILED", "发送失败"),

    /**
     * ERROR
     */
    ERROR(5, "ERROR", "遇到错误"),

    /**
     * PARTIAL
     */
    PARTIAL(6, "PARTIAL", "部分成功"),

    /**
     * REVOKE
     */
    REVOKE(7, "REVOKE", "撤销任务"),

    /**
     * TIMEOUT
     */
    TIMEOUT(8,"TIMEOUT","任务过期");


    /**
     * constructors
     *
     * @param id          push status id
     * @param name        push status name
     * @param description push status description
     */
    PushStatus(int id, String name, String description) {
        setId(id);
        setName(name);
        setDescription(description);
    }

    /**
     * push status id
     */
    private int id;

    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    /**
     * push status name
     */
    private String name;

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    /**
     * push status description
     */
    private String description;

    public String getDescription() {
        return description;
    }

    private void setDescription(String description) {
        this.description = description;
    }

    /**
     * get push status by push status id
     *
     * @param id push status id
     * @return push status
     */
    public final static PushStatus getPushStatus(int id) {
        if (id >= 1 && id <= 6) {
            for (PushStatus pushStatus : PushStatus.values()) {
                if (pushStatus.getId() == id) {
                    return pushStatus;
                }
            }
        }
        return null;
    }

    /**
     * get push status by push status name
     *
     * @param name push status name
     * @return push status
     */
    public final static PushStatus getPushStatus(String name) {
        if (name != null && (!(name = name.replace(" ", "")).isEmpty())) {
            for (PushStatus pushStatus : PushStatus.values()) {
                if (pushStatus.getName().equalsIgnoreCase(name)) {
                    return pushStatus;
                }
            }
        }
        return null;
    }

    /**
     * make validation by push status id
     *
     * @param id push status id
     * @return validation status
     */
    public final static boolean validation(int id) {
        return getPushStatus(id) != null;
    }

    /**
     * make validation by push status name
     *
     * @param name push status name
     * @return validation status
     */
    public final static boolean validation(String name) {
        return getPushStatus(name) != null;
    }
}