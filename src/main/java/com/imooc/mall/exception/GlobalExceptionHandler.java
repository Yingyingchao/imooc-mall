package com.imooc.mall.exception;

import com.imooc.mall.common.ApiRestResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 处理统一异常的hander
 */
@ControllerAdvice
public class GlobalExceptionHandler {
//    private final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    private final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Object handlerException(Exception e){
        log.error("Default Message",  e);
        return ApiRestResponse.error(ImoocMallExceptionEnum.SYSTEM_ERROR);
    }

    @ExceptionHandler(ImoocMallException.class)
    @ResponseBody
    public Object handlerImoocMallExceptionException(ImoocMallException e){
        log.error("ImoocMallException",  e);
        return ApiRestResponse.error(e.getCode(),e.getMessage());
    }

}
