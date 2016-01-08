package com.caishi.capricorn.common.news.dto;

import com.caishi.capricorn.common.base.MessageType;
import com.caishi.capricorn.common.news.meta.LayoutType;
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
    private String parentId;

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
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
     * webp图片集合
     */
    private List<NewsImageInfo> webpImageInfoList = new ArrayList<>();

    public List<NewsImageInfo> getWebpImageInfoList() {
        return webpImageInfoList;
    }

    public void setWebpImageInfoList(List<NewsImageInfo> webpImageInfoList) {
        this.webpImageInfoList = webpImageInfoList;
    }

    /**
     * 类型编号
     */
    private MessageType newsType;

    public MessageType getNewsType() {
        return newsType;
    }

    public void setNewsType(MessageType newsType) {
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
    public Map<String, Object> paraMap = new HashMap<String, Object>();

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NewsSummaryInfo that = (NewsSummaryInfo) o;
        return !(newsId != null ? !newsId.equals(that.newsId) : that.newsId != null);
    }

    @Override
    public int hashCode() {
        return newsId != null ? newsId.hashCode() : 0;
    }

    /**
     * 是否原网站展示
     */

    private boolean srcDisplay = false;

    public boolean isSrcDisplay() {
        return srcDisplay;
    }

    public void setSrcDisplay(boolean srcDisplay) {
        this.srcDisplay = srcDisplay;
    }

    /**
     * 原网站链接地址
     */
    private String srcLink;

    public String getSrcLink() {
        return srcLink;
    }

    public void setSrcLink(String srcLink) {
        this.srcLink = srcLink;
    }


    /**
     * 评论状态
     */
    private String commentLevel = "GENERAL";

    public String getCommentLevel() {
        return commentLevel;
    }

    public void setCommentLevel(String commentLevel) {
        this.commentLevel = commentLevel;
    }

    /**
     * origin
     */
    private String origin;

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    /**
     * origin link
     */
    private String originLink;

    public String getOriginLink() {
        return originLink;
    }

    public void setOriginLink(String originLink) {
        this.originLink = originLink;
    }
}