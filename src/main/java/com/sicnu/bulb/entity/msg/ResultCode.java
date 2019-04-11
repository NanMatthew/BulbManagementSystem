package com.sicnu.bulb.entity.msg;

/**
 * Created by HY
 * 2019/4/3 19:32
 * <p>
 * Msg 返回码
 */
@SuppressWarnings({"unused", "WeakerAccess"})
public class ResultCode {

    /**
     * 正确
     */
    public static final int RESULT_CODE_CORRECT = 0;

    /**
     * 错误
     */
    public static final int RESULT_CODE_ERROR = 1;

    /**
     * 预期之外的错误
     */
    public static final int RESULT_CODE_NOT_KNOWN_ERROR = -100;

    /**
     * 用户名不存在
     */
    public static final int RESULT_CODE_USER_NOT_EXIST = -101;

    /**
     * 密码错误
     */
    public static final int RESULT_CODE_ERROR_PASSWORD = -102;


    /**
     * 404
     * Not Found
     */
    public static final int RESULT_CODE_NOT_FOUND = 404;

    /**
     * 服务器内部错误 505
     * Internal Server Error
     */
    public static final int RESULT_CODE_INTERNAL_SERVER_ERROR = 500;


}
