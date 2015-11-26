package com.caishi.capricorn.common.kafka.message.template;

import com.caishi.capricorn.common.kafka.message.event.ChannelEventType;

import java.util.Date;

public class ChannelTemplate {

    /**
     * channel event type
     */
    private ChannelEventType event;

    public ChannelEventType getEvent() {
        return event;
    }

    public void setEvent(ChannelEventType event) {
        this.event = event;
    }

    /**
     * data source
     */
    private Object dataSource;

    public Object getDataSource() {
        return dataSource;
    }

    public void setDataSource(Object dataSource) {
        this.dataSource = dataSource;
    }

    /**
     * create time
     */
    private Long createTime = new Date().getTime();

    public Long getCreateTime() {
        return createTime;
    }

    private void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }
}