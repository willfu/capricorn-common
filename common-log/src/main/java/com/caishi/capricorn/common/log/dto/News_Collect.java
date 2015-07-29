package com.caishi.capricorn.common.log.dto;

public class News_Collect extends News {

    /**
     * true:添加收藏，false:取消收藏
     */
    private boolean isCollect;

    public boolean isCollect() {
        return isCollect;
    }

    public void setIsCollect(boolean isCollect) {
        this.isCollect = isCollect;
    }

    /**
     * 数据校验
     * @return 数据校验结果
     */
    public boolean makeValidation(){
        boolean status = super.makeValidation();
        return status;
    }
}
