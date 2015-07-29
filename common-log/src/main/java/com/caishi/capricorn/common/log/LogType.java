package com.caishi.capricorn.common.log;

public enum LogType {
    /**
     * 新闻收藏
     */
    NEWS_COLLECT,

    /**
     * 取消收藏
     */
    NEWS_DIS_COLLECT,

    /**
     * 新闻分享
     */
    NEWS_SHARE,

    /**
     * 新闻交互
     */
    NEWS_INTERACT,

    /**
     * 新闻阅览
     */
    NEWS_VIEW,

    /**
     * 新闻不喜欢
     */
    NEWS_DISLIKE,

    /**
     * 进入场景
     */
    SCENE_VIEW;

    /**
     * 校验日志类型是否存在
     * @param logType 日志类型
     * @return 日志类型是否存在
     */
    public final static boolean check(LogType logType){
        boolean result = false;
        for(LogType item : LogType.values()){
            if(item.equals(logType)){
                result=true;
                break;
            }
            continue;
        }
        return result;
    }

    /**
     * 校验日志类型名称是否存在
     * @param name 日志类型名称
     * @return 存在标识
     */
    public final static boolean validation(String name){
        return LogType.valueOf(name)!=null;
    }
}
