package it.unical.asd.group6.computerSparePartsCompany.core.service;

import it.unical.asd.group6.computerSparePartsCompany.data.entities.OrderRequest;

import java.util.List;

public interface OrderRequestService {

    public List<OrderRequest> getAllOrderRequests();

    public OrderRequest getOrderRequestById(Long id);

    public OrderRequest saveOrderRequest(OrderRequest orderRequest);

    List<OrderRequest> getAllOrderRequestsForWarehouse(Long parseLong);
}
