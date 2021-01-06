package it.unical.asd.group6.computerSparePartsCompany.core.services;

import it.unical.asd.group6.computerSparePartsCompany.data.entities.Customer;
import it.unical.asd.group6.computerSparePartsCompany.data.entities.Employee;

import java.util.Optional;

public interface EmployeeService {

    boolean checkLogin(String username, String password);

    Optional<Employee> getEmployeeByUsername(String username);

    Integer getReportTotalPurchases();

    Double getReportTotalAmountSpent();

    String getReportFavoriteCategory();

    void updateEmployeeInfos(Employee e);
}
