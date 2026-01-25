// Not getting used as we are using @ResponseStatus in NotFoundExcecption.java
package com.springframework.spring6restmvc.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

// Second way: Handles exceptions of all controllers
@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity handleNotFoundException(){

        System.out.println("In the Exception Handler");

        return ResponseEntity.notFound().build();
    }
}
