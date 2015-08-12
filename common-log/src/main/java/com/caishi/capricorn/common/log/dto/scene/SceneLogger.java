package com.caishi.capricorn.common.log.dto.scene;

import com.caishi.capricorn.common.scene.MetaData.ReferentType;

public class SceneLogger {

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
     * 来源类型
     */
    private ReferentType referentType;

    public ReferentType getReferentType() {
        return referentType;
    }

    public void setReferentType(ReferentType referentType) {
        this.referentType = referentType;
    }

    /**
     * 来源编号
     */
    private String referentId;

    public String getReferentId() {
        return referentId;
    }

    public void setReferentId(String referentId) {
        this.referentId = referentId;
    }
}
