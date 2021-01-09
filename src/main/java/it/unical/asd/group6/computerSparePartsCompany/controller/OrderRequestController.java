package it.unical.asd.group6.computerSparePartsCompany.controller;

import it.unical.asd.group6.computerSparePartsCompany.core.services.OrderRequestService;
import it.unical.asd.group6.computerSparePartsCompany.core.services.ProductService;
import it.unical.asd.group6.computerSparePartsCompany.core.services.ProductionHouseService;
import it.unical.asd.group6.computerSparePartsCompany.core.services.WarehouseService;
import it.unical.asd.group6.computerSparePartsCompany.data.dto.OrderRequestDTO;
import it.unical.asd.group6.computerSparePartsCompany.data.entities.OrderRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order-requests")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class OrderRequestController {

    @Autowired
    WarehouseService warehouseService;

    @Autowired
    ProductionHouseService productionHouseService;

    @Autowired
    OrderRequestService orderRequestService;

    @Autowired
    ProductService productService;

    @GetMapping("/get-all-orderRequests")
    public ResponseEntity<List<OrderRequestDTO>> getAllOrderRequests(){
        return ResponseEntity.ok(orderRequestService.getAllOrderRequests());
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderRequestDTO> getOrderRequestById(@PathVariable String id){

        OrderRequestDTO orderRequest=orderRequestService.getOrderRequestById(Long.parseLong(id));

        return ResponseEntity.ok(orderRequest);
    }

    @PostMapping("/save-orderRequest")
    public ResponseEntity<OrderRequestDTO> addOrderRequest(@RequestParam String warehouse, @RequestParam String prodHouse,
                                                        @RequestParam String productBrand, @RequestParam String productModel,
                                                        @RequestParam Integer productQuantity){

        OrderRequest orderRequest = new OrderRequest();

        orderRequest.setWarehouse(warehouseService.getWarehouseById(Long.parseLong(warehouse)));
        orderRequest.setProductionHouse(productionHouseService.searchEntityByName(prodHouse).get());

        orderRequest.setProductBrand(productBrand);
        orderRequest.setProductModel(productModel);
        orderRequest.setProductQuantity(productQuantity);

        orderRequestService.saveOrderRequest(orderRequest);

        return new ResponseEntity<>(HttpStatus.OK);

    }

    @GetMapping("/{warehouse}/get-all-requested-products")
    public ResponseEntity<List<OrderRequestDTO>> getAllOrderedProductsFromAWarehouse(@PathVariable String warehouse){
        List<OrderRequestDTO> orderRequestsSent = orderRequestService.getAllOrderRequestsForWarehouse(Long.parseLong(warehouse));

        return ResponseEntity.ok(orderRequestsSent);

    }

    /*@DeleteMapping("/{id}") //NON IMPLEMENTATA
    public ResponseEntity<Long> deleteOrderRequest(@PathVariable String id){

        return null;

    }*/

}