package it.unical.asd.group6.computerSparePartsCompany.core.services;

import it.unical.asd.group6.computerSparePartsCompany.data.entities.PurchaseNotice;

import java.util.List;

public interface PurchaseNoticeService {
    List<PurchaseNotice> getView();
    Boolean add(PurchaseNotice p);
    List<PurchaseNotice> getAll();
}
