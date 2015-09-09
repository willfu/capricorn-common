package com.caishi.capricorn.common.base;

public enum SourceType {
    /**
     * WEB 站点
     */
    WEB(1),

    /**
     * APP 应用
     */
    APP(2);

    private int type;

    SourceType(int type) {
        this.type = type;
    }

    public int getType() {
        return this.type;
    }
}
