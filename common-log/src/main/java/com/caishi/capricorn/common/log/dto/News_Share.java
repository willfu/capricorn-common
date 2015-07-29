package com.caishi.capricorn.common.log.dto;

import com.caishi.capricorn.common.login.data.PartnerType;
import com.caishi.capricorn.common.news.meta.ParentType;

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
     * 数据校验
     * @return 数据校验结果
     */
    public boolean makeValidation(){
        boolean status = super.makeValidation();
        if (status){
            status = shareLink!=null&&shareLink.length()>0;
            if(status){
                status = PartnerType.validation(partnerTypeId);
            }
        }
        return status;
    }
}
