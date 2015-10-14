package com.caishi.capricorn.common.comment.Constants;

public enum CommentLevel {

    /**
     * 评审
     */
    REVIEW(1, "REVIEW", "评审"),

    /**
     * 监测
     */
    MONITOR(2, "MONITOR", "监测"),

    /**
     * 一般
     */
    GENERAL(3, "GENERAL", "一般"),
    /**
     * 禁言
     */
    FORBID(4, "FORBID", "禁言");

    /**
     * structure
     *
     * @param id          comment level id
     * @param name        comment level name
     * @param description comment level description
     */
    CommentLevel(int id, String name, String description) {
        setId(id);
        setName(name);
        setDescription(description);
    }

    /**
     * comment level id
     */
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /**
     * comment level name
     */
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * comment level description
     */
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * get comment level info by id
     *
     * @param id comment level id
     * @return comment level info
     */
    public final static CommentLevel getById(int id) {
        CommentLevel result = null;
        for (CommentLevel commentLevel : CommentLevel.values()) {
            if (commentLevel.getId() == id) {
                result = commentLevel;
                break;
            }
        }
        return result;
    }

    /**
     * get comment level info by name
     *
     * @param name comment level name
     * @return comment level info
     */
    public final static CommentLevel getByName(String name) {
        CommentLevel result = null;
        if (name != null && name.replace(" ", "").length() > 0) {
            for (CommentLevel commentLevel : CommentLevel.values()) {
                if (commentLevel.getName().equalsIgnoreCase(name)) {
                    result = commentLevel;
                    break;
                }
            }
        }
        return result;
    }

    /**
     * make validation by comment level id
     *
     * @param id comment level id
     * @return true or false
     */
    public final static boolean validation(int id) {
        CommentLevel commentLevel = getById(id);
        return commentLevel != null;
    }

    /**
     * make validation by comment level name
     *
     * @param name comment level name
     * @return true or false
     */
    public final static boolean validation(String name) {
        CommentLevel commentLevel = getByName(name);
        return commentLevel != null;
    }
}