package com.chltec.http;

/**
 * Author joker
 * Created on 2017/10/31.
 * Description
 */
public class ResponseCode {
    public final static int RESPOND_SUCCESS = 0;
    public final static int RESPOND_USER_NOT_REGISTER = 1;
    public final static int RESPOND_REQUEST_VALIDATOR_FAIL = 1000;
    public final static int RESPOND_GET_DATA_FAIL = 1001;
    public final static int RESPOND_REQUEST_OPERATE_FAIL = 1002;
    public final static int RESPOND_TOKEN_NULL_FAIL = 1003;
    public final static int RESPOND_TOKEN_INVALID_FAIL = 1004;

    public final static int RESPOND_LOGIN_FAIL = 1100;
    public final static int RESPOND_SMS_SEND_FAIL = 1101;
    public final static int RESPOND_SMS_VERIFY_FAIL = 1102;
    public final static int RESPOND_STATION_DELETE_FAIL_LINKAGE = 1103;
    public final static int RESPOND_CHECK_AUTH_FAIL = 1104;
    public final static int RESPOND_PHONE_NUMBER_EXIST_FAIL = 1105;
    public final static int RESPOND_NO_FAMILY_FAIL = 1106;
    public final static int RESPOND_WECHAT_REGISTER_ERROR = 1107;
    public final static int RESPOND_VERSION_LOW_FAIL = 1108;

    public final static int RESPOND_VERSION_LASTEST_FAIL = 1200;
    public final static int RESPOND_APP_VERSION_LOW_FAIL = 1201;

    public final static int RESPOND_SERVICE_ERROR = 2000; //2000+ service error
    public final static int RESPOND_SOURCE_NOT_FOUND = 2001; //2000+ service error
    public final static int RESPOND_UPDATE_AUTHORITY_SUCCESS = 2002;//已经添加过该权限
    public final static int RESPOND_ADD_AUTHORITY_SUCCESS = 2004;//添加权限成功
    public final static int RESPOND_NOT_AUTHORITY = 2003;//不是管理员没有权限

    public final static int RESPOND_LOCK_AUTHORITY_ACCESS_FAILD = 3001; //密码错误
}
