package it.unical.asd.group6.computerSparePartsCompany.data.exception;

public class EmployeeNotFoundException extends EmployeeException {

    public EmployeeNotFoundException(String username) {
        super(String.format("Bad credentials for user: [%s]", username));
    }
}
