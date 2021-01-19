package it.unical.asd.group6.computerSparePartsCompany.core.exception.product;

import it.unical.asd.group6.computerSparePartsCompany.core.exception.product.classgeneric.ProductException;

public class ProductByModelNotFoundException extends ProductException {

    public ProductByModelNotFoundException(String model){super(String.format("No product found for model %s",model));}

}
