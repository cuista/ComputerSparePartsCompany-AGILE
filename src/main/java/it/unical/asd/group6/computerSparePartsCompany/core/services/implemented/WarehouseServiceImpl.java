package it.unical.asd.group6.computerSparePartsCompany.core.services.implemented;

import it.unical.asd.group6.computerSparePartsCompany.core.services.WarehouseService;
import it.unical.asd.group6.computerSparePartsCompany.data.dao.WarehouseDao;
import it.unical.asd.group6.computerSparePartsCompany.data.entities.Warehouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WarehouseServiceImpl implements WarehouseService {

    @Autowired
    WarehouseDao warehouseDao;

    @Override
    public Warehouse getWarehouseById(Long id){
        Optional<Warehouse> wh = warehouseDao.findWarehouseById(id);
        if (wh.isPresent())
            return wh.get();
        return null;
    }

}
