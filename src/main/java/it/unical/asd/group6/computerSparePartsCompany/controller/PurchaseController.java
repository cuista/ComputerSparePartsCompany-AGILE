package it.unical.asd.group6.computerSparePartsCompany.controller;

import it.unical.asd.group6.computerSparePartsCompany.core.services.CustomerService;
import it.unical.asd.group6.computerSparePartsCompany.core.services.implemented.*;
import it.unical.asd.group6.computerSparePartsCompany.data.dto.ProductDTO;
import it.unical.asd.group6.computerSparePartsCompany.data.dto.PurchaseDTO;
import it.unical.asd.group6.computerSparePartsCompany.data.entities.*;
import it.unical.asd.group6.computerSparePartsCompany.core.services.CustomerService;
import it.unical.asd.group6.computerSparePartsCompany.core.services.ProductService;
import it.unical.asd.group6.computerSparePartsCompany.core.services.PurchaseService;
import it.unical.asd.group6.computerSparePartsCompany.core.services.WarehouseService;
import it.unical.asd.group6.computerSparePartsCompany.data.entities.Product;
import it.unical.asd.group6.computerSparePartsCompany.data.entities.Purchase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/purchase")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PurchaseController {

    @Autowired
    private PurchaseService purchaseService;

    @Autowired
    CustomerServiceImpl customerService;

    @Autowired
    WarehouseServiceImpl warehouseService;

    @Autowired
    ProductServiceImpl productService;

    @Autowired
    private EmployeeServiceImpl employeeService;

    @PostMapping("/savePurchase") //** e
    public ResponseEntity<Boolean> addPurchase(@RequestBody Purchase purchase,
                                               @RequestParam String username, @RequestParam String password) {
        if (!employeeService.checkLogin(username, password)){
            throw new ResponseStatusException(HttpStatus.FORBIDDEN);
        }
        return ResponseEntity.ok(purchaseService.registerNewPurchase(purchase));
    }

    @PostMapping("/add") //** e
    public ResponseEntity<Boolean> add(@RequestParam String username, @RequestParam String price,
                                       @RequestParam String date, @RequestParam String id,
                                       @RequestParam String usernameEmployee, @RequestParam String passwordEmployee) {
        if (!employeeService.checkLogin(usernameEmployee, passwordEmployee)){
            throw new ResponseStatusException(HttpStatus.FORBIDDEN);
        }
        Purchase p = new Purchase();
        Optional<Customer> c = customerService.getCustomerEntityByUsername(username);



        /*if(c.isPresent())
            p.setCustomer(c.get());
        p.setDate(LocalDate.parse(date));
        p.setTotalPrice(Double.parseDouble(price));
        String[]ids = id.split("-");

        for(int i = 0; i<ids.length; i++) {
            Optional<Product> m = productService.getById(Long.parseLong(ids[i]));
            if(m.isPresent())
                p.addProducts(m.get());
        }
        purchaseService.add(p);*/
        return ResponseEntity.ok(true);
    }

    @GetMapping("/all") //** e
    public ResponseEntity<List<PurchaseDTO>> getAll(@RequestParam String username, @RequestParam String password) {
        if (!employeeService.checkLogin(username, password)){
            throw new ResponseStatusException(HttpStatus.FORBIDDEN);
        }
        return ResponseEntity.ok(purchaseService.getAll());
    }

    @GetMapping("/all-by-customer")
    public ResponseEntity<List<PurchaseDTO>>getAllByCustomer(@RequestParam String username) {
        return ResponseEntity.ok(purchaseService.getAllByCustomer(customerService.getCustomerEntityByUsername(username).get()));
    }

    @GetMapping("/all-by-filters")
    public ResponseEntity<List<PurchaseDTO>>getAllByFilters(@RequestParam(required = false)String username, @RequestParam(required = false)String date) {
        LocalDate l = null;
        if(date!=null)
            l = LocalDate.parse(date);
        return ResponseEntity.ok(purchaseService.getAllByFilters(username,l));
    }


    @PostMapping("/savePurchase-by-parameters") //** c
    public ResponseEntity<Boolean> addPurchase(@RequestParam Long customerId, @RequestParam String date,
                                                @RequestBody List<Long> productsId,@RequestParam Double price,
                                                @RequestParam Long warehouse,@RequestParam String username,
                                               @RequestParam String password){

        if (!employeeService.checkLogin(username, password)){
            throw new ResponseStatusException(HttpStatus.FORBIDDEN);
        }

        Purchase purchase = new Purchase();
        purchase.setCustomer(customerService.getCustomerEntityById(customerId).get());
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

    @GetMapping("/get-all-purchases") //** e
    public ResponseEntity<List<PurchaseDTO>> getAllPurchases(@RequestParam String username, @RequestParam String password){
        if (!employeeService.checkLogin(username, password)){
            throw new ResponseStatusException(HttpStatus.FORBIDDEN);
        }
        return ResponseEntity.ok(purchaseService.getAllPurchases());

    }

    @GetMapping("/{purchaseId}/products-purchased")
    public ResponseEntity<List<ProductDTO>> getAllPurchasedProductForAPurchase(@PathVariable String purchaseId){

        return ResponseEntity.ok(productService.getAllProductsForAPurchase(Long.parseLong(purchaseId)));
    }

    @GetMapping("/get-all-purchased-products")
    public ResponseEntity<List<ProductDTO>> getAllPurchasedProduct(){
        return ResponseEntity.ok(productService.getAllPurchasedProducts());
    }
}
