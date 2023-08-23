package com.shortlink.handler;

import com.shortlink.common.R;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


/**
 * @author xck
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public R<String> handleBindException(Exception ex){
        return R.error("该短链不存在或不是由本站生成");
    }

}
