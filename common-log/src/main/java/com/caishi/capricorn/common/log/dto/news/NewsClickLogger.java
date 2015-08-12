package com.caishi.capricorn.common.log.dto.news;

public class NewsClickLogger extends NewsLogger {

    /**
     * 新闻分类字符串
     */
    private String categoryIds;

    public String getCategoryIds() {
        return categoryIds;
    }

    public void setCategoryIds(String categoryIds) {
        this.categoryIds = categoryIds;
    }
}
