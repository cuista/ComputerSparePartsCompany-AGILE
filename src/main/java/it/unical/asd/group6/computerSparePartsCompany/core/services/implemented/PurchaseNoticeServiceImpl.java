package it.unical.asd.group6.computerSparePartsCompany.core.services.implemented;

import it.unical.asd.group6.computerSparePartsCompany.core.exception.CustomerByUsernameNotFoundException;
import it.unical.asd.group6.computerSparePartsCompany.data.dao.CustomerDao;
import it.unical.asd.group6.computerSparePartsCompany.data.dao.PurchaseNoticeDao;
import it.unical.asd.group6.computerSparePartsCompany.data.dto.CustomerDTO;
import it.unical.asd.group6.computerSparePartsCompany.data.dto.PurchaseNoticeDTO;
import it.unical.asd.group6.computerSparePartsCompany.data.entities.Customer;
import it.unical.asd.group6.computerSparePartsCompany.data.entities.PurchaseNotice;
import it.unical.asd.group6.computerSparePartsCompany.core.services.PurchaseNoticeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PurchaseNoticeServiceImpl implements PurchaseNoticeService {

    @Autowired
    PurchaseNoticeDao purchaseNoticeDao;

    @Autowired
    CustomerDao customerDao;

    @Autowired
    ModelMapper mapper;

    @Override
    public List<PurchaseNoticeDTO> getView() {

        List<PurchaseNotice> purchaseNotices = purchaseNoticeDao.findAll();



        return purchaseNotices.stream().map(purchaseNotice -> mapper.map(purchaseNotice, PurchaseNoticeDTO.class)).collect(Collectors.toList());
    }

    @Override
    public Boolean add(PurchaseNotice p)
    {
        purchaseNoticeDao.save(p);
        return true;
    }

    @Override
    public List<PurchaseNoticeDTO> getAll() {

        List<PurchaseNotice> purchaseNotices = purchaseNoticeDao.findAll();

        return purchaseNotices.stream().map(purchaseNotice -> mapper.map(purchaseNotice,PurchaseNoticeDTO.class)).collect(Collectors.toList());
    }

    @Override
    public List<PurchaseNoticeDTO> getAllByCustomer(String customerUsername) {

        Customer c = customerDao.findCustomerByUsername(customerUsername).orElseThrow(() -> new CustomerByUsernameNotFoundException(customerUsername));

        List<PurchaseNotice> purchaseNotices = purchaseNoticeDao.findAllByCustomer(c);

        return purchaseNotices.stream().map(purchaseNotice -> mapper.map(purchaseNotice,PurchaseNoticeDTO.class)).collect(Collectors.toList());
    }

    @Override
    public List<PurchaseNoticeDTO> getAllPurchaseNoticeByFilters(String username, LocalDate l) {

        List<PurchaseNotice> purchaseNotices = purchaseNoticeDao.getByFilters(username,l);

        return purchaseNotices.stream().map(purchNot -> mapper.map(purchNot, PurchaseNoticeDTO.class)).collect(Collectors.toList());
    }


}
