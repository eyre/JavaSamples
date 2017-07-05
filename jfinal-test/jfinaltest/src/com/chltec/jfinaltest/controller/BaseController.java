package com.chltec.jfinaltest.controller;

import com.jfinal.core.Controller;
import com.jfinal.kit.LogKit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Author joker
 * Created on 2016/5/26.
 * Description
 */
public class BaseController extends Controller {
    private static final Logger logger = LoggerFactory.getLogger(BaseController.class);
    /**
     * 获取当前用户对象
     * @return
     */
//    protected User getUser() {
//        String token = getRequest().getHeader("token");
//        if(StringUtils.isEmpty(token) ){
//            logger.error("user is null ,token:", token);
//            return null;
//        }else{
//            return UserService.findByAccessToken(token);
//        }
//    }

    public void respond(int err_code, Object result){
        getResponse().setHeader("uri",getRequest().getRequestURI());
        if(err_code != Response.RESPOND_SUCCESS){
            LogKit.warn("err_code:"+err_code+",uri:"+getRequest().getRequestURI());
        }
        Response response = Response.buildResponse(err_code,result);
        renderJson(response);
    }

    public void respond(int err_code){
        getResponse().setHeader("uri",getRequest().getRequestURI());
        if(err_code != Response.RESPOND_SUCCESS){
            LogKit.warn("err_code:"+err_code+",uri:"+getRequest().getRequestURI());
        }
        Response response = Response.buildResponse(err_code);
        renderJson(response);
    }

    public void respond(Object result){
        respond(Response.RESPOND_SUCCESS,result);
    }

    /**
     * 响应接口不存在*
     */
    public void respond404() {
        respond(Response.RESPOND_SOURCE_NOT_FOUND);
    }

    /**
     * 响应请求参数有误*
     */
    public void respondArgumentError() {
        respond(Response.RESPOND_REQUEST_VALIDATOR_FAIL);
    }

    /**
     * 响应操作成功*
     */
    public void respondSuccess() {
        respond(Response.RESPOND_SUCCESS);
    }

    /**
     * 响应操作成功*
     * @param message 响应信息
     */
    public void respondSuccess(Object message) {
        respond(Response.RESPOND_SUCCESS,message);
    }

    /**
     * 响应操作失败*
     * @param message 响应信息
     */
    public void respondFailed(Object message) {
        respond(Response.RESPOND_REQUEST_OPERATE_FAIL,message);
    }

}
