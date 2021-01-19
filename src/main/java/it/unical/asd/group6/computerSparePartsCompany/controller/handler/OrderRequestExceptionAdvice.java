package it.unical.asd.group6.computerSparePartsCompany.controller.handler;

import it.unical.asd.group6.computerSparePartsCompany.core.exception.orderrequest.NoOrderRequestsSentForWarehouseException;
import it.unical.asd.group6.computerSparePartsCompany.core.exception.orderrequest.OrderRequestException;
import it.unical.asd.group6.computerSparePartsCompany.core.exception.productionhouse.classgeneric.ProductionHouseException;
import it.unical.asd.group6.computerSparePartsCompany.core.exception.productionhouse.ProductionHouseNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class OrderRequestExceptionAdvice {

    @ResponseBody
    @ExceptionHandler(ProductionHouseNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String OrderRequestNotFoundHandler(ProductionHouseException e) {return e.getMessage();}

    @ResponseBody
    @ExceptionHandler(NoOrderRequestsSentForWarehouseException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String NoOrderRequestsSentForWarehouseHandler(OrderRequestException e) {return e.getMessage();}

}
