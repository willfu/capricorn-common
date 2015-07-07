package com.caishi.capricorn.common.log.dto;

public class News_Interact extends News {

    /**
     * 交互选项ID
     */
    private int interactId;

    public int getInteractId() {
        return interactId;
    }

    public void setInteractId(int interactId) {
        this.interactId = interactId;
    }

    /**
     * 交互选项名称
     */
    private String interactName;

    public String getInteractName() {
        return interactName;
    }

    public void setInteractName(String interactName) {
        this.interactName = interactName;
    }
}
