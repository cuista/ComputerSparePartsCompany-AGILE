package it.unical.asd.group6.computerSparePartsCompany.core.exception;

public class UserAlreadyInDBException extends UserException {

    public UserAlreadyInDBException() {
        super(String.format("Username or email are already in use"));
    }
}
