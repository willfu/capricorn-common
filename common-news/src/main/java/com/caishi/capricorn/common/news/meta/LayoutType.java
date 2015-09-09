package com.caishi.capricorn.common.news.meta;

public enum LayoutType {

    /**
     * 无图模式
     */
    BLANK,

    /**
     * 单图模式
     */
    SINGLE,

    /**
     * 双图模式
     */
    DOUBLE,

    /**
     * 三图模式
     */
    THREE,

    /**
     * 大图模式
     */
    BIG,

    /**
     * 段子模式
     */
    PIECE,

    /**
     * 场景：大图显示
     */
    SCENE_BIG,

    /**
     * 场景：晨读
     */
    SCENE_CHENDU,

    /**
     * 电影：单图
     */
    MOVIE_SINGLE,

    /**
     * 趣图：单图
     */
    FUNNY_PICTURE_SINGLE;

    /**
     * 版式类型校验
     * @param name 版式类型名称
     * @return 校验结果
     */
    public final static boolean doValidation(String name){
        return LayoutType.valueOf(name)!=null;
    }
}
