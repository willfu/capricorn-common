package com.caishi.capricorn.common.log.dto;

import com.caishi.capricorn.common.social.meta.InteractType;

public class News_Interact extends News {

    /**
     * 交互类型
     */
    private InteractType interactType;

    public InteractType getInteractType() {
        return interactType;
    }

    public void setInteractType(InteractType interactType) {
        this.interactType = interactType;
    }

    /**
     * 数据校验
     * @return 数据校验结果
     */
    public boolean makeValidation(){
        boolean status = super.makeValidation();
        if(status){
            status = interactType!=null;
        }
        return status;
    }
}
