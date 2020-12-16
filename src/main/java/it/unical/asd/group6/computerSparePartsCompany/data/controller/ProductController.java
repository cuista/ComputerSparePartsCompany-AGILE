package it.unical.asd.group6.computerSparePartsCompany.data.controller;

import it.unical.asd.group6.computerSparePartsCompany.data.entities.Customer;
import it.unical.asd.group6.computerSparePartsCompany.data.entities.Product;
import it.unical.asd.group6.computerSparePartsCompany.data.services.implemented.CustomerServiceImpl;
import it.unical.asd.group6.computerSparePartsCompany.data.services.implemented.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductServiceImpl productService;

    @GetMapping("/showall")
    public ResponseEntity<List<Product>> showAll(){
        return ResponseEntity.ok(productService.getAllProduct());
    }

    @GetMapping("/showallbybrand")
    public ResponseEntity<List<Product>> showAllByBrand(@RequestParam("brand") String brand){
        return ResponseEntity.ok(productService.getAllProductByBrand(brand));
    }

    @GetMapping("/showallbybrandandmodel")
    public ResponseEntity<List<Product>> showAllByBrandAndModel(@RequestParam("brand") String brand, @RequestParam("model") String model){
        return ResponseEntity.ok(productService.getAllProductByBrandAndModel(brand, model));
    }

    @GetMapping("/showallbypriceislessthan")
    public ResponseEntity<List<Product>> showAllByByPriceIsLessThan(@RequestParam("price") Double price){
        return ResponseEntity.ok(productService.getAllProductByPriceIsLessThan(price));
    }
}
