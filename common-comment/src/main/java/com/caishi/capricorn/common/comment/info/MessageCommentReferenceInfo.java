package com.caishi.capricorn.common.comment.info;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MessageCommentReferenceInfo implements Serializable {

    /**
     * mongoDb _id
     */
    @JSONField(name = "_id")
    private String messageId;

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    /**
     * dynamic message comment index collection
     */
    private List<String> messageCommentIdCollection = new ArrayList<String>();

    public List<String> getMessageCommentIdCollection() {
        return messageCommentIdCollection;
    }

    public void setMessageCommentIdCollection(List<String> messageCommentIdCollection) {
        this.messageCommentIdCollection = messageCommentIdCollection;
    }
}