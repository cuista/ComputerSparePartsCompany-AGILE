package it.unical.asd.group6.computerSparePartsCompany.controller;

import it.unical.asd.group6.computerSparePartsCompany.core.services.ProductionHouseService;
import it.unical.asd.group6.computerSparePartsCompany.data.dto.ProductionHouseDTO;
import it.unical.asd.group6.computerSparePartsCompany.data.entities.ProductionHouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/production-houses")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProductionHouseController {

    @Autowired
    private ProductionHouseService productionHouseService;

    @PostMapping("/search-by-name")
    public ResponseEntity<ProductionHouseDTO> searchProductionHouse(@RequestParam(name="name") String name) {
        return ResponseEntity.ok(productionHouseService.searchByName(name));
    }

    @GetMapping("/all-names")
    public ResponseEntity<List<String>>getAllNames()
    {
        return ResponseEntity.ok(productionHouseService.getAllNames());
    }

}
