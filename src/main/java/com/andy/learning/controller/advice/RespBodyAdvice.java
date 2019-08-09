package com.andy.learning.controller.advice;

import com.andy.learning.infrastructure.util.Result;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@ControllerAdvice
@Component
public class RespBodyAdvice implements ResponseBodyAdvice<Object> {

    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType,
         Class<? extends HttpMessageConverter<?>> aClass,ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        String methodName=methodParameter.getMethod().getName();

//        if(methodName.equals("login")){
//            return o;
//        }

        if( o instanceof Result){
            return o;
        }

        return Result.success(o);
    }
}
