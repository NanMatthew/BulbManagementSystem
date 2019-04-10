package com.sicnu.bulb.util;

import org.slf4j.Logger;

/**
 * Created by HY
 * 2019/4/3 19:58
 *
 * logger util
 */
public class LoggerUtil {

    private static final String hint = "=================别怕，这是自己打印的Exception=================";

    public static void errorLog(String exceptionHandler, Logger logger, Exception e) {
        System.out.println(hint);
        logger.error(exceptionHandler, e);
        System.out.println(hint);
    }

}
