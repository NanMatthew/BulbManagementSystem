package com.sicnu.bulb.controller;

import com.sicnu.bulb.entity.msg.Msg;
import com.sicnu.bulb.entity.msg.ResultCode;
import com.sicnu.bulb.util.LoggerUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


/**
 * Created by HY
 * 2019/4/3 19:42
 * <p>
 * 异常处理 返回json字符串而不是页面
 */

@RestControllerAdvice
public class AllExceptionHandler {

    private static Logger logger = LoggerFactory.getLogger(AllExceptionHandler.class);

    @ExceptionHandler(value = Exception.class)
    public Msg defaultErrorHandler(Exception e) {
        LoggerUtil.errorLog("AllExceptionHandler",logger,e);

        if (e instanceof org.springframework.web.servlet.NoHandlerFoundException) {
            //404 Not Found
            return new Msg(ResultCode.RESULT_CODE_NOT_FOUND, e.getMessage());
        } else {
            //500
            return new Msg(ResultCode.RESULT_CODE_INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

}
