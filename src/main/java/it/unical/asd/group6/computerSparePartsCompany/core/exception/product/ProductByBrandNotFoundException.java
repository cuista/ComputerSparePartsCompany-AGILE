package it.unical.asd.group6.computerSparePartsCompany.core.exception.product;

import it.unical.asd.group6.computerSparePartsCompany.core.exception.product.classgeneric.ProductException;

public class ProductByBrandNotFoundException extends ProductException {

    public ProductByBrandNotFoundException(String brand){super(String.format("No product found for brand %s",brand));}


}
