package com.caishi.capricorn.common.log.dto;

import com.caishi.capricorn.common.scene.MetaData.SceneType;

public class Scene extends Basic {

    /**
     * 场景ID
     */
    private int sceneId;

    public int getSceneId() {
        return sceneId;
    }

    public void setSceneId(int sceneId) {
        this.sceneId = sceneId;
    }

    /**
     * 场景类型
     */
    private SceneType sceneType;

    public SceneType getSceneType() {
        return sceneType;
    }

    public void setSceneType(SceneType sceneType) {
        this.sceneType = sceneType;
    }

    /**
     * 数据校验
     * @return 数据校验结果
     */
    public boolean makeValidation() {
        boolean status = super.makeValidation();
        if (status) {
            status = sceneId > 0;
            if (status) {
                status = sceneType != null;
            }
        }
        return status;
    }
}
