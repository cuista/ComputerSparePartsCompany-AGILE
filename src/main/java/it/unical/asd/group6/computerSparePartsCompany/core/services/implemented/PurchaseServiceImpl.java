package it.unical.asd.group6.computerSparePartsCompany.core.services.implemented;

import it.unical.asd.group6.computerSparePartsCompany.data.dao.PurchaseDao;
import it.unical.asd.group6.computerSparePartsCompany.data.dto.OrderRequestDTO;
import it.unical.asd.group6.computerSparePartsCompany.data.dto.PurchaseDTO;
import it.unical.asd.group6.computerSparePartsCompany.data.entities.Customer;
import it.unical.asd.group6.computerSparePartsCompany.data.entities.Purchase;
import it.unical.asd.group6.computerSparePartsCompany.core.services.PurchaseService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PurchaseServiceImpl implements PurchaseService {

    @Autowired
    PurchaseDao purchaseDao;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public Boolean registerNewPurchase(Purchase purchase) {
        purchaseDao.save(purchase);
        return true;
    }

    @Override
    public List<PurchaseDTO> getAll(){
        List<Purchase> purchases = purchaseDao.findAll();
        return purchases.stream().map(cat -> modelMapper.map(cat, PurchaseDTO.class)).collect(Collectors.toList());
    }

    @Override
    public Boolean add(Purchase p)
    {
        purchaseDao.save(p);
        return true;
    }

    @Override
    public List<PurchaseDTO> getAllByCustomer(Customer c){
        List<Purchase> purchases = purchaseDao.findAllByCustomer(c);
        return purchases.stream().map(cat -> modelMapper.map(cat, PurchaseDTO.class)).collect(Collectors.toList());
    }

    @Override
    public List<PurchaseDTO> getAllByFilters(String username, LocalDate l) {
        List<Purchase> purchases = purchaseDao.getByFilters(username,l);
        return purchases.stream().map(cat -> modelMapper.map(cat, PurchaseDTO.class)).collect(Collectors.toList());
    }

    @Override
    public List<PurchaseDTO> getAllPurchases() {
        List<Purchase> purchases = purchaseDao.findAll();
        return purchases.stream().map(cat -> modelMapper.map(cat, PurchaseDTO.class)).collect(Collectors.toList());
    }
}
