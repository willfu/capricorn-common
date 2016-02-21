package com.caishi.capricorn.common.base;

public enum ModuleRuntimeType {

    /**
     * 积分系统运行状态
     */
    MRT001("001", "MRT001", "积分系统运行状态"),

    /**
     * 兑换系统运行状态
     */
    MRT002("002", "MRT002", "兑换系统运行状态");

    /**
     * constructors
     *
     * @param id          id
     * @param name        name
     * @param description description
     */
    ModuleRuntimeType(String id, String name, String description) {
        setId(id);
        setName(name);
        setDescription(description);
    }

    /**
     * id
     */
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    /**
     * name
     */
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * key
     */
    private String key = "module:runtime";

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    /**
     * description
     */
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * get module runtime type by id
     *
     * @param id id
     * @return module runtime type
     */
    public final static ModuleRuntimeType getById(String id) {
        if (id != null && !(id = id.replace(" ", "")).isEmpty()) {
            for (ModuleRuntimeType moduleRuntimeType : ModuleRuntimeType.values()) {
                if (moduleRuntimeType.getId().equalsIgnoreCase(id)) {
                    return moduleRuntimeType;
                }
            }
        }
        return null;
    }

    /**
     * get module runtime type by name
     *
     * @param name name
     * @return module runtime type
     */
    public final static ModuleRuntimeType getByName(String name) {
        if (name != null && !(name = name.replace(" ", "")).isEmpty()) {
            for (ModuleRuntimeType moduleRuntimeType : ModuleRuntimeType.values()) {
                if (moduleRuntimeType.getName().equalsIgnoreCase(name)) {
                    return moduleRuntimeType;
                }
            }
        }
        return null;
    }

    /**
     * make validation by id
     *
     * @param id id
     * @return validation result status
     */
    public final static boolean validationById(String id) {
        return getById(id) != null;
    }

    /**
     * make validation by name
     *
     * @param name name
     * @return validation result status
     */
    public final static boolean validationByName(String name) {
        return getByName(name) != null;
    }
}