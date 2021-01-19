package it.unical.asd.group6.computerSparePartsCompany.controller.handler;

import it.unical.asd.group6.computerSparePartsCompany.core.exception.employee.EmployeeByUsernameNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class EmployeeExceptionAdvice {

    @ResponseBody
    @ExceptionHandler(EmployeeByUsernameNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String EmployeeByUsernameNotFoundHandler(EmployeeByUsernameNotFoundException e) {return e.getMessage();}
}
