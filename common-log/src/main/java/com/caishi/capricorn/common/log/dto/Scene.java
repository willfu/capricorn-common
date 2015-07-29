package com.caishi.capricorn.common.log.dto;

import com.caishi.capricorn.common.scene.MetaData.ReferentType;

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
     * 数据校验
     * @return 数据校验结果
     */
    public boolean makeValidation() {
        boolean status = super.makeValidation();
        if (status) {
            status = sceneId > 0;
            if (status) {
                status = referentType != null;
            }
        }
        return status;
    }
}
