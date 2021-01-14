package it.unical.asd.group6.computerSparePartsCompany.core.services;

import it.unical.asd.group6.computerSparePartsCompany.data.dto.EmployeeDTO;
import it.unical.asd.group6.computerSparePartsCompany.data.entities.Customer;
import it.unical.asd.group6.computerSparePartsCompany.data.entities.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    boolean checkLogin(String username, String password);

    List<EmployeeDTO> getAll();

    Optional<EmployeeDTO> getEmployeeByUsername(String username);

    Integer getReportTotalPurchases();

    Double getReportTotalAmountSpent();

    String getReportFavoriteCategory();

    void updateEmployeeInfos(EmployeeDTO employeeDTO);
}
