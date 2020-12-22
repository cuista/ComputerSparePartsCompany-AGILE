package it.unical.asd.group6.computerSparePartsCompany.core.services.implemented;

import it.unical.asd.group6.computerSparePartsCompany.data.dao.PurchaseDao;
import it.unical.asd.group6.computerSparePartsCompany.data.entities.Purchase;
import it.unical.asd.group6.computerSparePartsCompany.core.services.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PurchaseServiceImpl implements PurchaseService {

    @Autowired
    PurchaseDao purchaseDao;

    @Override
    public Boolean registerNewPurchase(Purchase purchase) {
        purchaseDao.save(purchase);
        return true;
    }
}
