package it.unical.asd.group6.computerSparePartsCompany.core.exception.product;

import it.unical.asd.group6.computerSparePartsCompany.core.exception.product.classgeneric.ProductException;

public class NoProductFoundException extends ProductException {

    public NoProductFoundException(){super("No product found to retrieve");}

}
