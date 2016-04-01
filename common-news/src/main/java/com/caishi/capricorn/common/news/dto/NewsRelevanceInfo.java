package com.caishi.capricorn.common.news.dto;


import com.caishi.capricorn.common.base.MessageType;

public class NewsRelevanceInfo {

    /**
     * message id
     */
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
    private MessageType messageType;

    public MessageType getMessageType() {
        return messageType;
    }

    public void setMessageType(MessageType messageType) {
        this.messageType = messageType;
    }

    /**
     * message source type
     */
    private String messageSourceType;

    public String getMessageSourceType() {
        return messageSourceType;
    }

    public void setMessageSourceType(String messageSourceType) {
        this.messageSourceType = messageSourceType;
    }
}