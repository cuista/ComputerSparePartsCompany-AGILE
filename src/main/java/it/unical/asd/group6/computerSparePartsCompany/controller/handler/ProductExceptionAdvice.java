package it.unical.asd.group6.computerSparePartsCompany.controller.handler;

import it.unical.asd.group6.computerSparePartsCompany.core.exception.product.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ProductExceptionAdvice {

    @ResponseBody
    @ExceptionHandler(ProductByBrandNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String ProductByBrandNotFoundHandler(ProductByBrandNotFoundException e) {return e.getMessage();}

    @ResponseBody
    @ExceptionHandler(ProductByBrandAndModelNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String ProductByBrandAndModelNotFoundHandler(ProductByBrandAndModelNotFoundException e) {return e.getMessage();}

    @ResponseBody
    @ExceptionHandler(ProductLessThanACertainPriceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String ProductLessThanACertainPriceNotFoundHandler(ProductLessThanACertainPriceNotFoundException e) {return e.getMessage();}

    @ResponseBody
    @ExceptionHandler(ProductByModelNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String ProductByModelNotFoundHandler(ProductByModelNotFoundException e){return e.getMessage();}

    @ResponseBody
    @ExceptionHandler(NoProductFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String ProductNotFoundHandler(NoProductFoundException e){return e.getMessage();}

}
