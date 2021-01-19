package it.unical.asd.group6.computerSparePartsCompany.core.exception.warehouse;

import it.unical.asd.group6.computerSparePartsCompany.core.exception.warehouse.classgeneric.WarehouseException;

public class WarehouseByIdNotFoundException extends WarehouseException {

    public WarehouseByIdNotFoundException(Long id){super(String.format("No warehouse found with id %s",id));}
}
