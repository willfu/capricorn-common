package com.caishi.capricorn.common.news.dto;

import com.caishi.capricorn.common.news.meta.LayoutType;

import java.util.ArrayList;
import java.util.List;

public class LayoutInfo {

    /**
     * 版式类型
     */
    private LayoutType layoutType;

    public LayoutType getLayoutType() {
        return layoutType;
    }

    public void setLayoutType(LayoutType layoutType) {
        this.layoutType = layoutType;
    }

    /**
     * 新闻列表
     */
    private List<NewsSummaryInfo> newsSummaryInfoList = new ArrayList<NewsSummaryInfo>();

    public List<NewsSummaryInfo> getNewsSummaryInfoList() {
        return newsSummaryInfoList;
    }

    public void setNewsSummaryInfoList(List<NewsSummaryInfo> newsSummaryInfoList) {
        this.newsSummaryInfoList = newsSummaryInfoList;
    }
}
