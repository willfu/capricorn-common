package com.caishi.capricorn.common.social.meta;

public enum InteractType {

    /**
     * 阅
     */
    VIEW(1, "VIEW"),

    /**
     * 荐
     */
    RECOMMEND(2, "RECOMMEND"),

    /**
     * 心碎了
     */
    BROKEN(3, "BROKEN"),

    /**
     * 我的上帝
     */
    GOD(4, "GOD"),

    /**
     * 槑
     */
    DAI(5, "DAI");

    InteractType(int id, String name) {
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
     * 根据编号获取交互类型枚举信息对象
     *
     * @param id 编号
     * @return 交互类型枚举信息对象
     */
    public final static InteractType getById(int id) {
        InteractType result = null;
        for (InteractType interactType : InteractType.values()) {
            if (interactType.getId() == id) {
                result = interactType;
                break;
            }
        }
        return result;
    }

    /**
     * 根据名称获取交互类型枚举信息对象
     *
     * @param name 名称
     * @return 交互类型枚举信息对象
     */
    public final static InteractType getByName(String name) {
        InteractType result = null;
        if (name != null && name.length() > 0) {
            for (InteractType interactType : InteractType.values()) {
                if (interactType.getName().equalsIgnoreCase(name)) {
                    result = interactType;
                    break;
                }
            }
        }
        return result;
    }

    /**
     * 根据编号校验交互类型枚举信息对象的合法性
     *
     * @param id 编号
     * @return 交互类型枚举信息对象的合法性
     */
    public final static boolean validation(int id) {
        return getById(id) != null;
    }

    /**
     * 根据名称校验交互类型枚举信息对象的合法性
     *
     * @param name 名称
     * @return 交互类型枚举信息对象的合法性
     */
    public final static boolean validation(String name) {
        return getByName(name) != null;
    }
}
