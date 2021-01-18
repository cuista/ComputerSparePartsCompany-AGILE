package it.unical.asd.group6.computerSparePartsCompany.core.services;

import it.unical.asd.group6.computerSparePartsCompany.data.dto.OrderRequestDTO;
import it.unical.asd.group6.computerSparePartsCompany.data.entities.OrderRequest;

import java.util.List;
import java.util.Optional;

public interface OrderRequestService {

    public List<OrderRequestDTO> getAllOrderRequests();

    public OrderRequestDTO getOrderRequestById(Long id);

    Optional<OrderRequest> getOrderRequestEntityById(Long id);

    public OrderRequestDTO saveOrderRequest(OrderRequest orderRequest);

    List<OrderRequestDTO> getAllOrderRequestsForWarehouse(Long parseLong);
}
