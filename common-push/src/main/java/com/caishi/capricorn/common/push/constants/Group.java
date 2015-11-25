package com.caishi.capricorn.common.push.constants;

public enum Group {

    /**
     * all the device in development
     */
    DEV(1, "LiudaDev", "开发测试用户"),

    /**
     * all the device in online
     */
    ONLINE(2, "LiudaOnline", "线上所有用户");

    /**
     * Constructors
     *
     * @param id          push group id
     * @param name        push group name
     * @param description push group description
     */
    Group(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    /**
     * push group id
     */
    private int id;

    public int getId() {
        return id;
    }

    /**
     * push group name
     */
    private String name;

    public String getName() {
        return name;
    }

    /**
     * push group description
     */
    private String description;

    public String getDescription() {
        return description;
    }

    /**
     * get push group by id
     *
     * @param id push group id
     * @return push group
     */
    public final static Group getPushGroupById(int id) {
        Group result = null;
        if (id > 0) {
            for (Group pushGroup : Group.values()) {
                if (pushGroup.getId() == id) {
                    result = pushGroup;
                    break;
                }
            }
        }
        return result;
    }

    /**
     * get push group id
     *
     * @param name push group id
     * @return push group
     */
    public final static Group getPushGroupByName(String name) {
        Group result = null;
        if (name != null && (!(name = name.replace(" ", "")).isEmpty())) {
            for (Group pushGroup : Group.values()) {
                if (pushGroup.getName().equalsIgnoreCase(name)) {
                    result = pushGroup;
                    break;
                }
            }
        }
        return result;
    }

    /**
     * make validation by push group id
     *
     * @param id push group id
     * @return validation status
     */
    public final boolean validation(int id) {
        return getPushGroupById(id) != null;
    }

    /**
     * make validation by push group name
     *
     * @param name push group name
     * @return validation status
     */
    public final boolean validation(String name) {
        return getPushGroupByName(name) != null;
    }
}
