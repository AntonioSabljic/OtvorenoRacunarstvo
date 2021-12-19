package com.otvrac.backend.payroll;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ZupanijaNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(ZupanijaNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String zupanijaNotFoundHandler(ZupanijaNotFoundException ex) {
        return ex.getMessage();
    }


    @ResponseBody
    @ExceptionHandler(ZupanijeNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String zupanijeNotFoundHandler(ZupanijeNotFoundException ex) {
        return ex.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(GradNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String gradNotFoundHandler(GradNotFoundException ex) {
        return ex.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(GradoviNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String gradoviNotFoundHandler(GradoviNotFoundException ex) {
        return ex.getMessage();
    }

}
