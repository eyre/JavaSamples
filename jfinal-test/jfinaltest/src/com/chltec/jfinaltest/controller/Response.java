package com.chltec.jfinaltest.controller;

import java.io.Serializable;
import java.util.Hashtable;

/**
 * Author joker
 * Created on 2016/5/26.
 * Description
 */

public class Response implements Serializable {
    int err_code;
    String err_msg;
    Object result;

    public final static int RESPOND_SUCCESS = 0;
    public final static int RESPOND_USER_NOT_REGISTER = 1;
    public final static int RESPOND_USER_REGISTER = 2;
    public final static int RESPOND_REQUEST_VALIDATOR_FAIL = 1000;
    public final static int RESPOND_GET_DATA_FAIL = 1001;
    public final static int RESPOND_REQUEST_OPERATE_FAIL = 1002;
    public final static int RESPOND_TOKEN_NULL_FAIL = 1003;
    public final static int RESPOND_TOKEN_INVALID_FAIL = 1004;
    public final static int ORDER_CONTINUE = 1005;
    public final static int WARNING_DELETE = 1006;
    public final static int WARNING_UPDATE=1009;
    public static final int RESPOND_STATION_NOT_FIND=1007;
    public static final int NOT_FIND_PROFIT_PORVICE=1009;
    public static final int RESPOND_STATION_NAME_NOT_NULL=1008;
    public final static int RESPOND_LOGIN_FAIL = 1100;
    public final static int RESPOND_SMS_SEND_FAIL = 1101;
    public final static int RESPOND_SMS_VERIFY_FAIL = 1102;
    public final static int RESPOND_INVITATION_CODE_FAIL = 1103;
    public final static int RESPOND_CHECK_AUTH_FAIL = 1104;
    public final static int RESPOND_PHONE_NUMBER_EXIST_FAIL = 1105;
    public final static int RESPOND_CAPTCHA_VERIFY_FAIL = 1106;
    public final static int RESPOND_SERVICE_ERROR = 2000; //2000+ service error
    public final static int RESPOND_SOURCE_NOT_FOUND = 2001; //2000+ service error
    public final static int STATION_DELETE=2002;
    public final static int REQUEST_DELETE=2003;
    public final static int REQUEST_SHOW=2004;
    public final static int REQUEST_UPDATE=2005;
    public final static int BIND_FAIL=2006;
    public final static int AGENT_ID_FAIL=2007;//没有加agent_id
    public final static int AGENT_ADD_FAIL=2008;//添加服务商填写信息不完善
    public final static int AGENT_PARA_NULL=2009;//添加服务商信息为空
    public final static int AGENT_ALREADY_ADD_FAIL=2010;//已经添加过该服务商
    public final static int AGENT_DELETE=2011;//代理商删除失败
    public final static int AGENT_GIVE_FAIL=2012;//管理员和二级代理商不能分配电站给其他代理商
    public final static int PARA_NOT_NULL=2013;//年月/position参数不能为空
    public final static int NULL_DATA=2014;//表示没有数据

    public final static int WARNING_ADD=2015;//发电量不正常，添加告警

    public final static int STATION_ALREADY_BIND_USER=2016;//电站已经绑定用户
    public final static int NO_ACCESS=2017;//没有权限

    public final static int INCORRECT_CODE=2018;//非正常扫码，扫码不符合规范


    //初始化Hashtable
    static Hashtable<Integer, String> response_table = new Hashtable<Integer, String>() {
        {
            put(RESPOND_SUCCESS, "Success");
            put(RESPOND_USER_NOT_REGISTER, "用户未注册");
            put(RESPOND_USER_REGISTER, "用户已注册");

            put(RESPOND_REQUEST_VALIDATOR_FAIL, "请求验证失败");
            put(RESPOND_GET_DATA_FAIL, "获取数据失败");
            put(RESPOND_REQUEST_OPERATE_FAIL, "请求操作失败");
            put(RESPOND_TOKEN_NULL_FAIL, "请求token不能为空");
            put(RESPOND_TOKEN_INVALID_FAIL, "请求token无效");

            put(RESPOND_LOGIN_FAIL, "用户名或密码错误");
            put(RESPOND_SMS_SEND_FAIL, "短信发送失败");
            put(RESPOND_SMS_VERIFY_FAIL, "短信验证失败");
            put(RESPOND_INVITATION_CODE_FAIL, "邀请码错误");
            put(RESPOND_CHECK_AUTH_FAIL, "权限不足");
            put(RESPOND_PHONE_NUMBER_EXIST_FAIL, "手机号存在");
            put(RESPOND_CAPTCHA_VERIFY_FAIL, "验证码不匹配！");

            put(RESPOND_SERVICE_ERROR, "服务器开小差了，请稍后重试");
            put(RESPOND_SOURCE_NOT_FOUND, "资源未找到");
            put(RESPOND_STATION_NOT_FIND, "当前电站未注册");

            put(WARNING_DELETE,"告警删除失败");
            put(WARNING_UPDATE,"告警状态修改失败");
            put(STATION_DELETE,"电站删除失败");
            put(REQUEST_DELETE,"申请删除失败");
            put(REQUEST_SHOW,"查看申请失败");
            put(REQUEST_UPDATE,"申请修改失败");
            put(BIND_FAIL,"该电站已绑定代理商，请在绑定代理商时选择【否】继续完成绑定电站");
            put(AGENT_ID_FAIL,"没有识别到您的身份");
            put(AGENT_ADD_FAIL,"非一级代理商没有权限添加子账户");
            put(AGENT_PARA_NULL,"参数不能为空");
            put(AGENT_ALREADY_ADD_FAIL,"已经添加过该服务商");
            put(AGENT_DELETE,"代理商删除失败");//代理商删除失败
            put(AGENT_GIVE_FAIL,"管理员和二级代理商不能分配电站给其他代理商");//管理员和二级代理商不能分配电站给其他代理商
            put(PARA_NOT_NULL,"请输入有效参数");
            put(NULL_DATA,"无数据");

            put(WARNING_ADD,"发电量不正常，添加告警");

            put(STATION_ALREADY_BIND_USER,"该电站已经绑定用户");
            put(NO_ACCESS,"您没有权限重置密码");//二级代理商没有权限修改自己的密码，二级代理商的密码是一级代理商赋给的
            put(NOT_FIND_PROFIT_PORVICE, "未找到当前地区资料");
            put(INCORRECT_CODE,"扫码不正确");//扫码不在范围内

        }
    };

    private Response() {
    }

    public static Response buildResponse(int err_code) {
        Response response = new Response();
        response.setErr_code(err_code);
        response.setErr_msg(response_table.get(err_code));
        return response;
    }

    public static Response buildResponse(int err_code, Object result) {
        Response response = new Response();
        response.setErr_code(err_code);
        response.setErr_msg(response_table.get(err_code));
        response.setResult(result);
        return response;
    }

    public void setErr_code(int err_code) {
        this.err_code = err_code;
    }

    public void setErr_msg(String err_msg) {
        this.err_msg = err_msg;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public int getErr_code() {
        return err_code;
    }

    public String getErr_msg() {
        return err_msg;
    }

    public Object getResult() {
        return result;
    }
}
