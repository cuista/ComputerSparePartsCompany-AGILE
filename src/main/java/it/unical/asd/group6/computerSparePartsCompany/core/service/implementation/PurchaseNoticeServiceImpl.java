package it.unical.asd.group6.computerSparePartsCompany.core.service.implementation;

import it.unical.asd.group6.computerSparePartsCompany.data.dao.PurchaseNoticeDao;
import it.unical.asd.group6.computerSparePartsCompany.data.entities.PurchaseNotice;
import it.unical.asd.group6.computerSparePartsCompany.core.service.PurchaseNoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseNoticeServiceImpl implements PurchaseNoticeService {

    @Autowired
    PurchaseNoticeDao purchaseNoticeDao;

    @Override
    public List<PurchaseNotice> getView() {
        return purchaseNoticeDao.findAll();
    }
}
