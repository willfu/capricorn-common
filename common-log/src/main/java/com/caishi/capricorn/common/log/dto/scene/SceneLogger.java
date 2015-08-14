package com.caishi.capricorn.common.log.dto.scene;

import com.caishi.capricorn.common.scene.meta.SceneType;

public class SceneLogger {

    /**
     * 场景ID
     */
    private String sceneId;

    public String getSceneId() {
        return sceneId;
    }

    public void setSceneId(String sceneId) {
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
}
