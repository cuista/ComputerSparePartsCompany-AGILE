package it.unical.asd.group6.computerSparePartsCompany.controller;

import it.unical.asd.group6.computerSparePartsCompany.core.services.implemented.CustomerServiceImpl;
import it.unical.asd.group6.computerSparePartsCompany.core.services.implemented.WarehouseServiceImpl;
import it.unical.asd.group6.computerSparePartsCompany.data.entities.Customer;
import it.unical.asd.group6.computerSparePartsCompany.data.entities.PurchaseNotice;
import it.unical.asd.group6.computerSparePartsCompany.core.services.implemented.PurchaseNoticeServiceImpl;
import it.unical.asd.group6.computerSparePartsCompany.data.entities.Warehouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

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


    @GetMapping("/noticeView")
    public ResponseEntity<List<PurchaseNotice>> getView() {
        return ResponseEntity.ok(purchaseNoticeService.getView());
    }

    @PostMapping("/add-notice")
    public ResponseEntity<Boolean>addNotice(@RequestParam String date, @RequestParam String username,@RequestParam String idWarehouse,@RequestParam String brand, @RequestParam String model,@RequestParam String quantity)
    {
        /*devo capire come funziona praticamente la conversione da string a date*/
        PurchaseNotice p = new PurchaseNotice();
        p.setCollectionDate(LocalDate.parse(date));
        Optional<Customer> c = customerService.getCustomerByUsername(username);
        if(c.isPresent())
             p.setCustomer(c.get());
        Warehouse w = warehouseService.getWarehouseById(Long.parseLong(idWarehouse));
        p.setWarehouse(w);
        p.setProductModel(model);
        p.setProductBrand(brand);
        p.setQuantity(Integer.parseInt(quantity));
        purchaseNoticeService.add(p);
        return ResponseEntity.ok(true);
    }

    @GetMapping("/all")
    public List<PurchaseNotice> getAll()
    {
        return purchaseNoticeService.getAll();
    }

    @GetMapping("all-by-customer")
    public List<PurchaseNotice>getAllByCustomer(@RequestParam String username)
    {
        return purchaseNoticeService.getAllByCustomer(customerService.getCustomerByUsername(username).get());
    }
}
