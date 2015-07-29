package com.caishi.capricorn.common.log.dto;

import java.util.ArrayList;
import java.util.List;

public class News_View extends News {

    /**
     * 新闻分类列表
     */
    private List<Integer> categoryIdList = new ArrayList<Integer>();

    public List<Integer> getCategoryIdList() {
        return categoryIdList;
    }

    public void setCategoryIdList(List<Integer> categoryIdList) {
        this.categoryIdList = categoryIdList;
    }

    /**
     * 数据校验
     * @return
     */
    public boolean makeValidation(){
        boolean status = super.makeValidation();
        if(status){
            status = categoryIdList.size()>0;
        }
        return status;
    }
}
