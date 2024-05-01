package com.webteam.marathon.exception;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class PageExceptionHandler {
    @ExceptionHandler(Exception.class)
    public String handleException(Exception e) {
        e.printStackTrace();
        return "error";
    }

}