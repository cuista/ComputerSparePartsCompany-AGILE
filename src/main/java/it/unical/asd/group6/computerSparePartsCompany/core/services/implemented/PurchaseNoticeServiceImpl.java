package it.unical.asd.group6.computerSparePartsCompany.core.services.implemented;

import it.unical.asd.group6.computerSparePartsCompany.data.dao.PurchaseNoticeDao;
import it.unical.asd.group6.computerSparePartsCompany.data.entities.PurchaseNotice;
import it.unical.asd.group6.computerSparePartsCompany.core.services.PurchaseNoticeService;
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

    @Override
    public Boolean add(PurchaseNotice p)
    {
        purchaseNoticeDao.save(p);
        return true;
    }

    @Override
    public List<PurchaseNotice>getAll()
    {
        return purchaseNoticeDao.findAll();
    }
}
