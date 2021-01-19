package it.unical.asd.group6.computerSparePartsCompany.core.exception.productionhouse;

import it.unical.asd.group6.computerSparePartsCompany.core.exception.productionhouse.classgeneric.ProductionHouseException;

public class ProductionHouseNotFoundException extends ProductionHouseException {

    public ProductionHouseNotFoundException(String name) {
        super(String.format("Not found Production House with the name: [%s]", name));
    }

}
