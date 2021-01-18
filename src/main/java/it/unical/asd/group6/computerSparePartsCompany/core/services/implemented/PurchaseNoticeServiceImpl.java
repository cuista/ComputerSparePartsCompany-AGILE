package it.unical.asd.group6.computerSparePartsCompany.core.services.implemented;

import it.unical.asd.group6.computerSparePartsCompany.core.exception.CustomerByUsernameNotFoundException;
import it.unical.asd.group6.computerSparePartsCompany.data.dao.CustomerDao;
import it.unical.asd.group6.computerSparePartsCompany.data.dao.PurchaseNoticeDao;
<<<<<<< HEAD
import it.unical.asd.group6.computerSparePartsCompany.data.dto.CustomerDTO;
=======
import it.unical.asd.group6.computerSparePartsCompany.data.dto.CategoryDTO;
>>>>>>> 9f8aaaa27c6ce0974dbf17a8841236d3b640bbb7
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
<<<<<<< HEAD
    CustomerDao customerDao;

    @Autowired
    ModelMapper mapper;

    @Override
    public List<PurchaseNoticeDTO> getView() {

        List<PurchaseNotice> purchaseNotices = purchaseNoticeDao.findAll();



        return purchaseNotices.stream().map(purchaseNotice -> mapper.map(purchaseNotice, PurchaseNoticeDTO.class)).collect(Collectors.toList());
=======
    ModelMapper modelMapper;

    @Override
    public List<PurchaseNoticeDTO> getView() {
        List<PurchaseNoticeDTO> purchaseNoticeDTOS = purchaseNoticeDao.findAll()
                .stream().map(pn -> modelMapper.map(pn, PurchaseNoticeDTO.class)).collect(Collectors.toList());
        return purchaseNoticeDTOS;
>>>>>>> 9f8aaaa27c6ce0974dbf17a8841236d3b640bbb7
    }

    @Override
    public Boolean add(PurchaseNotice p) {
        purchaseNoticeDao.save(p);
        return true;
    }

    @Override
    public List<PurchaseNoticeDTO> getAll() {
<<<<<<< HEAD

        List<PurchaseNotice> purchaseNotices = purchaseNoticeDao.findAll();

        return purchaseNotices.stream().map(purchaseNotice -> mapper.map(purchaseNotice,PurchaseNoticeDTO.class)).collect(Collectors.toList());
    }

    @Override
    public List<PurchaseNoticeDTO> getAllByCustomer(String customerUsername) {

        Customer c = customerDao.findCustomerByUsername(customerUsername).orElseThrow(() -> new CustomerByUsernameNotFoundException(customerUsername));

        List<PurchaseNotice> purchaseNotices = purchaseNoticeDao.findAllByCustomer(c);

        return purchaseNotices.stream().map(purchaseNotice -> mapper.map(purchaseNotice,PurchaseNoticeDTO.class)).collect(Collectors.toList());
=======
        List<PurchaseNoticeDTO> purchaseNoticeDTOS = purchaseNoticeDao.findAll()
                .stream().map(pn -> modelMapper.map(pn, PurchaseNoticeDTO.class)).collect(Collectors.toList());
        return purchaseNoticeDTOS;
    }

    @Override
    public List<PurchaseNoticeDTO> getAllByCustomer(Customer c) {
        List<PurchaseNoticeDTO> noticeDTOS = purchaseNoticeDao.findAllByCustomer(c)
                .stream().map(pn -> modelMapper.map(pn, PurchaseNoticeDTO.class)).collect(Collectors.toList());
        return noticeDTOS;
>>>>>>> 9f8aaaa27c6ce0974dbf17a8841236d3b640bbb7
    }

    @Override
    public List<PurchaseNoticeDTO> getAllPurchaseNoticeByFilters(String username, LocalDate l) {
<<<<<<< HEAD

        List<PurchaseNotice> purchaseNotices = purchaseNoticeDao.getByFilters(username,l);

        return purchaseNotices.stream().map(purchNot -> mapper.map(purchNot, PurchaseNoticeDTO.class)).collect(Collectors.toList());
=======
        List<PurchaseNoticeDTO> purchaseNoticeDTOS = purchaseNoticeDao.getByFilters(username,l)
                .stream().map(pn -> modelMapper.map(pn, PurchaseNoticeDTO.class)).collect(Collectors.toList());
        return purchaseNoticeDTOS;
>>>>>>> 9f8aaaa27c6ce0974dbf17a8841236d3b640bbb7
    }


}
