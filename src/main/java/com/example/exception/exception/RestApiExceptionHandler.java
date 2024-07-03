package com.example.exception.exception;

import com.example.exception.controller.RestApiBController;
import com.example.exception.controller.RestApiController;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
// 1. Detects all exception when using rest api
@RestControllerAdvice
// 2. Handler catches all exceptions under com.example.exception.controller controllers.
// @RestControllerAdvice(basePackages = "com.example.exception.controller")
// 3. Catches exceptions only in RestApiController and RestApiBController classes.
//@RestControllerAdvice(basePackageClasses = {RestApiController.class, RestApiBController.class})

public class RestApiExceptionHandler {
    //All exceptions
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity exception(
        Exception e
    ){
        log.error("RestApiExceptionHandler", e);
        return ResponseEntity.status(200).build();
    }

    //Specific exception. Overrides @ExceptionHandler(value = Exception.class) in case of out of bounds exception.
    @ExceptionHandler(value = IndexOutOfBoundsException.class)
    public ResponseEntity outOfBound(
            IndexOutOfBoundsException e
    ){
        log.error("IndexOutOfBoundsException ", e);
        return ResponseEntity.status(200).build();
    }
}
