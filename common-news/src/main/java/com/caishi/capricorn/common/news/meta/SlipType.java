package com.caishi.capricorn.common.news.meta;


public enum SlipType {

    /**
     * 上划
     */
    UP(1, "UP"),

    /**
     * 下拉
     */
    DOWN(2, "DOWN");

    SlipType(int id, String name) {
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

    private void setId(int id) {
        this.id = id;
    }

    /**
     * 名称
     */
    private String name;

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    /**
     * 根据编号获取手势类型枚举信息对象
     * @param id 编号
     * @return 手势类型枚举信息对象
     */
    public final static SlipType getById(int id) {
        SlipType result = null;
        for (SlipType slipType : SlipType.values()) {
            if (slipType.getId() == id) {
                result = slipType;
                break;
            }
        }
        return result;
    }

    /**
     * 根据名称获取手势类型枚举信息对象
     * @param name 名称
     * @return 手势类型枚举信息对象
     */
    public final static SlipType getByName(String name) {
        SlipType result = null;
        if (name != null && name.length() > 0) {
            for (SlipType slipType : SlipType.values()) {
                if (slipType.getName().equalsIgnoreCase(name)) {
                    result = slipType;
                    break;
                }
            }
        }
        return result;
    }

    /**
     * 根据编号校验手势类型枚举信息的合法性
     * @param id 名称
     * @return true:(合法) false:(非法)
     */
    public final static boolean validation(int id) {
        return getById(id) != null;
    }


    /**
     * 根据名称校验手势类型枚举信息的合法性
     * @param name 名称
     * @return true:(合法) false:(非法)
     */
    public final static boolean validation(String name) {
        return getByName(name) != null;
    }
}
