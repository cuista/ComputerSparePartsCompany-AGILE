package it.unical.asd.group6.computerSparePartsCompany.core.exception.customer;

import it.unical.asd.group6.computerSparePartsCompany.core.exception.customer.classgeneric.CustomerException;

public class CustomerSearchByEmailNotFoundException extends CustomerException {

    public CustomerSearchByEmailNotFoundException(String email){super(String.format("No customer found with email address %s",email));}
}
