package com.caishi.capricorn.common.pager;

import java.io.Serializable;
import java.util.List;

/**
 * Created by syzz on 2016/3/15.
 */
public class CommonPager<T> implements Serializable {

    /** 第几页 */
    private Integer pageIndex = 0;

    /** 每页数量 */
    private Integer pageSize = 20;

    /** total count */
    private long totalCount = 0;

    /** data */
    private List<T> data = null;

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

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
