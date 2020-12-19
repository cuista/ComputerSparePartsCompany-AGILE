package it.unical.asd.group6.computerSparePartsCompany.controller;

import it.unical.asd.group6.computerSparePartsCompany.data.entities.Purchase;
import it.unical.asd.group6.computerSparePartsCompany.core.services.implemented.PurchaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/purchase")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PurchaseController {

    @Autowired
    PurchaseServiceImpl purchaseService;

    @PostMapping("/savePurchase")
    public ResponseEntity<Boolean> addPurchase(@RequestBody Purchase purchase) {
        return ResponseEntity.ok(purchaseService.registerNewPurchase(purchase));
    }
}
