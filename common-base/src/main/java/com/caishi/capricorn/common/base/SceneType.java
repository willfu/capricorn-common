package com.caishi.capricorn.common.base;

public enum SceneType {
    /**
     * 晨读
     */
    MORNING(10, "MORNING", "晨读"),

    /**
     * 蹲坑
     */
    PIT(11, "PIT", "蹲坑"),

    /**
     * 奔波
     */
    RUNNING(12, "RUNNING", "奔波"),

    /**
     * 窝着
     */
    HIDE(13, "HIDE", "窝着"),

    /**
     * 偷懒
     */
    LAZY(14, "LAZY", "偷懒"),

    /**
     * 饭点儿
     */
    MEAL(15, "MEAL", "饭点儿"),

    /**
     * 上床
     */
    BED(16, "BED", "上床"),

    /**
     * 夜猫子
     */
    OWL(17, "OWL", "夜猫子");

    /**
     * constructors
     *
     * @param id          scene id
     * @param name        scene name
     * @param description scene description
     */
    SceneType(int id, String name, String description) {
        setId(id);
        setName(name);
        setDescription(description);
    }

    /**
     * scene id
     */
    private int id;

    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    /**
     * scene name
     */
    private String name;

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    /**
     * scene description
     */
    private String description;

    public String getDescription() {
        return description;
    }

    private void setDescription(String description) {
        this.description = description;
    }

    /**
     * get scene type by scene id
     *
     * @param id scene id
     * @return scene type
     */
    public final static SceneType getSceneTypeById(int id) {
        for (SceneType sceneType : SceneType.values()) {
            if (sceneType.getId() == id) {
                return sceneType;
            }
        }
        return null;
    }

    /**
     * get scene type by scene name
     *
     * @param name scene name
     * @return scene type
     */
    public final static SceneType getSceneTypeByName(String name) {
        if (name != null && !name.isEmpty()) {
            for (SceneType sceneType : SceneType.values()) {
                if (sceneType.getName().equalsIgnoreCase(name)) {
                    return sceneType;
                }
            }
        }
        return null;
    }

    /**
     * make validation for scene id
     *
     * @param id scene id
     * @return validation status
     */
    public final static boolean validation(int id) {
        return getSceneTypeById(id) != null;
    }

    /**
     * make validation for scene name
     *
     * @param name scene name
     * @return validation status
     */
    public final static boolean validation(String name) {
        return getSceneTypeByName(name) != null;
    }
}