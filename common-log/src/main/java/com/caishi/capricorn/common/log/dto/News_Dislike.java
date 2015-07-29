package com.caishi.capricorn.common.log.dto;

public class News_Dislike extends News {

    /**
     * 数据校验
     * @return 数据校验结果
     */
    public boolean makeValidation(){
        boolean status = super.makeValidation();
        return status;
    }
}
