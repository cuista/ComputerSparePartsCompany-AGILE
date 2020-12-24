package it.unical.asd.group6.computerSparePartsCompany.data.dao;


import it.unical.asd.group6.computerSparePartsCompany.data.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerDao extends JpaRepository<Customer,Long> {

    Optional<List<Customer>> findAllByUsernameIsNotNull();

    Optional<Customer> findCustomerByNameAndSurname(String name, String surname);

    Optional<Customer> findCustomerByVATIdentificationNumber(Long vat);

    Optional<Customer> findCustomerByUsernameAndPassword(String username, String password);

    Optional<Customer> findCustomerByUsername(String username);

    Optional<Customer> findCustomerByEmail(String email);

    void deleteByUsername(String username);

}
