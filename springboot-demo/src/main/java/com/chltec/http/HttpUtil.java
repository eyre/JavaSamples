package com.chltec.http;

/**
 * Author joker
 * Created on 2017/10/27.
 * Description
 */
public class HttpUtil {

    public static Response respondSuccess() {
        Response response = new Response();
        response.setErr_code(0);
        response.setErr_msg("success");
        response.setResult(null);
        return response;
    }

    public static Response respondSuccess(Object result) {
        Response response = new Response();
        response.setErr_code(0);
        response.setErr_msg("success");
        response.setResult(result);
        return response;
    }

    public static Response respondFail(int err_code, String err_msg) {
        Response response = new Response();
        response.setErr_code(err_code);
        response.setErr_msg(err_msg);
        response.setResult(null);
        return response;
    }
}
