package com.caishi.capricorn.common.event;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by humphrey.han@9icaishi.net on 15/12/9.
 */
public class CapricornEvent<T extends AbstractEvent> implements Serializable {
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

    public CapricornEvent() {
        this.createTime = new Date();
    }
}
