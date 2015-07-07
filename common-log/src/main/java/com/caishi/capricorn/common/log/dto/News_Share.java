package com.caishi.capricorn.common.log.dto;

public class News_Share extends News {

    /**
     * 分享连接
     */
    private String shareLink;

    public String getShareLink() {
        return shareLink;
    }

    public void setShareLink(String shareLink) {
        this.shareLink = shareLink;
    }

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
     * 第三方账户类型名称
     */
    private String partnerTypeName;

    public String getPartnerTypeName() {
        return partnerTypeName;
    }

    public void setPartnerTypeName(String partnerTypeName) {
        this.partnerTypeName = partnerTypeName;
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

    /**
     * 发生时间
     */
    private long createTime;

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }
}
