package com.caishi.capricorn.common.log.type;

public enum NewsLoggerType {

    /**
     * 访问
     */
    CLICK(11001, "CLICK"),

    /**
     * 收藏
     */
    COLLECT(11002, "COLLECT"),

    /**
     * 讨厌
     */
    DISLIKE(11003, "DISLIKE"),

    /**
     * 交互
     */
    INTERACT(11004, "INTERACT"),

    /**
     * 分享
     */
    SHARE(11005, "SHARE");


    NewsLoggerType(int id, String name) {
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
     * 根据编号获取新闻日志类型枚举对象
     *
     * @param id 编号
     * @return 新闻日志类型枚举对象
     */
    public final static NewsLoggerType getById(int id) {
        NewsLoggerType result = null;
        for (NewsLoggerType newsLoggerType : NewsLoggerType.values()) {
            if (newsLoggerType.getId() == id) {
                result = newsLoggerType;
            }
        }
        return result;
    }

    /**
     * 根据名称获取新闻日志类型枚举对象
     *
     * @param name 名称
     * @return 新闻日志类型枚举对象
     */
    public final static NewsLoggerType getByName(String name) {
        NewsLoggerType result = null;
        if (name != null && name.length() > 0) {
            for (NewsLoggerType newsLoggerType : NewsLoggerType.values()) {
                if (newsLoggerType.name.equalsIgnoreCase(name)) {
                    result = newsLoggerType;
                    break;
                }
            }
        }
        return result;
    }

    /**
     * 根据编号校验新闻日志类型枚举对象的合法性
     * @param id 编号
     * @return true(合法), false(非法)
     */
    public final static boolean validation(int id) {
        return getById(id) != null;
    }

    /**
     * 根据名称校验新闻日志类型枚举对象的合法性
     * @param name 名称
     * @return true(合法), false(非法)
     */
    public final static boolean validation(String name) {
        return getByName(name) != null;
    }
}
