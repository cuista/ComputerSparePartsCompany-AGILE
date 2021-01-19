package it.unical.asd.group6.computerSparePartsCompany.core.exception.product.classgeneric;

import org.springframework.data.repository.query.Param;

public class ProductException extends RuntimeException{

    public ProductException(){super();}

    public ProductException(String message){super(message);}

}
