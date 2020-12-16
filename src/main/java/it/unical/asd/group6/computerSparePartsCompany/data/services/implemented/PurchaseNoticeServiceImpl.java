package it.unical.asd.group6.computerSparePartsCompany.data.services.implemented;

import it.unical.asd.group6.computerSparePartsCompany.data.dao.PurchaseNoticeDao;
import it.unical.asd.group6.computerSparePartsCompany.data.entities.PurchaseNotice;
import it.unical.asd.group6.computerSparePartsCompany.data.services.PurchaseNoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseNoticeServiceImpl implements PurchaseNoticeService {

    @Autowired
    PurchaseNoticeDao purchaseNoticeDao;

    @Override
    public List<PurchaseNotice> getView() {
        return purchaseNoticeDao.findAllOrderByCollectionDate();
    }
}
