package com.caishi.capricorn.common.log.dto.news;

import java.util.HashSet;
import java.util.Set;

public class NewsLogger {

    /**
     * 新闻ID
     */
    private String newsId;

    public String getNewsId() {
        return newsId;
    }

    public void setNewsId(String newsId) {
        this.newsId = newsId;
    }

    /**
     * 分类
     */
    private Set<Integer> categoryIds = new HashSet<Integer>();

    public Set<Integer> getCategoryIds() {
        return categoryIds;
    }

    public void setCategoryIds(Set<Integer> categoryIds) {
        this.categoryIds = categoryIds;
    }
}
