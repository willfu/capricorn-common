package com.caishi.capricorn.common.base;

public enum SourceType {
    /**
     * WEB 站点
     */
    WEB(0),

    /**
     * APP 应用
     */
    APP(1);

    private int type;

    SourceType(int type) {
        this.type = type;
    }

    public int getType() {
        return this.type;
    }
}
