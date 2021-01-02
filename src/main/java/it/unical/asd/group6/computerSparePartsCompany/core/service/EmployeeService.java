package it.unical.asd.group6.computerSparePartsCompany.core.service;

import it.unical.asd.group6.computerSparePartsCompany.data.entities.Employee;

import java.util.Optional;

public interface EmployeeService {

    boolean checkLogin(String username, String password);

    Optional<Employee> getEmployeeByUsername(String username);

    void updateEmployeeInfos(Employee e);
}
