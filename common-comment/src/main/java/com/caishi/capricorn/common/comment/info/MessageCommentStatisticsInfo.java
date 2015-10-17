package com.caishi.capricorn.common.comment.info;

import com.alibaba.fastjson.annotation.JSONField;
import java.io.Serializable;

public class MessageCommentStatisticsInfo implements Serializable {

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
     * message type
     */
    private String messageType;

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    /**
     * comments total count
     */
    private long totalCount = 0;

    public long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
    }

    /**
     * top comments count
     */
    private int topCount = 0;

    public int getTopCount() {
        return topCount;
    }

    public void setTopCount(int topCount) {
        this.topCount = topCount;
    }

    /**
     * picked comments count
     */
    private int pickedCount = 0;

    public int getPickedCount() {
        return pickedCount;
    }

    public void setPickedCount(int pickedCount) {
        this.pickedCount = pickedCount;
    }

    /**
     * hot comments count
     */
    private int hotCount = 0;

    public int getHotCount() {
        return hotCount;
    }

    public void setHotCount(int hotCount) {
        this.hotCount = hotCount;
    }
}