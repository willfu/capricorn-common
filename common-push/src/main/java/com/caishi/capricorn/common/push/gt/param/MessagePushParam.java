package com.caishi.capricorn.common.push.gt.param;


import java.io.Serializable;

public class MessagePushParam implements Serializable {

    /**
     * news id
     */
    private String newsId;

    public String getNewsId() {
        return newsId;
    }

    public void setNewsId(String newsId) {
        this.newsId = newsId;
    }

    /**
     * parent type
     */
    private String parentType;

    public String getParentType() {
        return parentType;
    }

    public void setParentType(String parentType) {
        this.parentType = parentType;
    }

    /**
     * news type
     */
    private String newsType;

    public String getNewsType() {
        return newsType;
    }

    public void setNewsType(String newsType) {
        this.newsType = newsType;
    }

    /**
     * parent id
     */
    private int parentId;

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    /**
     * category id
     */
    private String categoryIds;

    public String getCategoryIds() {
        return categoryIds;
    }

    public void setCategoryIds(String categoryIds) {
        this.categoryIds = categoryIds;
    }

    /**
     * display status
     */
    private Boolean srcDisplay;

    public Boolean getSrcDisplay() {
        return srcDisplay;
    }

    public void setSrcDisplay(Boolean srcDisplay) {
        this.srcDisplay = srcDisplay;
    }
}