package com.caishi.capricorn.common.push.constants;

public enum PlatForm {

    /**
     * 苹果平台
     */
    IOS(1, "IOS", "苹果平台"),

    /**
     * 安卓平台
     */
    ANDROID(2, "ANDROID", "安卓平台");

    /**
     * constructors
     *
     * @param id          platform id
     * @param name        platform name
     * @param description platform description
     */
    PlatForm(int id, String name, String description) {
        setId(id);
        setName(name);
        setDescription(description);
    }

    /**
     * platform id
     */
    private int id;

    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    /**
     * platform name
     */
    private String name;

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    /**
     * platform description
     */
    private String description;

    public String getDescription() {
        return description;
    }

    private void setDescription(String description) {
        this.description = description;
    }

    /**
     * get platform info by platform id
     *
     * @param id platform id
     * @return platform info
     */
    public final static PlatForm getPlatFormById(int id) {
        if (id >= 1 && id <= 2) {
            for (PlatForm platForm : PlatForm.values()) {
                if (platForm.getId() == id) {
                    return platForm;
                }
            }
        }
        return null;
    }

    /**
     * get platform info by platform name
     *
     * @param name platform name
     * @return platform info
     */
    public final static PlatForm getPlatFormByName(String name) {
        if (name != null && !((name = name.replace(" ", "")).isEmpty())) {
            for (PlatForm platForm : PlatForm.values()) {
                if (platForm.getName().equalsIgnoreCase(name)) {
                    return platForm;
                }
            }
        }
        return null;
    }

    /**
     * make validation by platform id
     *
     * @param id platform id
     * @return platform info
     */
    public final static boolean validation(int id) {
        return getPlatFormById(id) != null;
    }

    /**
     * make validation by platform name
     *
     * @param name platform name
     * @return platform info
     */
    public final static boolean validation(String name) {
        return getPlatFormByName(name) != null;
    }
}