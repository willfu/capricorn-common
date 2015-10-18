package com.caishi.capricorn.common.comment.info;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MessageCommentReferenceInfo implements Serializable {

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