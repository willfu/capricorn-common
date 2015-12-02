package com.caishi.capricorn.common.remote.result;

import com.caishi.capricorn.common.remote.constants.OperationStatus;
import com.caishi.capricorn.common.remote.model.OperationResult;

import java.io.PrintWriter;
import java.io.Serializable;
import java.io.StringWriter;
import java.util.Date;
import java.util.UUID;

public class ServiceResult<T> implements Serializable {

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

    private Exception exception;

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        setRequestEndTime(new Date().getTime());
        this.result = result;
    }

    /**
     * 接口调用成功，不需要返回对象
     */
    public static <T> ServiceResult<T> newSuccess(){
        ServiceResult<T> result = new ServiceResult<>();
        return result;
    }

    /**
     * 接口调用成功，有返回对象
     */
    public static <T> ServiceResult<T> newSuccess(T object) {
        ServiceResult<T> result = new ServiceResult<>();
        result.setResult(object);
        return result;
    }

    /**
     * 接口调用失败，有错误码和描述，没有返回对象
     * 注：由于Operation
     */
    public static <T> ServiceResult<T> newFailure(OperationStatus status, String message){
        ServiceResult<T> result = new ServiceResult<>();
        result.setOperationResult(new OperationResult(status, message));
        return result;
    }

    /**
     * 接口调用失败，返回异常信息
     */
    public static <T> ServiceResult<T> newException(Exception e){
        ServiceResult<T> result = new ServiceResult<>();
        result.setOperationResult(new OperationResult(OperationStatus.ERROR, "Internal Server Error"));
        result.setException(e);
        return result;
    }

    /** 判断返回结果是否成功 */
    public boolean success() {
        return OperationStatus.SUCC == this.operationResult.getStatus();
    }
    /** 判断返回结果是否有结果对象 */
    public boolean hasObject() {
        return OperationStatus.SUCC == this.operationResult.getStatus() && result != null;
    }
    /** 判断返回结果是否有异常 */
    public boolean hasException() {
        return exception != null;
    }

    public void setException(Exception exception) {
        this.exception = exception;
    }

    public String toString() {
        StringBuilder serviceResult = new StringBuilder("ServiceResult");
        if(result != null) {
            serviceResult.append("<" + result.getClass().getSimpleName() + ">");
        }

        serviceResult.append(": {code=" + operationResult.getStatus().getStatus());
        if(result != null) {
            serviceResult.append(", object=" + result);
        }

        if(operationResult.getMsg() != null) {
            serviceResult.append(", message=" + operationResult.getMsg());
        }

        if(exception!=null) {
            StringWriter stringWriter = new StringWriter();
            exception.printStackTrace(new PrintWriter(stringWriter));
            serviceResult.append(", exception=" + stringWriter.toString());
        }
        serviceResult.append(" }");
        return serviceResult.toString();
    }
}
