package com.caishi.capricorn.common.comment.info;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class MessageCommentHotInfo implements Serializable {

    /**
     * message id {mongoDb _id}
     */
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    /**
     * message comment info mapping
     */
    private Map<String,Integer> messageCommentIdReferenceMap = new HashMap<String,Integer>();

    public Map<String,Integer> getMessageCommentIdReferenceMap() {
        return messageCommentIdReferenceMap;
    }

    public void setMessageCommentIdReferenceMap(Map<String, Integer> messageCommentIdReferenceMap) {
        this.messageCommentIdReferenceMap = messageCommentIdReferenceMap;
    }

    /**
     * create time
     */
    private long createTime = new Date().getTime();

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    /**
     * modifyTime
     */
    private long modifyTime = new Date().getTime();

    public long getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(long modifyTime) {
        this.modifyTime = modifyTime;
    }

}
