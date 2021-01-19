package it.unical.asd.group6.computerSparePartsCompany.core.exception.product;

import it.unical.asd.group6.computerSparePartsCompany.core.exception.product.classgeneric.ProductException;

public class ProductByBrandAndModelNotFoundException extends ProductException {

    public ProductByBrandAndModelNotFoundException(String brand, String model) {
        super(String.format("No product found for brand %s and model %s",brand,model));
    }

}
