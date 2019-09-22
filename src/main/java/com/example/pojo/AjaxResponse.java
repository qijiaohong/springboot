package com.example.pojo;

public class AjaxResponse {
    private ResponseStatus status;
    private String msg;

    public ResponseStatus getStatus() {
        return status;
    }

    public void setStatus(ResponseStatus status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public AjaxResponse(ResponseStatus status) {
        this.status = status;
    }

    public AjaxResponse(ResponseStatus status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public enum ResponseStatus{
        SUCCESS,FAIL
    }
}
