package com.sicnu.bulb.selflog;


import java.lang.annotation.*;


/**
 * 自定义注解
 * 用于拦截请求并打印操作日志
 */

@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface OperationLog {
    String description() default "";
}
