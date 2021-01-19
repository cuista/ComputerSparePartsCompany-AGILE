package it.unical.asd.group6.computerSparePartsCompany.controller;

import it.unical.asd.group6.computerSparePartsCompany.core.services.OrderRequestService;
import it.unical.asd.group6.computerSparePartsCompany.core.services.ProductService;
import it.unical.asd.group6.computerSparePartsCompany.core.services.ProductionHouseService;
import it.unical.asd.group6.computerSparePartsCompany.core.services.WarehouseService;
import it.unical.asd.group6.computerSparePartsCompany.core.services.implemented.EmployeeServiceImpl;
import it.unical.asd.group6.computerSparePartsCompany.data.dto.OrderRequestDTO;
import it.unical.asd.group6.computerSparePartsCompany.data.entities.OrderRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/order-requests")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class OrderRequestController {

    @Autowired
    private WarehouseService warehouseService;

    @Autowired
    private ProductionHouseService productionHouseService;

    @Autowired
    private OrderRequestService orderRequestService;

    @Autowired
    private ProductService productService;

    @Autowired
    private EmployeeServiceImpl employeeService;

    @GetMapping("/get-all-orderRequests") //** e
    public ResponseEntity<List<OrderRequestDTO>> getAllOrderRequests(@RequestParam String username,
                                                                     @RequestParam String password){
        if (!employeeService.checkLogin(username, password)){
            throw new ResponseStatusException(HttpStatus.FORBIDDEN);
        }
        return ResponseEntity.ok(orderRequestService.getAllOrderRequests());
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderRequestDTO> getOrderRequestById(@PathVariable String id){

        OrderRequestDTO orderRequest=orderRequestService.getOrderRequestById(Long.parseLong(id));

        return ResponseEntity.ok(orderRequest);
    }

    @PostMapping("/save-orderRequest") //** e
    public ResponseEntity<OrderRequestDTO> addOrderRequest(@RequestParam String warehouse, @RequestParam String prodHouse,
                                                        @RequestParam String productBrand, @RequestParam String productModel,
                                                        @RequestParam Integer productQuantity, @RequestParam String username,
                                                           @RequestParam String password){

        if (!employeeService.checkLogin(username, password)){
            throw new ResponseStatusException(HttpStatus.FORBIDDEN);
        }

        OrderRequest orderRequest = new OrderRequest();

        orderRequest.setWarehouse(warehouseService.getWarehouseById(Long.parseLong(warehouse))); //TODO PROBABILE REFACTOR
        orderRequest.setProductionHouse(productionHouseService.searchEntityByName(prodHouse).get()); //TODO PROBAILE REFACTOR
        orderRequest.setProductBrand(productBrand);
        orderRequest.setProductModel(productModel);
        orderRequest.setProductQuantity(productQuantity);

        orderRequestService.saveOrderRequest(orderRequest);

        return new ResponseEntity<>(HttpStatus.OK);

    }

    @GetMapping("/{warehouse}/get-all-requested-products") //** e
    public ResponseEntity<List<OrderRequestDTO>> getAllOrderedProductsFromAWarehouse(@PathVariable String warehouse,
                                                                                     @RequestParam String username,
                                                                                     @RequestParam String password){

        if (!employeeService.checkLogin(username, password)){
            throw new ResponseStatusException(HttpStatus.FORBIDDEN);
        }

        List<OrderRequestDTO> orderRequestsSent = orderRequestService.getAllOrderRequestsForWarehouse(Long.parseLong(warehouse));

        return ResponseEntity.ok(orderRequestsSent);

    }

    /*@DeleteMapping("/{id}") //NON IMPLEMENTATA
    public ResponseEntity<Long> deleteOrderRequest(@PathVariable String id){

        return null;

    }*/

}
