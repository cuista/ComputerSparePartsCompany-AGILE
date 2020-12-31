package it.unical.asd.group6.computerSparePartsCompany.controller;

import it.unical.asd.group6.computerSparePartsCompany.core.services.CustomerService;
import it.unical.asd.group6.computerSparePartsCompany.core.services.implemented.CustomerServiceImpl;
import it.unical.asd.group6.computerSparePartsCompany.core.services.implemented.ProductServiceImpl;
import it.unical.asd.group6.computerSparePartsCompany.core.services.implemented.WarehouseServiceImpl;
import it.unical.asd.group6.computerSparePartsCompany.data.entities.Customer;
import it.unical.asd.group6.computerSparePartsCompany.data.entities.Product;
import it.unical.asd.group6.computerSparePartsCompany.data.entities.Purchase;
import it.unical.asd.group6.computerSparePartsCompany.core.services.implemented.PurchaseServiceImpl;
import it.unical.asd.group6.computerSparePartsCompany.data.entities.Warehouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/purchase")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PurchaseController {

    @Autowired
    PurchaseServiceImpl purchaseService;

    @Autowired
    CustomerServiceImpl customerService;

    @Autowired
    WarehouseServiceImpl warehouseService;

    @Autowired
    ProductServiceImpl productService;

    @PostMapping("/savePurchase")
    public ResponseEntity<Boolean> addPurchase(@RequestBody Purchase purchase) {
        return ResponseEntity.ok(purchaseService.registerNewPurchase(purchase));
    }

    @PostMapping("/add")
    public ResponseEntity<Boolean> add(@RequestParam String username, @RequestParam String price, @RequestParam String date, @RequestParam String id)
    {
        Purchase p = new Purchase();
        Optional<Customer> c = customerService.getCustomerByUsername(username);
        if(c.isPresent())
            p.setCustomer(c.get());
        p.setDate(LocalDate.parse(date));
        p.setTotalPrice(Double.parseDouble(price));
        String[]ids = id.split("-");

        for(int i = 0; i<ids.length; i++)
        {
            Optional<Product> m = productService.getById(Long.parseLong(ids[i]));
            if(m.isPresent())
                p.addProducts(m.get());
        }
        purchaseService.add(p);
        return ResponseEntity.ok(true);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Purchase>> getAll()
    {
        return ResponseEntity.ok(purchaseService.getAll());
    }

    @GetMapping("/all-by-customer")
    public ResponseEntity<List<Purchase>>getAllByCustomer(@RequestParam String username)
    {
        return ResponseEntity.ok(purchaseService.getAllByCustomer(customerService.getCustomerByUsername(username).get()));
    }

}
