package it.unical.asd.group6.computerSparePartsCompany.core.services;

import it.unical.asd.group6.computerSparePartsCompany.data.dto.ProductionHouseDTO;
import it.unical.asd.group6.computerSparePartsCompany.data.entities.ProductionHouse;

import java.util.List;
import java.util.Optional;

public interface ProductionHouseService {

    ProductionHouseDTO searchByName(String name);

    Optional<ProductionHouse> searchEntityByName(String name);
    List<String> getAllNames();
}
