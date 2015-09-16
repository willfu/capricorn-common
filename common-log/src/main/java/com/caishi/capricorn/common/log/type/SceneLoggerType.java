package com.caishi.capricorn.common.log.type;

public enum SceneLoggerType {

    /**
     * 点击
     */
    CLICK(12001,""),

    /**
     * 穿越
     */
    CROSS(12002,"");


    SceneLoggerType(int id,String name){
        setId(id);
        setName(name);
    }

    /**
     * 编号
     */
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /**
     * 名称
     */
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * 根据编号获取场景日志类型枚举对象
     * @param id 编号
     * @return 场景日志类型枚举对象
     */
    public final static SceneLoggerType getById(int id) {
        SceneLoggerType result = null;
        for (SceneLoggerType sceneLoggerType : SceneLoggerType.values()) {
            if (sceneLoggerType.getId() == id) {
                result = sceneLoggerType;
                break;
            }
        }
        return result;
    }

    /**
     * 根据名称获取场景日志类型枚举对象
     * @param name 名称
     * @return 场景日志类型枚举对象
     */
    public final static SceneLoggerType getByName(String name) {
        SceneLoggerType result = null;
        if (name != null && name.length() > 0) {
            for (SceneLoggerType sceneLoggerType : SceneLoggerType.values()) {
                if (sceneLoggerType.getName().equalsIgnoreCase(name)) {
                    result = sceneLoggerType;
                    break;
                }
            }
        }
        return result;
    }

    /**
     * 根据编号校验场景日志类型枚举对象的合法性
     * @param id 编号
     * @return true(合法) , false(非法)
     */
    public final static boolean validation(int id){
        return getById(id)!=null;
    }

    /**
     * 根据名称校验场景日志类型枚举对象的合法性
     * @param name 名称
     * @return true(合法) , false(非法)
     */
    public final static boolean validation(String name){
        return getByName(name)!=null;
    }
}
