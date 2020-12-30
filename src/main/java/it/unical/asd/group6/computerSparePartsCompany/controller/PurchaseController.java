package it.unical.asd.group6.computerSparePartsCompany.controller;

import it.unical.asd.group6.computerSparePartsCompany.core.services.implemented.CustomerServiceImpl;
import it.unical.asd.group6.computerSparePartsCompany.core.services.implemented.ProductServiceImpl;
import it.unical.asd.group6.computerSparePartsCompany.core.services.implemented.PurchaseServiceImpl;
import it.unical.asd.group6.computerSparePartsCompany.core.services.implemented.WarehouseServiceImpl;
import it.unical.asd.group6.computerSparePartsCompany.data.entities.Product;
import it.unical.asd.group6.computerSparePartsCompany.data.entities.Purchase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/purchase")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PurchaseController {

    @Autowired
    ProductServiceImpl productService;

    @Autowired
    CustomerServiceImpl customerService;

    @Autowired
    PurchaseServiceImpl purchaseService;

    @Autowired
    WarehouseServiceImpl warehouseService;

    @PostMapping("/savePurchase")
    public ResponseEntity<Boolean> addPurchase(@RequestBody Purchase purchase) {
        return ResponseEntity.ok(purchaseService.registerNewPurchase(purchase));
    }

    @PostMapping("/savePurchase-by-parameters")
    public ResponseEntity<Purchase> addPurchase(@RequestParam Long customerId, @RequestParam String date,
                                                @RequestBody List<Long> productsId,@RequestParam Double price,
                                                @RequestParam Long warehouse){

        Purchase purchase = new Purchase();
        purchase.setCustomer(customerService.getCustomerById(customerId).get());
        purchase.setDate(LocalDate.parse(date));
        for (Long id: productsId){
            Product p=productService.getProductById(id);
            if (p!=null && p.getPurchase()==null) {
                purchase.addProducts(p);
            }
        }

        purchase.setTotalPrice(price);
        purchase.setWarehouse(warehouseService.getWarehouseById(warehouse));

        purchaseService.registerNewPurchase(purchase);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/get-all-purchases")
    public ResponseEntity<List<Purchase>> getAllPurchases(){

        return ResponseEntity.ok(purchaseService.getAllPurchases());

    }
}
