package com.caishi.capricorn.common.log;

public enum LogType {
    /**
     * 新闻收藏
     */
    NEWS_COLLECT,

    /**
     * 新闻分享
     */
    NEWS_SHARE,

    /**
     * 新闻交互
     */
    NEWS_INTERACT,

    /**
     * 进入场景
     */
    SCENE_OPEN;

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
     * 获取日志类型枚举类
     * @param name 枚举名称
     * @return 日志类型枚举类
     */
    public final static LogType getByName(String name){
        return LogType.getByName(name);
    }

    /**
     * 校验日志类型名称是否存在
     * @param name 日志类型名称
     * @return 存在标识
     */
    public final static boolean validation(String name){
        return LogType.getByName(name)!=null;
    }
}
