package com.caishi.capricorn.common.push.gt.param;

import java.util.List;

public class PushParam {

    /**
     * terminal os type collection(IOS,ANDROID)
     */
    private List<String> plat;

    public List<String> getPlat() {
        return plat;
    }

    public void setPlat(List<String> plat) {
        this.plat = plat;
    }

    /**
     * terminal group name collection (,)
     */
    private List<String> tags;

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
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
}
