package com.learnwy.response;

import com.sun.org.apache.xpath.internal.operations.Bool;

/**
 * date 2017/9/4
 * create by learnwy
 * lis is GPL-3.0
 */
public class Message {
    private Boolean success;
    private String msg;
    private Object data;
    private static final ErrorMessage errorMessage = new ErrorMessage();
    private static final SuccessMessage successMessage = new SuccessMessage();

    public static Message successMessage() {
        return successMessage;
    }

    public static Message successMessage(String msg) {
        return new SuccessMessage(msg);
    }

    public static Message errorMessage() {
        return errorMessage;
    }

    public static Message errorMessage(String msg) {
        return new ErrorMessage(msg);
    }

    static class SuccessMessage extends Message {
        public SuccessMessage() {
            super(Boolean.TRUE, "成功");
        }

        public SuccessMessage(String msg) {
            super(Boolean.TRUE, msg);
        }
    }


    static class ErrorMessage extends Message {
        public ErrorMessage() {
            super(Boolean.FALSE, "失败");
        }

        public ErrorMessage(String msg) {
            super(Boolean.FALSE, msg);
        }
    }

    public Message() {
    }

    public Message(Boolean success, String msg) {
        this.success = success;
        this.msg = msg;
    }

    public Message(Boolean success, String msg, Object data) {
        this.success = success;
        this.msg = msg;
        this.data = data;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }
}
