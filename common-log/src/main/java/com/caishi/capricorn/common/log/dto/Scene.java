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
    private ParentType parentType;

    public ParentType getParentType() {
        return parentType;
    }

    public void setParentType(ParentType parentType) {
        this.parentType = parentType;
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
                status = parentType != null;
            }
        }
        return status;
    }
}
