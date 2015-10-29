package com.caishi.capricorn.common.comment.constants;

public enum CommentEngineType {

    /**
     * 置顶评论推荐引擎
     */
    TOP(1, "TOP", "置顶评论推荐引擎"),

    /**
     * 精选评论推荐引擎
     */
    PICKED(1, "PICKED", "精选评论推荐引擎"),

    /**
     * 热门评论推荐引擎
     */
    HOT(3, "HOT", "热门评论推荐引擎"),

    /**
     * 实时评论推荐引擎
     */
    DYNAMIC(4, "DYNAMIC", "实时评论推荐引擎");

    /**
     * structure
     *
     * @param id          comment engine type id
     * @param name        comment engine type name
     * @param description comment engine type description
     */
    CommentEngineType(int id, String name, String description) {
        setId(id);
        setName(name);
        setDescription(description);
    }

    /**
     * comment engine type id
     */
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /**
     * comment engine type name
     */
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * comment engine type description
     */
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * get comment engine type info by id
     *
     * @param id comment engine type id
     * @return comment engine type info
     */
    public final static CommentEngineType getById(int id) {
        CommentEngineType result = null;
        for (CommentEngineType commentEngineType : CommentEngineType.values()) {
            if (commentEngineType.getId() == id) {
                result = commentEngineType;
                break;
            }
        }
        return result;
    }

    /**
     * get comment engine type info by name
     *
     * @param name comment engine type name
     * @return comment engine type info
     */
    public final static CommentEngineType getByName(String name) {
        CommentEngineType result = null;
        if (name != null && (name = name.replace(" ", "")).length() > 0) {
            for (CommentEngineType commentEngineType : CommentEngineType.values()) {
                if (commentEngineType.getName().equalsIgnoreCase(name)) {
                    result = commentEngineType;
                    break;
                }
            }
        }
        return result;
    }

    /**
     * make comment engine type validation by id
     *
     * @param id comment engine type id
     * @return validation status (true:ok, false:bad)
     */
    public final static boolean validation(int id) {
        return getById(id) != null;
    }

    /**
     * make comment engine type validation by name
     *
     * @param name comment engine type name
     * @return validation status (true:ok, false:bad)
     */
    public final static boolean validation(String name) {
        return getByName(name) != null;
    }
}