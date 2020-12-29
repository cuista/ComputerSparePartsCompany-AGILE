package it.unical.asd.group6.computerSparePartsCompany.core.services;

import it.unical.asd.group6.computerSparePartsCompany.data.entities.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    Boolean registerNewCustomer(Customer customer);

    Boolean checkLogin(String username, String password);

    List<Customer> getAllCustomer();

    Customer deleteUser(Customer customer);

    Boolean searchByUsername(String username);

    Boolean searchByEmail(String email);

    Optional<Customer> getCustomerByUsername(String username);

    Integer getReportTotalPurchases(String username);

    Double getReportTotalAmountSpent(String username);

    String getReportFavoriteCategory(String username);

    Optional<Customer> getCustomerById(Long id);
}
