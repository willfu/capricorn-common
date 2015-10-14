package com.caishi.capricorn.common.comment.Constants;

public enum CommentStatus {

    /**
     * 上架
     */
    ONLINE(1, "ONLINE", "上架"),

    /**
     * 下架
     */
    OFFLINE(2, "OFFLINE", "下架"),

    /**
     * 自己可见
     */
    MYSELF(3, "MYSELF", "自己可见");

    /**
     * structure
     *
     * @param id          comment status id
     * @param name        comment status name
     * @param description comment status description
     */
    CommentStatus(int id, String name, String description) {
        setId(id);
        setName(name);
        setDescription(description);
    }

    /**
     * comment status id
     */
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /**
     * comment status name
     */
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * comment status description
     */
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * get comment status by id
     *
     * @param id comment status id
     * @return comment status instance
     */
    public final static CommentStatus getById(int id) {
        CommentStatus result = null;
        for (CommentStatus commentStatus : CommentStatus.values()) {
            if (commentStatus.getId() == id) {
                result = commentStatus;
                break;
            }
        }
        return result;
    }

    /**
     * get comment status by name
     *
     * @param name comment status name
     * @return comment status instance
     */
    public final static CommentStatus getByName(String name) {
        CommentStatus result = null;
        if (name != null && name.replace(" ", "").length() > 0) {
            for (CommentStatus commentStatus : CommentStatus.values()) {
                if (commentStatus.getName().equalsIgnoreCase(name)) {
                    result = commentStatus;
                    break;
                }
            }
        }
        return result;
    }

    /**
     * make validation by id
     *
     * @param id comment status id
     * @return true or false
     */
    public final static boolean validation(int id) {
        CommentStatus commentStatus = getById(id);
        return commentStatus != null;
    }

    /**
     * make validation by name
     *
     * @param name comment status name
     * @return true or false
     */
    public final static boolean validation(String name) {
        CommentStatus commentStatus = getByName(name);
        return commentStatus != null;
    }
}
