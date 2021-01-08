package it.unical.asd.group6.computerSparePartsCompany.core.services;

import it.unical.asd.group6.computerSparePartsCompany.data.dto.PurchaseNoticeDTO;
import it.unical.asd.group6.computerSparePartsCompany.data.entities.Customer;
import it.unical.asd.group6.computerSparePartsCompany.data.entities.PurchaseNotice;

import java.time.LocalDate;
import java.util.List;

public interface PurchaseNoticeService {
    List<PurchaseNoticeDTO> getView();
    Boolean add(PurchaseNotice p);
    List<PurchaseNoticeDTO> getAll();
    List<PurchaseNoticeDTO> getAllByCustomer(String username);
    List<PurchaseNoticeDTO>getAllPurchaseNoticeByFilters(String username, LocalDate l);

}
