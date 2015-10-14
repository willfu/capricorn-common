package com.caishi.capricorn.common.comment.info;

import java.util.ArrayList;
import java.util.List;

public class MessageCommentStatisticsInfo {

    /**
     * mongoDb _id
     */
    private String _id;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
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
     * top comments collection
     */
    private List<MessageCommentInfo> messageTopCommentInfoList = new ArrayList<MessageCommentInfo>();

    public List<MessageCommentInfo> getMessageTopCommentInfoList() {
        return messageTopCommentInfoList;
    }

    public void setMessageTopCommentInfoList(List<MessageCommentInfo> messageTopCommentInfoList) {
        this.messageTopCommentInfoList = messageTopCommentInfoList;
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
     * picked comments collection
     */
    private List<MessageCommentInfo> messagePickedCommentInfoList = new ArrayList<MessageCommentInfo>();

    public List<MessageCommentInfo> getMessagePickedCommentInfoList() {
        return messagePickedCommentInfoList;
    }

    public void setMessagePickedCommentInfoList(List<MessageCommentInfo> messagePickedCommentInfoList) {
        this.messagePickedCommentInfoList = messagePickedCommentInfoList;
    }
}
