package it.unical.asd.group6.computerSparePartsCompany.core.exception.employee;

import it.unical.asd.group6.computerSparePartsCompany.core.exception.employee.EmployeeException;

public class EmployeeByUsernameNotFoundException extends EmployeeException {

    public EmployeeByUsernameNotFoundException(String username){super(String.format("No employee found with the username %s",username));}

}
