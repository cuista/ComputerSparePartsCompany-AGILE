package it.unical.asd.group6.computerSparePartsCompany.data.controller;

import it.unical.asd.group6.computerSparePartsCompany.data.entities.Purchase;
import it.unical.asd.group6.computerSparePartsCompany.data.services.implemented.PurchaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/purchase")
public class PurchaseController {

    @Autowired
    PurchaseServiceImpl purchaseService;

    @PostMapping("/savePurchase")
    public ResponseEntity<Purchase> addPurchase(@RequestBody Purchase purchase) {
        return ResponseEntity.ok(purchaseService.registerNewPurchase(purchase));
    }
}
