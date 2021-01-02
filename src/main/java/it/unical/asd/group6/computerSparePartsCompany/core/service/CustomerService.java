package it.unical.asd.group6.computerSparePartsCompany.core.service;

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

    void updateCustomerInfos(Customer c);

    Optional<Customer> getCustomerById(Long id);

    //boolean addCustomer(Customer c);
}
