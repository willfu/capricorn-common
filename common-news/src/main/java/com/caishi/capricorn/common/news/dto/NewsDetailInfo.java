package com.caishi.capricorn.common.news.dto;

import com.caishi.capricorn.common.base.MessageType;

import java.util.*;

public class NewsDetailInfo {

    /**
     * 编号
     */
    private String newsId;

    public String getNewsId() {
        return newsId;
    }

    public void setNewsId(String newsId) {
        this.newsId = newsId;
    }


    /**
     * 消息类型
     */
    private MessageType messageType = MessageType.NEWS;

    public MessageType getMessageType() {
        return messageType;
    }

    public void setMessageType(MessageType messageType) {
        this.messageType = messageType;
    }

    /**
     * 标题
     */
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 简述
     */
    private String summary;

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    /**
     * 内容
     */
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 图片
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
     * 视频
     */

    private List<VideoDetailInfo> videoInfoList = new ArrayList<>();

    public List<VideoDetailInfo> getVideoInfoList() {
        return videoInfoList;
    }

    public void setVideoInfoList(List<VideoDetailInfo> videoInfoList) {
        this.videoInfoList = videoInfoList;
    }

    /**
     * 连接
     */
    private String shareUrl;

    public String getShareUrl() {
        return shareUrl;
    }

    public void setShareUrl(String shareUrl) {
        this.shareUrl = shareUrl;
    }

    /**
     * 来源
     */
    private String source;

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
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
     * 入库时间
     */
    private long createTime;

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }


    /**
     * 收藏状态
     */
    private int collectStatus;

    public int getCollectStatus() {
        return collectStatus;
    }

    public void setCollectStatus(int collectStatus) {
        this.collectStatus = collectStatus;
    }

    /**
     * 调试信息
     */
    private Map<String, Object> debugInfo = new HashMap<String, Object>();

    public Map<String, Object> getDebugInfo() {
        return debugInfo;
    }

    public void setDebugInfo(Map<String, Object> debugInfo) {
        this.debugInfo = debugInfo;
    }

    /**
     * 分类信息
     */
    private String categoryIds;

    public String getCategoryIds() {
        return categoryIds;
    }

    public void setCategoryIds(String categoryIds) {
        this.categoryIds = categoryIds;
    }

    /**
     * 原文链接
     */
    private String srcLink;

    public String getSrcLink() {
        return srcLink;
    }

    public void setSrcLink(String srcLink) {
        this.srcLink = srcLink;
    }

    /**
     * 原文类型
     */
    private String sourceType = "APP";

    public String getSourceType() {
        return sourceType;
    }

    public void setSourceType(String sourceType) {
        this.sourceType = sourceType;
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
     * news relevance info collection
     */
    private Collection<NewsRelevanceInfo> newsRelevanceInfoCollection = new ArrayList<>();

    public Collection<NewsRelevanceInfo> getNewsRelevanceInfoCollection() {
        return newsRelevanceInfoCollection;
    }

    public void setNewsRelevanceInfoCollection(Collection<NewsRelevanceInfo> newsRelevanceInfoCollection) {
        this.newsRelevanceInfoCollection = newsRelevanceInfoCollection;
    }
}