package it.unical.asd.group6.computerSparePartsCompany.core.service.implementation;

import it.unical.asd.group6.computerSparePartsCompany.core.exception.ProductionHouseNotFoundException;
import it.unical.asd.group6.computerSparePartsCompany.core.service.ProductionHouseService;
import it.unical.asd.group6.computerSparePartsCompany.data.dao.ProductionHouseDao;
import it.unical.asd.group6.computerSparePartsCompany.data.entities.ProductionHouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductionHouseServiceImpl implements ProductionHouseService {

    @Autowired
    private ProductionHouseDao productionHouseDao;

    @Override
    public ProductionHouse searchByName(String name) {
        return productionHouseDao.findByName(name).orElseThrow(()-> new ProductionHouseNotFoundException(name));
    }
}
