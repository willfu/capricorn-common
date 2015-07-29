package com.caishi.capricorn.common.log.dto;

import com.caishi.capricorn.common.news.meta.NewsType;
import com.caishi.capricorn.common.news.meta.ParentType;

public class News extends Basic {

    /**
     * 新闻ID
     */
    private String newsId;

    public String getNewsId() {
        return newsId;
    }

    public void setNewsId(String newsId) {
        this.newsId = newsId;
    }

    /**
     * 父本类型
     */
    public ParentType parentType;

    public ParentType getParentType() {
        return parentType;
    }

    public void setParentType(ParentType parentType) {
        this.parentType = parentType;
    }

    /**
     * 父本ID
     */
    private int parentId;

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    /**
     * 新闻类型
     */
    public NewsType newsType;

    public NewsType getNewsType() {
        return newsType;
    }

    public void setNewsType(NewsType newsType) {
        this.newsType = newsType;
    }

    /**
     * 数据校验
     * @return 数据校验结果
     */
    public boolean makeValidation(){
        boolean status=super.makeValidation();
        if(status){
            status=newsId!=null&&newsId.length()>0;
            if(status){
                status = parentType!=null;
                if(status){
                    status=parentId>0;
                    if(status){
                        status=newsType!=null;
                    }
                }
            }
        }
        return status;
    }
}
