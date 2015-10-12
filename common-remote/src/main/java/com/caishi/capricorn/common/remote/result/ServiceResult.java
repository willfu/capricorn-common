package com.caishi.capricorn.common.remote.result;

import com.caishi.capricorn.common.remote.constants.OperationStatus;
import com.caishi.capricorn.common.remote.model.OperationResult;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

public class ServiceResult<T extends Serializable> implements Serializable {

    /**
     *
     */
    private String requestId = UUID.randomUUID().toString();

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }


    /**
     *
     */
    private long requestStartTime = new Date().getTime();

    public long getRequestStartTime() {
        return requestStartTime;
    }

    public void setRequestStartTime(long requestStartTime) {
        this.requestStartTime = requestStartTime;
    }

    /**
     *
     */
    private long requestEndTime;

    public long getRequestEndTime() {
        return requestEndTime;
    }

    public void setRequestEndTime(long requestEndTime) {
        this.requestEndTime = requestEndTime;
    }

    /**
     *
     */
    private OperationResult operationResult = new OperationResult(OperationStatus.SUCC,null);

    public OperationResult getOperationResult() {
        return operationResult;
    }

    public void setOperationResult(OperationResult operationResult) {
        this.operationResult = operationResult;
    }

    /**
     *
     */
    private T result = null;

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        setRequestEndTime(new Date().getTime());
        this.result = result;
    }
}
