package com.caishi.capricorn.common.log.dto.news;

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
     * 父本类型
     */
    public String parentType;

    public String getParentType() {
        return parentType;
    }

    public void setParentType(String parentType) {
        this.parentType = parentType;
    }

    /**
     * 父本ID
     */
    private int parentId;

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

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
