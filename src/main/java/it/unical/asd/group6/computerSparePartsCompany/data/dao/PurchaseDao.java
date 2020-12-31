package it.unical.asd.group6.computerSparePartsCompany.data.dao;

import it.unical.asd.group6.computerSparePartsCompany.data.entities.Customer;
import it.unical.asd.group6.computerSparePartsCompany.data.entities.Product;
import it.unical.asd.group6.computerSparePartsCompany.data.entities.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface PurchaseDao extends JpaRepository<Purchase,Long>, JpaSpecificationExecutor<Purchase> {

    List<Purchase> findAll();

    List<Purchase> findAllByCustomer(Customer c);

    Optional<List<Purchase>> findAllByDateBetween(LocalDate d1, LocalDate d2);

    Optional<List<Purchase>> findAllByCustomerId(Long id);

    Optional<List<Purchase>> findAllByTotalPriceBetween(Double p1, Double p2);

}