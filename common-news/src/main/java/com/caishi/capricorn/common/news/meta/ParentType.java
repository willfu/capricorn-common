package com.caishi.capricorn.common.news.meta;

public enum  ParentType {

    /**
     * 推送
     */
    PUSH(1, "PUSH"),

    /**
     * 流体
     */
    FEED(2, "FEED"),

    /**
     * 频道
     */
    CHANNEL(3, "CHANNEL"),

    /**
     * 收藏
     */
    COLLECT(4, "COLLECT"),

    /**
     * 场景
     */
    SCENE(5, "SCENE"),

    /**
     * 足迹
     */
    MARK(6, "MARK"),

    /**
     * HTML5
     */
    HTML5(7, "HTML5");

    ParentType(int id, String name) {
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
     * 根据编号获取父本类型枚举信息
     * @param id 编号
     * @return 父本信息枚举对象
     */
    public final static ParentType getById(int id) {
        ParentType result = null;
        for (ParentType parentType : ParentType.values()) {
            if (parentType.getId() == id) {
                result = parentType;
                break;
            }
        }
        return result;
    }

    /**
     * 根据名称获取父本类型枚举对象
     * @param name 名称
     * @return 父本类型枚举对象
     */
    public final static ParentType getByName(String name) {
        ParentType result = null;
        if (name != null && name.length() > 0) {
            for (ParentType parentType : ParentType.values()) {
                if (parentType.getName().equalsIgnoreCase(name)) {
                    result = parentType;
                    break;
                }
            }
        }
        return result;
    }

    /**
     * 根据编号检验父本类型枚举对象合法性
     * @param id 编号
     * @return true:合法, false:非法
     */
    public final static boolean validation(int id) {
        return getById(id) != null;
    }

    /**
     * 根据名称校验父本类型枚举对象合法性
     * @param name 名称
     * @return true:合法, false:非法
     */
    public final static boolean validation(String name) {
        return getByName(name) != null;
    }
}
