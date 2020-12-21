package it.unical.asd.group6.computerSparePartsCompany.controller;

import it.unical.asd.group6.computerSparePartsCompany.data.entities.Customer;
import it.unical.asd.group6.computerSparePartsCompany.core.services.implemented.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CustomerController {

    @Autowired
    CustomerServiceImpl customerService;

    @GetMapping("/login")
    public ResponseEntity<Boolean> doLogin(
            @RequestParam("username") String username, @RequestParam("password") String password) {
        return ResponseEntity.ok(customerService.checkLogin(username,password));
    }

    @PostMapping("/register")
    public ResponseEntity<Boolean> doSignUp (@RequestBody Customer customer) {
        return ResponseEntity.ok(customerService.registerNewCustomer(customer));
    }

    @GetMapping
    public ResponseEntity<List<Customer>> allCustomers() {
        return ResponseEntity.ok(customerService.getAllCustomer());
    }
    
    @GetMapping("/stringtest")
    public ResponseEntity<String> stringtest() {
        return ResponseEntity.ok(String.format("this is a string"));
    }
}
