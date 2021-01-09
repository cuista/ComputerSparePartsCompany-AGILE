package it.unical.asd.group6.computerSparePartsCompany.data.dto;

import it.unical.asd.group6.computerSparePartsCompany.data.entities.OrderRequest;

import java.util.ArrayList;
import java.util.List;

public class ProductionHouseDTO {

    private Long id;

    private String name;

    private List<OrderRequest> orderRequestsReceived=new ArrayList<>();

    public ProductionHouseDTO() {}

    public ProductionHouseDTO(Long id, String name, List<OrderRequest> orderRequestsReceived) {
        this.id = id;
        this.name = name;
        this.orderRequestsReceived = orderRequestsReceived;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<OrderRequest> getOrderRequestsReceived() {
        return orderRequestsReceived;
    }

    public void setOrderRequestsReceived(List<OrderRequest> orderRequestsReceived) {
        this.orderRequestsReceived = orderRequestsReceived;
    }
}
