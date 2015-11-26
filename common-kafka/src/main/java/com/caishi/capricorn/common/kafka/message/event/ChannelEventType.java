package com.caishi.capricorn.common.kafka.message.event;

public enum ChannelEventType {

    /**
     * refresh channel info
     */
    REFRESH(1, "REFRESH", "重新拉取频道信息列表");

    /**
     * constructors
     *
     * @param id          channel event type id
     * @param name        channel event type name
     * @param description channel event type description
     */
    ChannelEventType(int id, String name, String description) {
        setId(id);
        setName(name);
        setDescription(description);
    }

    /**
     * channel event type id
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
    public final static ChannelEventType getChannelEventType(int id) {
        for (ChannelEventType channelEventType : ChannelEventType.values()) {
            if (channelEventType.getId() == id) {
                return channelEventType;
            }
        }
        return null;
    }

    /**
     * get channel event type by channel event type name
     *
     * @param name channel event type name
     * @return channel event type info
     */
    public final static ChannelEventType getChannelEventType(String name) {
        if (name != null && !((name = name.replace(" ", "")).isEmpty())) {
            for (ChannelEventType channelEventType : ChannelEventType.values()) {
                if (channelEventType.getName().equalsIgnoreCase(name)) {
                    return channelEventType;
                }
            }
        }
        return null;
    }

    /**
     * make validation by channel event type id
     *
     * @param id channel event type id
     * @return validation status
     */
    public final static boolean validation(int id) {
        return getChannelEventType(id) != null;
    }

    /**
     * make validation by channel event type name
     *
     * @param name channel event type name
     * @return validation status
     */
    public final static boolean validation(String name) {
        return getChannelEventType(name) != null;
    }
}