package it.unical.asd.group6.computerSparePartsCompany.controller;

import it.unical.asd.group6.computerSparePartsCompany.core.services.implemented.CustomerServiceImpl;
import it.unical.asd.group6.computerSparePartsCompany.core.services.implemented.PurchaseNoticeServiceImpl;
import it.unical.asd.group6.computerSparePartsCompany.core.services.implemented.WarehouseServiceImpl;
import it.unical.asd.group6.computerSparePartsCompany.data.dto.CustomerDTO;
import it.unical.asd.group6.computerSparePartsCompany.data.dto.PurchaseNoticeDTO;
import it.unical.asd.group6.computerSparePartsCompany.data.entities.Customer;
import it.unical.asd.group6.computerSparePartsCompany.data.entities.PurchaseNotice;
import it.unical.asd.group6.computerSparePartsCompany.data.entities.Warehouse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/purchaseNotice")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PurchaseNoticeController {

    @Autowired
    PurchaseNoticeServiceImpl purchaseNoticeService;

    @Autowired
    CustomerServiceImpl customerService;

    @Autowired
    WarehouseServiceImpl warehouseService;


    @GetMapping("/all-noticeViews")
    public ResponseEntity<List<PurchaseNoticeDTO>> getView() {
        List<PurchaseNoticeDTO> purchaseNotices = purchaseNoticeService.getView();

        return ResponseEntity.ok(purchaseNotices);
    }

    @PostMapping("/add-notice")
    public ResponseEntity<Boolean>addNotice(@RequestParam String date, @RequestParam String username,@RequestParam String idWarehouse,@RequestParam String brand, @RequestParam String model,@RequestParam String quantity)
    {

        //FIXME SPOSTARE L'IMPLEMENTAZIONE NEL SERVICE RISPETTIVO ALTRIMENTI KAISERS

        /*devo capire come funziona praticamente la conversione da string a date*/
        PurchaseNotice p = new PurchaseNotice();
        p.setCollectionDate(LocalDate.parse(date));
        Optional<CustomerDTO> c = customerService.getCustomerByUsername(username);
        if(c.isPresent())
             p.setCustomer(c);
        Warehouse w = warehouseService.getWarehouseById(Long.parseLong(idWarehouse));
        p.setWarehouse(w);
        p.setProductModel(model);
        p.setProductBrand(brand);
        p.setQuantity(Integer.parseInt(quantity));
        purchaseNoticeService.add(p);
        return ResponseEntity.ok(true);
    }

    @GetMapping("all-by-customer")
    public ResponseEntity<List<PurchaseNoticeDTO>> getAllByCustomer(@RequestParam String customerUsername) {

        return ResponseEntity.ok(purchaseNoticeService.getAllByCustomer(customerUsername));
    }

    @GetMapping("/all-by-filters")
    public ResponseEntity<List<PurchaseNoticeDTO>>getAllByFilters(@RequestParam(required = false)String username,@RequestParam(required = false)String date)
    {
        LocalDate l = null;
        if(date!=null)
            l = LocalDate.parse(date);

        List<PurchaseNoticeDTO> purchaseNoticesByFilters=purchaseNoticeService.getAllPurchaseNoticeByFilters(username,l);

        return ResponseEntity.ok(purchaseNoticesByFilters);
    }
}
