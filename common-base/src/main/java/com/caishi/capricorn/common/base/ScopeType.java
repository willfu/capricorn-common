package com.caishi.capricorn.common.base;

public enum ScopeType {
    /**
     * LIU_DA
     */
    LIU_DA(1, "LIU_DA", "溜达咨询"),

    /**
     * WU_LI
     */
    WU_LI(2, "WU_LI", "唔哩咨询");

    /**
     * constructors
     *
     * @param id          scope type id
     * @param name        scope type name
     * @param description scope type description
     */
    ScopeType(int id, String name, String description) {
        setId(id);
        setName(name);
        setDescription(description);
    }

    /**
     * scope type id
     */
    private int id;

    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    /**
     * scope type name
     */
    private String name;

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    /**
     * scope type description
     */
    private String description;

    public String getDescription() {
        return description;
    }

    private void setDescription(String description) {
        this.description = description;
    }

    /**
     * get scope type info by scope type id
     *
     * @param id scope type id
     * @return scope type info
     */
    public final static ScopeType getScopeTypeById(int id) {
        for (ScopeType scopeType : ScopeType.values()) {
            if (scopeType.getId() == id) {
                return scopeType;
            }
        }
        return null;
    }

    /**
     * get scope type info by scope type name
     *
     * @param name scope type name
     * @return scope type info
     */
    public final static ScopeType getScopeTypeByName(String name) {
        if (name != null && !(name = name.replace(" ", "")).isEmpty()) {
            for (ScopeType scopeType : ScopeType.values()) {
                if (scopeType.getName().equalsIgnoreCase(name)) {
                    return scopeType;
                }
            }
        }
        return null;
    }

    /**
     * validation by scope type id
     *
     * @param id scope type id
     * @return validation status
     */
    public final static boolean validation(int id) {
        return getScopeTypeById(id) != null;
    }

    /**
     * validation by scope type name
     *
     * @param name scope type name
     * @return validation status
     */
    public final static boolean validation(String name) {
        return getScopeTypeByName(name) != null;
    }
}