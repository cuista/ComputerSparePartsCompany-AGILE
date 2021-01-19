package it.unical.asd.group6.computerSparePartsCompany.core.services.implemented;

import it.unical.asd.group6.computerSparePartsCompany.data.dao.PurchaseNoticeDao;
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
    ModelMapper modelMapper;

    @Override
    public List<PurchaseNoticeDTO> getView() {
        List<PurchaseNoticeDTO> purchaseNoticeDTOS = purchaseNoticeDao.findAll()
                .stream().map(pn -> modelMapper.map(pn, PurchaseNoticeDTO.class)).collect(Collectors.toList());
        return purchaseNoticeDTOS;

    }

    @Override
    public Boolean add(PurchaseNotice p) {
        purchaseNoticeDao.save(p);
        return true;
    }

    @Override
    public List<PurchaseNoticeDTO> getAll() {
        List<PurchaseNoticeDTO> purchaseNoticeDTOS = purchaseNoticeDao.findAll()
                .stream().map(pn -> modelMapper.map(pn, PurchaseNoticeDTO.class)).collect(Collectors.toList());
        return purchaseNoticeDTOS;
    }

    @Override
    public List<PurchaseNoticeDTO> getAllByCustomer(Customer c) {
        List<PurchaseNoticeDTO> noticeDTOS = purchaseNoticeDao.findAllByCustomer(c)
                .stream().map(pn -> modelMapper.map(pn, PurchaseNoticeDTO.class)).collect(Collectors.toList());
        return noticeDTOS;
    }

    @Override
    public List<PurchaseNoticeDTO> getAllPurchaseNoticeByFilters(String username, LocalDate l) {
        List<PurchaseNoticeDTO> purchaseNoticeDTOS = purchaseNoticeDao.getByFilters(username,l)
                .stream().map(pn -> modelMapper.map(pn, PurchaseNoticeDTO.class)).collect(Collectors.toList());
        return purchaseNoticeDTOS;
    }


}
