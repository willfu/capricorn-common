package com.caishi.capricorn.common.pager;

import java.util.List;

/**
 * Created by syzz on 2016/3/15.
 */
public class CommonPager<T> {

    /** total count */
    private Integer totalCount = 0;

    /** data */
    private List<T> data = null;

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
