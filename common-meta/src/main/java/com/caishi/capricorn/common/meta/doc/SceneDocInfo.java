package com.caishi.capricorn.common.meta.doc;


public class SceneDocInfo extends DocMeta {

    /**
     * scene id
     */
    private int sceneId;

    public int getSceneId() {
        return sceneId;
    }

    public void setSceneId(int sceneId) {
        this.sceneId = sceneId;
    }

    /**
     * display position
     */
    private String position;

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    /**
     * sort
     */
    private int sort;

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    /**
     * dynamic display interval (seconds)
     */
    private int timeInterval;

    public int getTimeInterval() {
        return timeInterval;
    }

    public void setTimeInterval(int timeInterval) {
        this.timeInterval = timeInterval;
    }
}