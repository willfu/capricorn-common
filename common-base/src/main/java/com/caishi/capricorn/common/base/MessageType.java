package com.caishi.capricorn.common.base;

public enum  MessageType {

    /**
     * 新闻
     */
    NEWS(1, "NEWS"),

    /**
     * 活动
     */
    ACTIVITY(2, "ACTIVITY"),

    /**
     * 广告
     */
    ADVERTISE(3, "ADVERTISE"),

    /**
     * 段子
     */
    JOKES(4, "JOKES"),

    /**
     * 场景
     */
    SCENE(5, "SCENE"),

    /**
     * 游戏
     */
    GAME(6, "GAME"),

    /**
     * 图表
     */
    CHART(7, "CHART"),

    /**
     * 视频
     */
    VIDEO(8, "VIDEO"),

    /**
     * 音频
     */
    RADIO(9, "RADIO"),

    /**
     * 测试
     */
    QUIZ(10, "QUIZ"),

    /**
     * 投票
     */
    VOTE(11, "VOTE"),

    /**
     * 影视
     */
    MOVIE(12, "MOVIE"),

    /**
     * 搞笑图片
     */
    FUNNY_GIF(13, "FUNNY_GIF");

    /**
     * constructors
     * @param id message id
     * @param name message name
     */
    MessageType(int id, String name) {
        setId(id);
        setName(name);
    }

    /**
     * 编号
     */
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /**
     * 名称
     */
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * 根据编号获取消息类型枚举信息对象
     * @param id 编号
     * @return 消息类型枚举信息对象
     */
    public final static MessageType getById(int id) {
        MessageType result = null;
        for (MessageType messageType : MessageType.values()) {
            if (messageType.getId() == id) {
                result = messageType;
                break;
            }
        }
        return result;
    }

    /**
     * 根据名称获取消息类型枚举信息对象
     * @param name 名称
     * @return 消息类型枚举信息对象
     */
    public final static MessageType getByName(String name) {
        MessageType result = null;
        if (name != null && name.length() > 0) {
            for (MessageType messageType : MessageType.values()) {
                if (messageType.getName().equalsIgnoreCase(name)) {
                    result = messageType;
                    break;
                }
            }
        }
        return result;
    }

    /**
     * 根据编号校验消息类型枚举信息对象的合法性
     * @param id 编号
     * @return true(合法),false(非法)
     */
    public final static boolean validation(int id) {
        return getById(id) != null;
    }

    /**
     * 根据名称校验消息类型枚举信息对象的合法性
     * @param name 名称
     * @return true(合法),false(非法)
     */
    public final static boolean validation(String name) {
        return getByName(name) != null;
    }
}
