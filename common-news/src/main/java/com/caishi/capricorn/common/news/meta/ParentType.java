package com.caishi.capricorn.common.news.meta;

public enum  ParentType {

    /**
     * 频道
     */
    CHANNEL,

    /**
     * 场景
     */
    SCENE;

    /**
     * 父本类型校验
     * @param name 父本类型名称
     * @return 校验结果
     */
    public final static boolean doValidation(String name){
        return ParentType.valueOf(name)!=null;
    }
}
