package com.caishi.capricorn.common.news.dto;

import com.caishi.capricorn.common.news.meta.LayoutType;
import com.caishi.capricorn.common.news.meta.NewsType;
import com.caishi.capricorn.common.news.meta.ParentType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NewsSummaryInfo {

    /**
     * 父本
     */
    private ParentType parentType;

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
     * 新闻标题
     */
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 图片集合
     */
    private List<NewsImageInfo> newsImageInfoList = new ArrayList<NewsImageInfo>();

    public List<NewsImageInfo> getNewsImageInfoList() {
        return newsImageInfoList;
    }

    public void setNewsImageInfoList(List<NewsImageInfo> newsImageInfoList) {
        this.newsImageInfoList = newsImageInfoList;
    }

    /**
     * 类型编号
     */
    private NewsType newsType;

    public NewsType getNewsType() {
        return newsType;
    }

    public void setNewsType(NewsType newsType) {
        this.newsType = newsType;
    }

    /**
     * 新闻引擎类型
     */
    private String newsSourceType;

    public String getNewsSourceType() {
        return newsSourceType;
    }

    public void setNewsSourceType(String newsSourceType) {
        this.newsSourceType = newsSourceType;
    }

    /**
     * 容器类型
     */
    private LayoutType layoutType;

    public LayoutType getLayoutType() {
        return layoutType;
    }

    public void setLayoutType(LayoutType layoutType) {
        this.layoutType = layoutType;
    }

    /**
     * 发布时间
     */
    private long publishTime;

    public long getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(long publishTime) {
        this.publishTime = publishTime;
    }

    /**
     * 浏览次数
     */
    private long pageView;

    public long getPageView() {
        return pageView;
    }

    public void setPageView(long pageView) {
        this.pageView = pageView;
    }

    /**
     * 分类信息ID集合
     */
    private String categoryIds;

    public String getCategoryIds() {
        return categoryIds;
    }

    public void setCategoryIds(String categoryIds) {
        this.categoryIds = categoryIds;
    }

    /**
     * 新闻简述
     */
    private String summary;

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    /**
     * 附加参数
     */
    public Map<String,Object> paraMap = new HashMap<String,Object>();

    public Map<String, Object> getParaMap() {
        return paraMap;
    }

    public void setParaMap(Map<String, Object> paraMap) {
        this.paraMap = paraMap;
    }

    /**
     * 封面图片索引列表
     */
    private List<Integer> imageIndexCollection = new ArrayList<Integer>();

    public List<Integer> getImageIndexCollection() {
        return imageIndexCollection;
    }

    public void setImageIndexCollection(List<Integer> imageIndexCollection) {
        this.imageIndexCollection = imageIndexCollection;
    }

    /**
     * 新闻详情链接
     */
    private String detailLink;

    public String getDetailLink() {
        return detailLink;
    }

    public void setDetailLink(String detailLink) {
        this.detailLink = detailLink;
    }
}
