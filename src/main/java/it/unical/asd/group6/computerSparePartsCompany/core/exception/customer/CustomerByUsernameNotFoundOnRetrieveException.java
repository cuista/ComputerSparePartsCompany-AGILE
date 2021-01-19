package it.unical.asd.group6.computerSparePartsCompany.core.exception.customer;

import it.unical.asd.group6.computerSparePartsCompany.core.exception.customer.classgeneric.CustomerException;

public class CustomerByUsernameNotFoundOnRetrieveException extends CustomerException {

    public CustomerByUsernameNotFoundOnRetrieveException(String username){super(String.format("No customer found with username %s",username));}

}
