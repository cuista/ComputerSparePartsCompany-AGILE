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
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderRequestServiceImpl implements OrderRequestService {

    @Autowired
    OrderRequestDao orderRequestDao;

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
    public Optional<OrderRequest> getOrderRequestEntityById(Long id) {
        return orderRequestDao.findById(id);
    }

    @Override
    public OrderRequestDTO saveOrderRequest(OrderRequest orderRequest) {
        OrderRequest orderReq = orderRequestDao.save(orderRequest);
        return modelMapper.map(orderReq, OrderRequestDTO.class);
    }

    @Override
    public List<OrderRequestDTO> getAllOrderRequestsForWarehouse(Long warehouse_id) {
        List<OrderRequest> orderRequests = orderRequestDao.findAllByWarehouse_Id(warehouse_id).orElseThrow(() -> new NoOrderRequestsSentForWarehouseException(warehouse_id));
        return orderRequests.stream().map(cat -> modelMapper.map(cat, OrderRequestDTO.class)).collect(Collectors.toList());
    }
}
