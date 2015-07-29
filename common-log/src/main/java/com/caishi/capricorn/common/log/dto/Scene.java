package com.caishi.capricorn.common.log.dto;

import com.caishi.capricorn.common.news.meta.ParentType;
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
     * 父本类型
     */
    private ParentType referentType;

    public ParentType getReferentType() {
        return referentType;
    }

    public void setReferentType(ParentType referentType) {
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
