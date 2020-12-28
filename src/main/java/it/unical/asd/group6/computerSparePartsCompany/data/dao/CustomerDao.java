package it.unical.asd.group6.computerSparePartsCompany.data.dao;


import it.unical.asd.group6.computerSparePartsCompany.data.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerDao extends JpaRepository<Customer,Long> {

    Optional<List<Customer>> findAllByUsernameIsNotNull();

    Optional<Customer> findCustomerByNameAndSurname(String name, String surname);

    Optional<Customer> findCustomerByVATIdentificationNumber(Long vat);

    Optional<Customer> findCustomerByUsernameAndPassword(String username, String password);

    Optional<Customer> findCustomerByEmailAndUsername(String email, String username);

    Optional<Customer> findCustomerByUsername(String username);

    Optional<Customer> findCustomerByEmail(String email);

    void deleteByUsername(String username);

    @Modifying
    @Query("UPDATE Customer c SET c.password =:password where c.username=:username")
    void updateCustomerPassword(@Param("username")String username,@Param("password")String password);

    @Modifying
    @Query("UPDATE Customer c SET c.name =:name, c.surname=:surname,c.phoneNumber=:phoneNumber,c.VATIdentificationNumber=:iva where c.username=:username")
    void updateCustomerData(@Param("username")String username,@Param("name") String name,@Param("surname")String surname,@Param("phoneNumber") String phoneNumber,@Param("iva")Long iva);

}
