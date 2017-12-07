package com.chltec.http;

/**
 * Author joker
 * Created on 2017/10/27.
 * Description
 */
public class Response {
    private Integer err_code;
    private String err_msg;
    private Object result;

    public Integer getErr_code() {
        return err_code;
    }

    public void setErr_code(Integer err_code) {
        this.err_code = err_code;
    }

    public String getErr_msg() {
        return err_msg;
    }

    public void setErr_msg(String err_msg) {
        this.err_msg = err_msg;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "Response{" +
                "err_code=" + err_code +
                ", err_msg='" + err_msg + '\'' +
                ", result=" + result +
                '}';
    }
}
