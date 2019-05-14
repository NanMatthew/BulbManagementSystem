package com.sicnu.bulb.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Created by HY
 * 2019/5/14 11:15
 * <p>
 * 操作日志
 */
@SuppressWarnings("unused")
public class OperationLog {

    private String requestIp;

    /**
     * 请求操作所属Controller
     */
    private String requestController;

    /**
     * 请求操作方法名
     */
    private String requestMethod;

    private String methodDescription;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date requestTime;


    public OperationLog() {
        this.requestTime = new Date();
    }

    public String getRequestIp() {
        return requestIp;
    }

    public void setRequestIp(String requestIp) {
        this.requestIp = requestIp;
    }

    public String getRequestController() {
        return requestController;
    }

    public void setRequestController(String requestController) {
        this.requestController = requestController;
    }

    public String getRequestMethod() {
        return requestMethod;
    }

    public void setRequestMethod(String requestMethod) {
        this.requestMethod = requestMethod;
    }

    public Date getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(Date requestTime) {
        this.requestTime = requestTime;
    }

    public String getMethodDescription() {
        return methodDescription;
    }

    public void setMethodDescription(String methodDescription) {
        this.methodDescription = methodDescription;
    }

    @Override
    public String toString() {
        return "OperationLog{" +
                "requestIp='" + requestIp + '\'' +
                ", requestMethod='" + requestMethod + '\'' +
                ", methodDescription='" + methodDescription + '\'' +
                '}';
    }
}
