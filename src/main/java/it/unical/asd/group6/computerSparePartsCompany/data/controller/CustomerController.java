package it.unical.asd.group6.computerSparePartsCompany.data.controller;

import it.unical.asd.group6.computerSparePartsCompany.data.entities.Customer;
import it.unical.asd.group6.computerSparePartsCompany.data.services.implemented.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerServiceImpl customerService;

    @GetMapping("/login")
    public ResponseEntity<Boolean> doLogin(
            @RequestParam("username") String username, @RequestParam("password") String password) {
        return ResponseEntity.ok(customerService.checkLogin(username,password));
    }

    @PostMapping("/register")
    public ResponseEntity<Boolean> doSignUp (
            @RequestParam String name, @RequestParam String surname,
            @RequestParam String phoneNumber, @RequestParam String email,
            @RequestParam String username, @RequestParam String password, @RequestParam Long vatID) {
        Customer cust = new Customer();
        cust.setName(name);
        cust.setSurname(surname);
        cust.setPhoneNumber(phoneNumber);
        cust.setEmail(email);
        cust.setUsername(username);
        cust.setPassword(password);
        cust.setVATIdentificationNumber(vatID);
        return ResponseEntity.ok(customerService.registerNewCustomer(cust));
    }
}
