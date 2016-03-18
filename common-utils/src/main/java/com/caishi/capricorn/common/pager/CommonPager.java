package com.caishi.capricorn.common.pager;

import java.io.Serializable;
import java.util.List;

/**
 * Created by syzz on 2016/3/15.
 */
public class CommonPager<T> implements Serializable {

    /** total count */
    private long totalCount = 0;

    /** data */
    private List<T> data = null;

    public long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
