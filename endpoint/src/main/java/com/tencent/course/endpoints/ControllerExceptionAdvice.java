package com.tencent.course.endpoints;

import com.course.model.base.Result;
import com.course.model.base.RetCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@Slf4j
public class ControllerExceptionAdvice {
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result<Void> handlerException(Exception e){
        log.error("handlerException: ",e);
        Result<Void> result= Result.error(RetCode.SYS_ERROR);
        return result;
    }

}