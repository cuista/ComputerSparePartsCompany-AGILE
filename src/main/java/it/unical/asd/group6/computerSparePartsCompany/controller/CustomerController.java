package it.unical.asd.group6.computerSparePartsCompany.controller;

import it.unical.asd.group6.computerSparePartsCompany.data.entities.Customer;
import it.unical.asd.group6.computerSparePartsCompany.core.services.implemented.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @PostMapping("/register-param")
    public ResponseEntity<Boolean> signUp (
            @RequestParam("name") String name, @RequestParam("surname") String surname,
            @RequestParam("phoneNumber") String phoneNumber, @RequestParam("email") String email,
            @RequestParam("username") String username, @RequestParam("password") String password,
            @RequestParam("vatID") Long vatID) {
        Customer customer = new Customer();
        customer.setName(name);
        customer.setSurname(surname);
        customer.setPhoneNumber(phoneNumber);
        customer.setEmail(email);
        customer.setUsername(username);
        customer.setPassword(password);
        customer.setVATIdentificationNumber(vatID);
        System.out.println(customer);
        return ResponseEntity.ok(customerService.registerNewCustomer(customer));
    }

    @DeleteMapping("/delete-customer")
    public ResponseEntity<Customer> delete(Customer customer) {
        return ResponseEntity.ok(customerService.deleteUser(customer));
    }

    @GetMapping("/user-check")
    public ResponseEntity<Boolean> checkUser(@RequestParam("username")String username) {
        return ResponseEntity.ok(customerService.searchByUsername(username));
    }

    @GetMapping("/email-check")
    public ResponseEntity<Boolean> checkEmail(@RequestParam("email")String email) {
        return ResponseEntity.ok(customerService.searchByEmail(email));
    }

    @GetMapping("/all-customers")
    public ResponseEntity<List<Customer>> allCustomers() {
        return ResponseEntity.ok(customerService.getAllCustomer());
    }

    @GetMapping("/stringtest")
    public ResponseEntity<String> stringtest() {
        return ResponseEntity.ok(String.format("this is a string"));
    }

    @GetMapping("/by-username")
    public ResponseEntity<Optional<Customer>> getCustomerByUsername(String username)
    {
        return ResponseEntity.ok(customerService.getCustomerByUsername(username));
    }

    @DeleteMapping("/del-customer")
    public ResponseEntity<Boolean> deleteCustomer(@RequestParam String username) {
        return ResponseEntity.ok(customerService.deleteCustomer(username));
    }

    @GetMapping("/report-totalpurchases")
    public ResponseEntity<Integer> getTotalPurchases(@RequestParam String username){
        return ResponseEntity.ok(customerService.getReportTotalPurchases(username));
    }

    @GetMapping("/report-totalamount")
    public ResponseEntity<Double> getTotalAmount(@RequestParam String username){
        return ResponseEntity.ok(customerService.getReportTotalAmountSpent(username));
    }

    @GetMapping("/report-favoritecategory")
    public ResponseEntity<Long> getFavoriteCategory(@RequestParam String username){
        return ResponseEntity.ok(customerService.getReportFavoriteCategory(username));
    }

    @PostMapping("/change-password")
    public ResponseEntity<Boolean> changePassword(@RequestParam String username,@RequestParam String password)
    {
        return ResponseEntity.ok(customerService.updateCustomer(username,password));
    }
}
