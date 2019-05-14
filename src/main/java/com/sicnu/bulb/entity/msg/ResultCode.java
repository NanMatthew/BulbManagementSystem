package com.sicnu.bulb.entity.msg;


import java.util.HashMap;
import java.util.Map;

/**
 * Created by HY
 * 2019/4/3 19:32
 * <p>
 * Msg 返回码
 */
@SuppressWarnings({"unused", "WeakerAccess"})
public class ResultCode {

    private static Map<Integer, String> resultMap = new HashMap<>();

    /**
     * 获取 resultCode 对应的info
     */
    public static String getInfo(int resultCode) {
        return resultMap.get(resultCode);
    }

    /**
     * 正确
     */
    public static final int RESULT_CODE_CORRECT = 0;

    static {
        resultMap.put(RESULT_CODE_CORRECT, "正确");
    }

    /**
     * 错误
     */
    public static final int RESULT_CODE_ERROR = 1;

    static {
        resultMap.put(RESULT_CODE_ERROR, "错误");
    }

    /**
     * 预期之外的错误
     */
    public static final int RESULT_CODE_NOT_KNOWN_ERROR = -100;

    static {
        resultMap.put(RESULT_CODE_NOT_KNOWN_ERROR, "预期之外的错误");
    }

    /**
     * 用户名不存在
     */
    public static final int RESULT_CODE_USER_NOT_EXIST = -101;

    static {
        resultMap.put(RESULT_CODE_USER_NOT_EXIST, "用户名不存在");
    }

    /**
     * 密码错误
     */
    public static final int RESULT_CODE_ERROR_PASSWORD = -102;

    static {
        resultMap.put(RESULT_CODE_ERROR_PASSWORD, "密码错误");
    }

    /**
     * 未登录就请求其他页面
     */
    public static final int RESULT_CODE_NEED_LOGIN = -103;

    static {
        resultMap.put(RESULT_CODE_NEED_LOGIN, "未登录就请求其他页面");
    }

    /**
     * 未授权
     */
    public static final int RESULT_CODE_NO_PERMISSION = -104;

    static {
        resultMap.put(RESULT_CODE_NO_PERMISSION, "未授权");
    }

    /**
     * 产品不存在
     */
    public static final int RESULT_CODE_PRODUCT_NOT_EXIST = -105;

    static {
        resultMap.put(RESULT_CODE_PRODUCT_NOT_EXIST, "产品不存在");
    }

    /**
     * 404
     * Not Found
     */
    public static final int RESULT_CODE_NOT_FOUND = 404;

    static {
        resultMap.put(RESULT_CODE_NOT_FOUND, "Not Found");
    }

    /**
     * 服务器内部错误 505
     * Internal Server Error
     */
    public static final int RESULT_CODE_INTERNAL_SERVER_ERROR = 500;

    static {
        resultMap.put(RESULT_CODE_INTERNAL_SERVER_ERROR, "Internal Server Error");
    }

}
