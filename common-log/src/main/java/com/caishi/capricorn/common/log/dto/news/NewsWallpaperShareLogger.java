package com.caishi.capricorn.common.log.dto.news;


public class NewsWallpaperShareLogger extends NewsLogger {

    /**
     * 模版编号
     */
    private int wallpaperId;

    public int getWallpaperId() {
        return wallpaperId;
    }

    public void setWallpaperId(int wallpaperId) {
        this.wallpaperId = wallpaperId;
    }

    /**
     * 作者
     */
    private String author;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
