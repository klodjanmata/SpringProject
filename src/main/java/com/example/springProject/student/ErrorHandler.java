package com.example.springProject.student;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(RuntimeException.class)
    public void handleRuntimeException(final RuntimeException e){
        e.printStackTrace();
        System.out.println("This is an RuntimeException");
    }

    @ExceptionHandler(NullPointerException.class)
    public void handleNullPointerException(final NullPointerException e){
        e.printStackTrace();
        System.out.println("This is a NullPointerException");
    }

}
