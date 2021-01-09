package it.unical.asd.group6.computerSparePartsCompany.core.services;

import it.unical.asd.group6.computerSparePartsCompany.data.dto.CustomerDTO;
import it.unical.asd.group6.computerSparePartsCompany.data.entities.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    Boolean registerNewCustomer(Customer customer);

    Boolean checkLogin(String username, String password);

    List<CustomerDTO> getAllCustomer();

    Customer deleteUser(Customer customer);

    Boolean searchByUsername(String username);

    Boolean searchByEmail(String email);

    Optional<CustomerDTO> getCustomerByUsername(String username);

    Integer getReportTotalPurchases(String username);

    Double getReportTotalAmountSpent(String username);

    String getReportFavoriteCategory(String username);

    Optional<CustomerDTO> getCustomerById(Long id);

    List<String>getAllUsernames();

    void updateCustomerInfos(Customer c);

    Optional<Customer> getCustomerEntityByUsername(String username);

    Optional<Customer> getCustomerEntityById(Long customerId);

    //boolean addCustomer(Customer c);
}
