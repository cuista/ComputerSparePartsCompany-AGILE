package it.unical.asd.group6.computerSparePartsCompany.core.services;

import it.unical.asd.group6.computerSparePartsCompany.data.dto.OrderRequestDTO;
import it.unical.asd.group6.computerSparePartsCompany.data.entities.OrderRequest;

import java.util.List;

public interface OrderRequestService {

    public List<OrderRequestDTO> getAllOrderRequests();

    public OrderRequestDTO getOrderRequestById(Long id);

    public OrderRequest saveOrderRequest(OrderRequest orderRequest);

    List<OrderRequestDTO> getAllOrderRequestsForWarehouse(Long parseLong);
}
