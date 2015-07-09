package com.caishi.capricorn.common.news.meta;


public enum SlipType {

    /**
     * 上划
     */
    UP,

    /**
     * 下拉
     */
    DOWN;

    /**
     * 手势枚举类型校验
     * @param name 手势枚举字符串
     * @return 验证结果
     */
    public final static boolean doValidation(String name){
        return SlipType.valueOf(name)!=null;
    }
}
