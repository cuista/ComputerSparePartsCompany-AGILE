package it.unical.asd.group6.computerSparePartsCompany.controller.handler;

import it.unical.asd.group6.computerSparePartsCompany.core.exception.faq.FAQByDescriptionNotFoundException;
import it.unical.asd.group6.computerSparePartsCompany.core.exception.faq.FAQByTitleNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class FAQExceptionAdvice {

    @ResponseBody
    @ExceptionHandler(FAQByTitleNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String FAQByTitleNotFoundHandler(FAQByTitleNotFoundException e) {return e.getMessage();}

    @ResponseBody
    @ExceptionHandler(FAQByDescriptionNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String FAQByDescriptionNotFoundHandler(FAQByDescriptionNotFoundException e) {return e.getMessage();}

}
