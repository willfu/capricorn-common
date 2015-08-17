package com.caishi.capricorn.common.log.dto.news;

public class NewsDetailShareLogger extends NewsLogger {

    /**
     * 第三方账户类型ID
     */
    private String partnerTypeId;

    public String getPartnerTypeId() {
        return partnerTypeId;
    }

    public void setPartnerTypeId(String partnerTypeId) {
        this.partnerTypeId = partnerTypeId;
    }

    /**
     * 第三方账户分享范围
     */
    private String partnerScopeId;

    public String getPartnerScopeId() {
        return partnerScopeId;
    }

    public void setPartnerScopeId(String partnerScopeId) {
        this.partnerScopeId = partnerScopeId;
    }
}
