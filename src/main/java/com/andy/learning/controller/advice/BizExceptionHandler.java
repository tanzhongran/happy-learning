package com.andy.learning.controller.advice;

import com.andy.learning.infrastructure.BizException;
import com.andy.learning.infrastructure.Util.Result;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice()
public class BizExceptionHandler {

    @ResponseBody
    @ExceptionHandler({BizException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Result customExceptionHandler(BizException e){
        return Result.error(e.getCode(),e.getMsg());
    }

}
