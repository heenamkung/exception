package com.example.exception.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/b")
public class RestApiBController {

    @GetMapping("/hello")
    public void hello(){
        throw new NumberFormatException("Number Format exception!");
    }

    /*
    //Catches error in controller before exception handler. ExceptionHandler.java has @RestControllerAdvice but NumberFormatException is only handled here.
    //Not suitable when controller is long and complicated.
    @ExceptionHandler(value = NumberFormatException.class)
    public ResponseEntity numberForException(
            NumberFormatException e
    ){
        log.error("RestApiBController", e);
        return ResponseEntity.ok().build();
    }
     */
}
