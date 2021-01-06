package it.unical.asd.group6.computerSparePartsCompany.core.services.implemented;

import it.unical.asd.group6.computerSparePartsCompany.core.exception.NoOrderRequestsSentForWarehouseException;
import it.unical.asd.group6.computerSparePartsCompany.core.exception.OrderRequestNotFoundException;
import it.unical.asd.group6.computerSparePartsCompany.core.services.OrderRequestService;
import it.unical.asd.group6.computerSparePartsCompany.data.dao.OrderRequestDao;
import it.unical.asd.group6.computerSparePartsCompany.data.dto.CategoryDTO;
import it.unical.asd.group6.computerSparePartsCompany.data.dto.OrderRequestDTO;
import it.unical.asd.group6.computerSparePartsCompany.data.entities.OrderRequest;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderRequestServiceImpl implements OrderRequestService {

    @Autowired
    private OrderRequestDao orderRequestDao;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<OrderRequestDTO> getAllOrderRequests() {
        List<OrderRequest> orderRequests = orderRequestDao.findAll();
        return orderRequests.stream().map(cat -> modelMapper.map(cat, OrderRequestDTO.class)).collect(Collectors.toList());
    }

    @Override
    public OrderRequestDTO getOrderRequestById(Long id) {
        OrderRequest orderRequest = orderRequestDao.findById(id).orElseThrow(()-> new OrderRequestNotFoundException(id));
        return modelMapper.map(orderRequest,OrderRequestDTO.class);
    }

    @Override
    public OrderRequest saveOrderRequest(OrderRequest orderRequest) {
        return orderRequestDao.save(orderRequest);
    }

    @Override
    public List<OrderRequestDTO> getAllOrderRequestsForWarehouse(Long warehouse_id) {
        List<OrderRequest> orderRequests = orderRequestDao.findAllByWarehouse_Id(warehouse_id).orElseThrow(() -> new NoOrderRequestsSentForWarehouseException(warehouse_id));
        return orderRequests.stream().map(cat -> modelMapper.map(cat, OrderRequestDTO.class)).collect(Collectors.toList());
    }
}
