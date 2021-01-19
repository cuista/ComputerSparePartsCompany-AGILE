package it.unical.asd.group6.computerSparePartsCompany.core.services;

import it.unical.asd.group6.computerSparePartsCompany.data.dto.EmployeeDTO;


import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    boolean checkLogin(String username, String password);

    Optional<EmployeeDTO> getEmployeeByUsername(String username);

    Integer getReportTotalPurchases();

    Double getReportTotalAmountSpent();

    String getReportFavoriteCategory();

    void updateEmployeeInfos(EmployeeDTO employeeDTO, EmployeeDTO newEmployeeDTO);

    List<EmployeeDTO> getAllEmployees();
}
