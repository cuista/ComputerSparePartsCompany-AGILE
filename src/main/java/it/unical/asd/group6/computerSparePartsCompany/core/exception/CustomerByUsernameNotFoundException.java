package it.unical.asd.group6.computerSparePartsCompany.core.exception;

public class CustomerByUsernameNotFoundException extends CustomerException{

    public CustomerByUsernameNotFoundException(String username){super(String.format("No customer found with username %s",username));}

}
