package com.caishi.capricorn.common.news.meta;

public enum LayoutType {

    /**
     * 无图模式
     */
    BLANK(1001, "BLANK"),

    /**
     * 单图模式
     */
    SINGLE(1002, "SINGLE"),

    /**
     * 双图模式
     */
    DOUBLE(1003, "DOUBLE"),

    /**
     * 三图模式
     */
    THREE(1004, "THREE"),

    /**
     * 大图模式
     */
    BIG(1005, "BIG"),

    /**
     * 段子模式
     */
    PIECE(1006, "PIECE"),

    /**
     * 场景：大图显示
     */
    SCENE_BIG(1007, "SCENE_BIG"),

    /**
     * 场景：晨读
     */
    SCENE_CHENDU(1008, "SCENE_CHENDU"),

    /**
     * 电影：单图
     */
    MOVIE_SINGLE(1009, "MOVIE_SINGLE"),

    /**
     * 趣图：单图
     */
    FUNNY_PICTURE_SINGLE(1010, "FUNNY_PICTURE_SINGLE"),

    /**
     * 活动：单图
     */
    ACTIVITY_SINGLE(1011, "ACTIVITY_SINGLE");

    LayoutType(int id, String name) {
        setId(id);
        setName(name);
    }

    /**
     * 编好
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
     * 根据编号获取布局类型枚举信息对象
     * @param id 编号
     * @return 布局类型枚举信息对象
     */
    public final static LayoutType getById(int id) {
        LayoutType result = null;
        for (LayoutType layoutType : LayoutType.values()) {
            if (layoutType.getId() == id) {
                result = layoutType;
                break;
            }
        }
        return result;
    }

    /**
     * 根据名称获取布局类型枚举信息对象
     * @param name 名称
     * @return 布局类型枚举信息对象
     */
    public final static LayoutType getByName(String name) {
        LayoutType result = null;
        if (name != null && name.length() > 0) {
            for (LayoutType layoutType : LayoutType.values()) {
                if (layoutType.getName().equalsIgnoreCase(name)) {
                    result = layoutType;
                    break;
                }
            }
        }
        return result;
    }

    /**
     * 根据编号校验布局类型枚举对象的合法性
     * @param id 编号
     * @return true:(合法), false:(非法)
     */
    public final static boolean validation(int id) {
        return getById(id) != null;
    }

    /**
     * 根据名称校验布局类型枚举对象的合法性
     * @param name 名称
     * @return true:(合法), false:(非法)
     */
    public final static boolean validation(String name) {
        return getByName(name) != null;
    }
}
