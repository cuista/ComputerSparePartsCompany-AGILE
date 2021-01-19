package it.unical.asd.group6.computerSparePartsCompany.core.services.implemented;

import it.unical.asd.group6.computerSparePartsCompany.core.exception.productionhouse.ProductionHouseNotFoundException;
import it.unical.asd.group6.computerSparePartsCompany.core.services.ProductionHouseService;
import it.unical.asd.group6.computerSparePartsCompany.data.dao.ProductionHouseDao;
import it.unical.asd.group6.computerSparePartsCompany.data.dto.ProductionHouseDTO;
import it.unical.asd.group6.computerSparePartsCompany.data.entities.ProductionHouse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductionHouseServiceImpl implements ProductionHouseService {

    @Autowired
    ProductionHouseDao productionHouseDao;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public ProductionHouseDTO searchByName(String name) {
        ProductionHouse productionHouse = productionHouseDao.findByName(name).orElseThrow(()-> new ProductionHouseNotFoundException(name));
        return modelMapper.map(productionHouse, ProductionHouseDTO.class);
    }

    @Override //TODO PROBABILE REFACTOR
    public Optional<ProductionHouse> searchEntityByName(String name) {
        Optional<ProductionHouse> productionHouse = productionHouseDao.findByName(name);
        return productionHouse;
    }
}
