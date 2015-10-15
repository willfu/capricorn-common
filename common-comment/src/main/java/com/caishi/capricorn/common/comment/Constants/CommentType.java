package com.caishi.capricorn.common.comment.constants;

public enum CommentType {

    /**
     * 实时评论
     */
    DYNAMIC(1,"DYNAMIC","实时评论"),

    /**
     * 置顶评论
     */
    TOP(2, "TOP", "置顶评论"),

    /**
     * 精选评论
     */
    PICKED(3, "PICKED", "精选评论"),

    /**
     * 热门评论
     */
    HOT(4, "HOT", "热门评论");

    /**
     * structure
     * @param id comment type id
     * @param mame comment type name
     * @param description comment type description
     */
    CommentType(int id, String mame, String description) {
        setId(id);
        setName(name());
        setDescription(description);
    }

    /**
     * comment type id
     */
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /**
     * comment type name
     */
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * comment type description
     */
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * get comment type info by id
     *
     * @param id comment type id
     * @return comment type information
     */
    public final static CommentType getById(int id) {
        CommentType result = null;
        for (CommentType commentType : CommentType.values()) {
            if (commentType.getId() == id) {
                result = commentType;
                break;
            }
        }
        return result;
    }

    /**
     * get comment type info by name
     *
     * @param name comment type name
     * @return comment type information
     */
    public final static CommentType getByName(String name) {
        CommentType result = null;
        if (name != null && name.replace(" ", "").length() > 0) {
            name = name.replace(" ", "");
            for (CommentType commentType : CommentType.values()) {
                if (commentType.getName().equalsIgnoreCase(name)) {
                    result = commentType;
                    break;
                }
            }
        }
        return result;
    }

    /**
     * make validation by comment type id
     *
     * @param id comment type id
     * @return true or false
     */
    public final static boolean validation(int id) {
        return getById(id) != null;
    }

    /**
     * make validation by comment type name
     *
     * @param name comment type name
     * @return true or false
     */
    public final static boolean validation(String name) {
        return getByName(name) != null;
    }
}
