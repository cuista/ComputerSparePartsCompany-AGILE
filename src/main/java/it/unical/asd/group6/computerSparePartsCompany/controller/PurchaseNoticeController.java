package it.unical.asd.group6.computerSparePartsCompany.controller;

import it.unical.asd.group6.computerSparePartsCompany.core.service.PurchaseNoticeService;
import it.unical.asd.group6.computerSparePartsCompany.data.entities.PurchaseNotice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/purchaseNotice")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PurchaseNoticeController {

    @Autowired
    private PurchaseNoticeService purchaseNoticeService;

    @GetMapping("/noticeView")
    public ResponseEntity<List<PurchaseNotice>> getView() {
        return ResponseEntity.ok(purchaseNoticeService.getView());
    }
}
