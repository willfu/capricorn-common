package com.caishi.capricorn.common.kafka.message.event;

public enum ActivityEventType {

    /**
     * refresh
     */
    REFRESH(1,"REFRESH","重新拉取"),

    /**
     * offline
     */
    OFFLINE(2,"OFFLINE","活动下架");

    /**
     * constructors
     *
     * @param id          channel event type id
     * @param name        channel event type name
     * @param description channel event type description
     */
    ActivityEventType(int id, String name, String description) {
        setId(id);
        setName(name);
        setDescription(description);
    }

    /**
     * ac event type id
     */
    private int id;

    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    /**
     * channel event type name
     */
    private String name;

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    /**
     * channel event type description
     */
    private String description;

    public String getDescription() {
        return description;
    }

    private void setDescription(String description) {
        this.description = description;
    }

    /**
     * get channel event type by channel event type id
     *
     * @param id channel event type id
     * @return channel event type info
     */
    public final static ActivityEventType getActivityEventType(int id) {
        for (ActivityEventType activityEventType : ActivityEventType.values()) {
            if (activityEventType.getId() == id) {
                return activityEventType;
            }
        }
        return null;
    }

    /**
     * get activity event type by activity event type name
     *
     * @param name activity event type name
     * @return activity event type info
     */
    public final static ActivityEventType getActivityEventType(String name) {
        if (name != null && !((name = name.replace(" ", "")).isEmpty())) {
            for (ActivityEventType activityEventType : ActivityEventType.values()) {
                if (activityEventType.getName().equalsIgnoreCase(name)) {
                    return activityEventType;
                }
            }
        }
        return null;
    }

    /**
     * make validation by activity event type id
     *
     * @param id activity event type id
     * @return validation status
     */
    public final static boolean validation(int id) {
        return getActivityEventType(id) != null;
    }

    /**
     * make validation by activity event type name
     *
     * @param name activity event type name
     * @return validation status
     */
    public final static boolean validation(String name) {
        return getActivityEventType(name) != null;
    }
}
