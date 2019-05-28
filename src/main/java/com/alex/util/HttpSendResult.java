package com.alex.util;

/**
 * Created by chunyan.hcy on 2018/6/25.
 */
public class HttpSendResult {
    private Integer httpCode;
    private String  httpReturnStr;

    public Integer getHttpCode() {
        return httpCode;
    }

    public void setHttpCode(Integer httpCode) {
        this.httpCode = httpCode;
    }

    public String getHttpReturnStr() {
        return httpReturnStr;
    }

    public void setHttpReturnStr(String httpReturnStr) {
        this.httpReturnStr = httpReturnStr;
    }
}
