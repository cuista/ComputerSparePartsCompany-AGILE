package it.unical.asd.group6.computerSparePartsCompany.core.exception.product;

import it.unical.asd.group6.computerSparePartsCompany.core.exception.product.classgeneric.ProductException;

public class ProductLessThanACertainPriceNotFoundException extends ProductException {

    public ProductLessThanACertainPriceNotFoundException(Double price){super(String.format("No product found under price %s",price));}

}
