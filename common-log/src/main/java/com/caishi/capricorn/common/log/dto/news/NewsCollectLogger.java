package com.caishi.capricorn.common.log.dto.news;

public class NewsCollectLogger extends NewsLogger {

    /**
     * 收藏类型：1:添加收藏；0:取消收藏
     */
    private int collectType;

    public int getCollectType() {
        return collectType;
    }

    public void setCollectType(int collectType) {
        this.collectType = collectType;
    }
}
