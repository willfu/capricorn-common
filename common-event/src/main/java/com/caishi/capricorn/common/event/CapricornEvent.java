package com.caishi.capricorn.common.event;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by humphrey.han@9icaishi.net on 15/12/9.
 */
public class CapricornEvent<T extends AbstractEvent> implements Serializable {
    private static final long serialVersionUID = 4919062422286104624L;

    /**
     * time at which the event was created
     */
    private Date createTime;
    /**
     * time at which the event was last updated
     */
    private Date updateTime;
    /**
     * time at which the event expires
     */
    private Date expireTime;
    /**
     * time the event is queued (send to queue in async mode)
     */
    private long queuingTime;

    /**
     * event data
     */
    private List<T> events;

    public CapricornEvent() {
        this.createTime = new Date();
    }

    public CapricornEvent(T event) {
        this();
        this.events = new LinkedList<T>();
        this.events.add(event);
    }

    public CapricornEvent(List<T> events) {
        this();
        this.events = events;
    }

    public T getEvent() {
        if (null != events && events.size() > 0) {
            return events.get(0);
        }

        return null;
    }

    public List<T> getEvents() {
        return events;
    }

    public void setEvent(T event) {
        if (null == this.events) {
            this.events = new LinkedList<>();
        }

        this.events.add(event);
    }

    public void setEvent(List<T> events) {
        this.events = events;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Date expireTime) {
        this.expireTime = expireTime;
    }

    public long getQueuingTime() {
        return queuingTime;
    }

    public void setQueuingTime(long queuingTime) {
        this.queuingTime = queuingTime;
    }

    @Override
    public String toString() {
        return "CapricornEvent { createTime:" + createTime +
                ", queuingTime:" + queuingTime +
                ", Data:" + events;
    }
}
