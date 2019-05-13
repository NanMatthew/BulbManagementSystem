package com.sicnu.bulb.selflog;

import com.sicnu.bulb.util.IpUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

@SuppressWarnings("WeakerAccess")
@Aspect
@Component
public class OperationLogAspect {

    private static final Logger logger = LoggerFactory.getLogger("operation");

    @Pointcut("@annotation(com.sicnu.bulb.selflog.OperationLog)")
    public void controllerAspect() {
    }

    @After("controllerAspect()")
    public void doAfter(JoinPoint joinPoint) {

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        StringBuilder operationLog = new StringBuilder();
        String ip = IpUtil.getIpAddress(request);
        try {
            System.out.println("==============拦截到请求==============");

            System.out.println("请求ip：" + ip);
            operationLog.append(" - ").append(ip);

            String requestMethod = joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName();
            System.out.println("请求方法" + requestMethod);
            operationLog.append(" - ").append(requestMethod);

            String methodDescription = getControllerMethodDescription(joinPoint);
            System.out.println("方法描述：" + methodDescription);
            operationLog.append(" - ").append(methodDescription);
//            Object[] args = joinPoint.getArgs();
//            String param;
//            for (int i = 0; i < args.length; i++) {
//                param = "第" + (i + 1) + "个参数为:" + args[i];
//                System.out.println(param);
//                operationLog.append(param);
//            }

            logger.info(operationLog.toString());
        } catch (Exception e) {
            //记录本地异常日志
            logger.error("==拦截到请求但发生异常==");
            logger.error("异常信息：", e.getMessage());
        }
    }

    /**
     * 获取注解中对方法的描述信息
     */
    public static String getControllerMethodDescription(JoinPoint joinPoint) throws Exception {
        String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();//目标方法名
        Object[] arguments = joinPoint.getArgs();
        Class targetClass = Class.forName(targetName);
        Method[] methods = targetClass.getMethods();
        String description = "";
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                Class[] clazzs = method.getParameterTypes();
                if (clazzs.length == arguments.length) {
                    description = method.getAnnotation(OperationLog.class).description();
                    break;
                }
            }
        }
        return description;
    }

}

