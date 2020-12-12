package it.unical.asd.group6.computerSparePartsCompany.data.exception;

public class UserNotFoundException extends UserException {

    public UserNotFoundException(String username) {
        super(String.format("Bad credentials for user: [%s]", username));
    }
}
