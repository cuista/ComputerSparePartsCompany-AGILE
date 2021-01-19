package it.unical.asd.group6.computerSparePartsCompany.controller.handler;

import it.unical.asd.group6.computerSparePartsCompany.core.exception.customer.CustomerByUsernameNotFoundOnDeleteException;
import it.unical.asd.group6.computerSparePartsCompany.core.exception.customer.CustomerByUsernameNotFoundOnRetrieveException;
import it.unical.asd.group6.computerSparePartsCompany.core.exception.customer.CustomerSearchByEmailNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class CustomerExceptionAdvice {

    @ResponseBody
    @ExceptionHandler(CustomerByUsernameNotFoundOnRetrieveException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String CustomerByUsernameNotFoundHandler(CustomerByUsernameNotFoundOnRetrieveException e) {return e.getMessage();}

    @ResponseBody
    @ExceptionHandler(CustomerSearchByEmailNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String CustomerSearchByEmailNotFoundException(CustomerSearchByEmailNotFoundException e) {return e.getMessage();}

    @ResponseBody
    @ExceptionHandler(CustomerByUsernameNotFoundOnDeleteException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String CustomerSearchByUsernameNotFoundOnDeleteException(CustomerByUsernameNotFoundOnDeleteException e){return e.getMessage();}

}
