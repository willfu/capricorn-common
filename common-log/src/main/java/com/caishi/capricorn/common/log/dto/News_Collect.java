package com.caishi.capricorn.common.log.dto;

public class News_Collect extends News {

    /**
     * true:添加收藏，false:取消收藏
     */
    private boolean isCollect;

    public boolean isCollect() {
        return isCollect;
    }

    public void setIsCollect(boolean isCollect) {
        this.isCollect = isCollect;
    }

    /**
     * 发生时间
     */
    private long createTime;

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }
}
