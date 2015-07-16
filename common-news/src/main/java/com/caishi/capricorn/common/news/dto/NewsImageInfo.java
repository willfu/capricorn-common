package com.caishi.capricorn.common.news.dto;

public class NewsImageInfo {

    /**
     * 图片索引关键字
     */
    private String key;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    /**
     * 是否为GIF图片
     */
    private boolean isGif;

    public boolean isGif() {
        return isGif;
    }

    public void setIsGif(boolean isGif) {
        this.isGif = isGif;
    }

    /**
     * 预览地址
     */
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 原始地址
     */
    private String src;

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    /**
     * 宽度
     */
    private double width;

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    /**
     * 高度
     */
    private double height;

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
}
