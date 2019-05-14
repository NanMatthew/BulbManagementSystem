package com.sicnu.bulb.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by HY
 * 2019/4/3 19:58
 * <p>
 * logger util
 */
public class LoggerUtil {

    private static final String hint = "=================自己拦截的Exception=================";

    private static final String LOGGER_TYPE_LOGIN = "login";

    private static final String LOGGER_TYPE_OPERATION = "operation";


    public static void errorLog(String exceptionHandler, Logger logger, Exception e) {
        System.out.println(hint);
        logger.error(exceptionHandler, e);
        System.out.println(hint);
    }

    /**
     * 获取操作日志Logger
     */
    public static Logger getOperationLogger() {
        return LoggerFactory.getLogger(LOGGER_TYPE_OPERATION);
    }

    /**
     * 获取登录日志Logger
     */
    public static Logger getLoginLogger() {
        return LoggerFactory.getLogger(LOGGER_TYPE_LOGIN);
    }
}
