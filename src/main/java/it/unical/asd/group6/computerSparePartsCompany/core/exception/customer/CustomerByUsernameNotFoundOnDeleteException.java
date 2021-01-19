package it.unical.asd.group6.computerSparePartsCompany.core.exception.customer;

import it.unical.asd.group6.computerSparePartsCompany.core.exception.customer.classgeneric.CustomerException;

public class CustomerByUsernameNotFoundOnDeleteException extends CustomerException {

    public CustomerByUsernameNotFoundOnDeleteException(String username){super(String.format("No customer to delete with username %s",username));}
}
