package com.caishi.capricorn.common.message.dto;

import java.util.HashMap;
import java.util.Map;

public class MessageSummaryDto extends MessageBaseDto {

    /**
     * message data source
     */
    private Map<String,Object> dataSource = new HashMap<>();

    public Map<String, Object> getDataSource() {
        return dataSource;
    }

    public void setDataSource(Map<String, Object> dataSource) {
        this.dataSource = dataSource;
    }
}