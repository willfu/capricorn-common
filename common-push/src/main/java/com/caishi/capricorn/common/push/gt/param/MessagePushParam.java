package com.caishi.capricorn.common.push.gt.param;

public class MessagePushParam extends PushParam {

    /**
     * message id
     */
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    /**
     * message type
     */
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    /**
     * message title
     */
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * message summary
     */
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    /**
     * parent type (PUSH)
     */
    private String parentType;

    public String getParentType() {
        return parentType;
    }

    public void setParentType(String parentType) {
        this.parentType = parentType;
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
     * message categoryIds
     */
    private String categoryIds;

    public String getCategoryIds() {
        return categoryIds;
    }

    public void setCategoryIds(String categoryIds) {
        this.categoryIds = categoryIds;
    }

    /**
     * display style (src or native)
     */
    private Boolean srcDisplay;

    public Boolean getSrcDisplay() {
        return srcDisplay;
    }

    public void setSrcDisplay(Boolean srcDisplay) {
        this.srcDisplay = srcDisplay;
    }
}