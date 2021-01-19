package it.unical.asd.group6.computerSparePartsCompany.core.exception.employee;

import it.unical.asd.group6.computerSparePartsCompany.data.entities.Employee;

public class EmployeeException extends RuntimeException{

    public EmployeeException(){super();}

    public EmployeeException(String message){super(message);}
}
