package com.imooc.mall.filter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@Aspect
@Component
public class WebLogAspect {
    private final Logger log = LoggerFactory.getLogger(WebLogAspect.class);
    @Pointcut("execution(public * com.imooc.mall.controller.*.*(..))")
    public void webLog(){}

    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint){
        // 收到请求,获取请求信息
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        // 记录日志
        log.info("url : " + request.getRequestURL().toString());
        log.info("HTTP_METHOD : " + request.getMethod());
        log.info("IP : " + request.getRemoteAddr());
        log.info("ClASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        log.info("ARGS : " + Arrays.toString(joinPoint.getArgs()));
    }

    @AfterReturning(returning = "res" , pointcut = "webLog()")
    public void doAfterReturning(Object res) throws JsonProcessingException {
        log.info("RESPONSE : " + new ObjectMapper().writeValueAsString(res) );
    }

    @AfterThrowing(pointcut = "webLog()", throwing = "exception")
    public void doAfterThrowing(JoinPoint joinPoint, Throwable exception) {
        log.info("Exception occurred in method: " + joinPoint.getSignature().getName(), exception);
    }
}
