package com.xiaobao.exception;

public class SysExcption extends Exception {
    private String message;

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public SysExcption(String message) {
        this.message = message;
    }
}
