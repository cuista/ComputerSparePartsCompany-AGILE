package it.unical.asd.group6.computerSparePartsCompany.core.services;

import it.unical.asd.group6.computerSparePartsCompany.data.dto.PurchaseDTO;
import it.unical.asd.group6.computerSparePartsCompany.data.entities.Customer;
import it.unical.asd.group6.computerSparePartsCompany.data.entities.Purchase;

import java.time.LocalDate;
import java.util.List;


public interface PurchaseService {
    Boolean registerNewPurchase(Purchase purchase);
    List<PurchaseDTO> getAll();
    Boolean add(Purchase p);
    List<PurchaseDTO> getAllByCustomer(Customer c);
    List<PurchaseDTO> getAllByFilters(String username, LocalDate l);

    List<PurchaseDTO> getAllPurchases();
}
