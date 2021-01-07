package it.unical.asd.group6.computerSparePartsCompany.controller.handler;

import it.unical.asd.group6.computerSparePartsCompany.core.exception.CustomerByUsernameNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class CustomerExceptionAdvice {

    @ResponseBody
    @ExceptionHandler(CustomerByUsernameNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String CustomerByUsernameNotFoundHandler(CustomerByUsernameNotFoundException e) {return e.getMessage();}

}
