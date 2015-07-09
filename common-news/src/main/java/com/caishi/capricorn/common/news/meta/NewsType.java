package com.caishi.capricorn.common.news.meta;

public enum NewsType {

    /**
     * 新闻
     */
    NEWS,

    /**
     * 活动
     */
    ACTIVITY,

    /**
     * 广告
     */
    ADVERTISE,

    /**
     * 段子
     */
    JOKES;

    /**
     * 新闻类型校验
     * @param name 新闻类型名称
     * @return 校验结果
     */
    public final static boolean doValidation(String name){
        return NewsType.valueOf(name)!=null;
    }
}
