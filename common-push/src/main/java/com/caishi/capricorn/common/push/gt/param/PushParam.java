package com.caishi.capricorn.common.push.gt.param;

import com.caishi.capricorn.common.push.constants.Group;
import com.caishi.capricorn.common.push.constants.PlatForm;
import com.caishi.capricorn.common.push.constants.PushStatus;
import com.caishi.capricorn.common.push.constants.PushType;

import java.util.*;

public class PushParam {

    /**
     * push id
     */
    private String pushId = UUID.randomUUID().toString().replace("-", "").toUpperCase();

    public String getPushId() {
        return pushId;
    }

    private void setPushId(String pushId) {
        this.pushId = pushId;
    }

    /**
     * push type
     */
    private PushType pushType;

    public PushType getPushType() {
        return pushType;
    }

    public void setPushType(PushType pushType) {
        this.pushType = pushType;
    }

    /**
     * receiver group
     */
    private Set<Group> groupSet = new HashSet<>();

    public Set<Group> getGroupSet() {
        return groupSet;
    }

    public void setGroupSet(Set<Group> groupSet) {
        this.groupSet = groupSet;
    }

    /**
     * terminal os type collection(IOS,ANDROID)
     */
    private Set<PlatForm> platFormSet = new HashSet<>();

    public Set<PlatForm> getPlatFormSet() {
        return platFormSet;
    }

    public void setPlatFormSet(Set<PlatForm> platFormSet) {
        this.platFormSet = platFormSet;
    }

    /**
     * title
     */
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * summary
     */
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    /**
     * trigger time (seconds)
     */
    private int interval;

    public int getInterval() {
        return interval;
    }

    public void setInterval(int interval) {
        this.interval = interval;
    }

    /**
     * create time
     */
    private Long createTime = new Date().getTime();

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    /**
     * push status
     */
    private PushStatus status = PushStatus.READY;

    public PushStatus getStatus() {
        return status;
    }

    public void setStatus(PushStatus status) {
        this.status = status;
    }


    /**
     * default sound
     */
    private String sound = "default1";

    public String getSound() {
        return sound;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }

    /**
     * push data source
     */
    private Object dataSource;

    public Object getDataSource() {
        return dataSource;
    }

    public void setDataSource(Object dataSource) {
        this.dataSource = dataSource;
    }
}