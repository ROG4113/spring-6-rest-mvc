package com.springframework.spring6restmvc.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;

@ControllerAdvice
public class CustomErrorController {

    @ExceptionHandler
    ResponseEntity handleJPAViolations(TransactionSystemException exception){
        ResponseEntity.BodyBuilder responseEntity=ResponseEntity.badRequest();
        if(exception.getCause().getCause() instanceof ConstraintViolationException){
            ConstraintViolationException ve=(ConstraintViolationException) exception.getCause().getCause();

            List errors=ve.getConstraintViolations().stream()
                            .map(ConstraintViolation->{
                                Map<String, String> errMap=new HashMap<>();
                                errMap.put(ConstraintViolation.getPropertyPath().toString(), ConstraintViolation.getMessage());
                                return errMap;
                            }).collect(Collectors.toList());
            return responseEntity.body(errors);
        }
        return ResponseEntity.badRequest().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    ResponseEntity handleBindErros(MethodArgumentNotValidException exception){

        List errorList=exception.getFieldErrors().stream()
                                .map(fielderror->{
                                    Map<String, String> errorMap=new HashMap<>();
                                    errorMap.put(fielderror.getField(), fielderror.getDefaultMessage());
                                    return errorMap;
                                }).collect(Collectors.toList());

        return ResponseEntity.badRequest().body(errorList);
    }

}
