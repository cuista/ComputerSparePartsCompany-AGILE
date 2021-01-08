package it.unical.asd.group6.computerSparePartsCompany.core.services;

import it.unical.asd.group6.computerSparePartsCompany.data.dto.ProductionHouseDTO;
import it.unical.asd.group6.computerSparePartsCompany.data.entities.ProductionHouse;

public interface ProductionHouseService {

    ProductionHouseDTO searchByName(String name);

}
