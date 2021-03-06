package it.unical.asd.group6.computerSparePartsCompany.controller;

import it.unical.asd.group6.computerSparePartsCompany.core.exception.customer.CustomerByUsernameNotFoundOnRetrieveException;
import it.unical.asd.group6.computerSparePartsCompany.core.services.implemented.CustomerServiceImpl;
import it.unical.asd.group6.computerSparePartsCompany.core.services.implemented.EmployeeServiceImpl;
import it.unical.asd.group6.computerSparePartsCompany.data.dto.CustomerDTO;
import it.unical.asd.group6.computerSparePartsCompany.data.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/customer")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CustomerController {

    @Autowired
    private CustomerServiceImpl customerService;

    @Autowired
    private EmployeeServiceImpl employeeService;

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
        return ResponseEntity.ok(customerService.createNewCustomer(name,surname,phoneNumber,email,username,password,vatID));
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
    public ResponseEntity<List<CustomerDTO>> allCustomers() {

        List<CustomerDTO> customers = customerService.getAllCustomer();

        return ResponseEntity.ok(customers);
    }

    @GetMapping("/stringtest")
    public ResponseEntity<String> stringtest() {
        return ResponseEntity.ok(String.format("this is a string"));
    }

    @GetMapping("/by-username") //*** c
    public ResponseEntity<CustomerDTO> getCustomerByUsername(@RequestParam String username,
                                                             @RequestParam String password) {
        if(!customerService.checkLogin(username,password)) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN);
        }
        CustomerDTO customer = customerService.getCustomerByUsername(username).get();

        return ResponseEntity.ok(customer);
    }

    @DeleteMapping("/del-customer")
    public ResponseEntity<Boolean> deleteCustomer(@RequestParam String username, @RequestParam String password) {
        if(!customerService.checkLogin(username,password)) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN);
        }
        return ResponseEntity.ok(customerService.deleteCustomer(username));
    }

    @GetMapping("/report-totalpurchases") //** c
    public ResponseEntity<Integer> getTotalPurchases(@RequestParam String username, @RequestParam String password){
        if(!customerService.checkLogin(username,password)) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN);
        }
        return ResponseEntity.ok(customerService.getReportTotalPurchases(username));
    }

    @GetMapping("/report-totalamount") //** c
    public ResponseEntity<Double> getTotalAmount(@RequestParam String username, @RequestParam String password){
        if(!customerService.checkLogin(username,password)) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN);
        }
        return ResponseEntity.ok(customerService.getReportTotalAmountSpent(username));
    }

    @GetMapping("/report-favoritecategory") //** c
    public ResponseEntity<String> getFavoriteCategory(@RequestParam String username, @RequestParam String password){
        if(!customerService.checkLogin(username,password)) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN);
        }
        return ResponseEntity.ok(customerService.getReportFavoriteCategory(username));
    }

    @PostMapping("/change-password")
    public ResponseEntity<Boolean> changePassword(@RequestParam String username,@RequestParam String password,@RequestParam String oldPassword) {
        if(oldPassword.equals(customerService.getCustomerByUsername(username).get().getPassword()))
            return ResponseEntity.ok(customerService.updateCustomer(username,password));
        else
            return ResponseEntity.ok(false);
    }

    @PostMapping("/update-data")
    public ResponseEntity<Boolean> changeCustomerData(@RequestParam String username, @RequestParam String password,
                                                      @RequestParam String name, @RequestParam String surname,
                                                      @RequestParam String phoneNumber, @RequestParam String iva) {
        if(!customerService.checkLogin(username,password)) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN);
        }
        return ResponseEntity.ok(customerService.updateDataCustomer(username,name,surname,phoneNumber,Long.parseLong(iva)));
    }

    @GetMapping("/all-usernames") //** e
    public ResponseEntity<List<String>>getUsernames() {

        return ResponseEntity.ok(customerService.getAllUsernames());
    }

    @PutMapping("/{username}")
    public ResponseEntity<Customer> updateCustomerWithPut(@RequestBody CustomerDTO newCustomerDTO, @PathVariable String username){

        Optional<CustomerDTO> optionalCustomer = customerService.getCustomerByUsername(username);

        if (!optionalCustomer.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        customerService.updateCustomerInfos(optionalCustomer.get(), newCustomerDTO);
        return new ResponseEntity<>(HttpStatus.OK);

    }
}
