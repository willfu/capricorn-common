package com.caishi.capricorn.common.base;

public enum ScopeType {
    /**
     * LIU_DA
     */
    LIU_DA(1, "LIU_DA", "Liuda", "溜达资讯"),

    /**
     * WU_LI
     */
    WU_LI(2, "WU_LI", "Wuli", "唔哩资讯");

    /**
     * constructors
     *
     * @param id          scope type id
     * @param name        scope type name
     * @param description scope type description
     */
    ScopeType(int id, String name, String identified, String description) {
        setId(id);
        setName(name);
        setIdentified(identified);
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
     * identified
     */
    private String identified;

    public String getIdentified() {
        return identified;
    }

    public void setIdentified(String identified) {
        this.identified = identified;
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
     * get scope type info by scope type identified
     *
     * @param identified identified
     * @return scope type info
     */
    public final static ScopeType getScopeTypeByIdentified(String identified) {
        if (identified != null && !(identified = identified.replace(" ", "")).isEmpty()) {
            for (ScopeType scopeType : ScopeType.values()) {
                if (scopeType.getIdentified().equalsIgnoreCase(identified)) {
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
    public final static boolean validationById(int id) {
        return getScopeTypeById(id) != null;
    }

    /**
     * validation by scope type name
     *
     * @param name scope type name
     * @return validation status
     */
    public final static boolean validationByName(String name) {
        return getScopeTypeByName(name) != null;
    }

    /**
     * validation by scope type identified
     *
     * @param identified identified
     * @return validation status
     */
    public final static boolean validationByIdentified(String identified) {
        return getScopeTypeByIdentified(identified) != null;
    }
}