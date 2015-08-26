package com.caishi.capricorn.common.log.dto.news;

public class NewsInteractLogger extends NewsLogger {

    /**
     * 交互类型
     */
    private String interactType;

    public String getInteractType() {
        return interactType;
    }

    public void setInteractType(String interactType) {
        this.interactType = interactType;
    }

    /**
     * 交互次数
     */
    private int clickCount=1;

    public int getClickCount() {
        return clickCount;
    }

    public void setClickCount(int clickCount) {
        this.clickCount = clickCount;
    }
}
