package it.unical.asd.group6.computerSparePartsCompany.core.services.implemented;

import it.unical.asd.group6.computerSparePartsCompany.core.exception.ProductionHouseNotFoundException;
import it.unical.asd.group6.computerSparePartsCompany.core.services.ProductionHouseService;
import it.unical.asd.group6.computerSparePartsCompany.data.dao.ProductionHouseDao;
import it.unical.asd.group6.computerSparePartsCompany.data.dto.ProductionHouseDTO;
import it.unical.asd.group6.computerSparePartsCompany.data.entities.ProductionHouse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductionHouseServiceImpl implements ProductionHouseService {

    @Autowired
    private ProductionHouseDao productionHouseDao;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ProductionHouseDTO searchByName(String name) {
        ProductionHouse productionHouse = productionHouseDao.findByName(name).orElseThrow(()-> new ProductionHouseNotFoundException(name));
        return modelMapper.map(productionHouse, ProductionHouseDTO.class);
    }
}
