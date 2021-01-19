package it.unical.asd.group6.computerSparePartsCompany.controller.handler;

import it.unical.asd.group6.computerSparePartsCompany.core.exception.warehouse.WarehouseByIdNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class WarehouseExceptionAdvice {

    @ResponseBody
    @ExceptionHandler(WarehouseByIdNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String WarehouseByIdNotFoundHandler(WarehouseByIdNotFoundException e) {return e.getMessage();}

}
