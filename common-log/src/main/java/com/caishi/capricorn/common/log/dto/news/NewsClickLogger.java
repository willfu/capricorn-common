package com.caishi.capricorn.common.log.dto.news;

import java.util.Set;

public class NewsClickLogger extends NewsLogger {

    /**
     * 新闻分类字符串
     */
    private Set<Integer> categoryIds;

    public Set<Integer> getCategoryIds() {
        return categoryIds;
    }

    public void setCategoryIds(Set<Integer> categoryIds) {
        this.categoryIds = categoryIds;
    }
}
