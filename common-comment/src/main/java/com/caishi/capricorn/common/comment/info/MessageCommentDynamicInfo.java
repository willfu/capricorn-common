package com.caishi.capricorn.common.comment.info;

import java.util.ArrayList;
import java.util.List;

public class MessageCommentDynamicInfo {

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
     * dynamic data source
     */
    private List<MessageCommentInfo> messageCommentInfoList = new ArrayList<MessageCommentInfo>();

    public List<MessageCommentInfo> getMessageCommentInfoList() {
        return messageCommentInfoList;
    }

    public void setMessageCommentInfoList(List<MessageCommentInfo> messageCommentInfoList) {
        this.messageCommentInfoList = messageCommentInfoList;
    }
}
