package it.unical.asd.group6.computerSparePartsCompany.core.services.implemented;

import it.unical.asd.group6.computerSparePartsCompany.core.exception.NoOrderRequestsSentForWarehouseException;
import it.unical.asd.group6.computerSparePartsCompany.core.exception.OrderRequestNotFoundException;
import it.unical.asd.group6.computerSparePartsCompany.core.services.OrderRequestService;
import it.unical.asd.group6.computerSparePartsCompany.data.dao.OrderRequestDao;
import it.unical.asd.group6.computerSparePartsCompany.data.entities.OrderRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderRequestServiceImpl implements OrderRequestService {

    @Autowired
    private OrderRequestDao orderRequestDao;

    @Override
    public List<OrderRequest> getAllOrderRequests() {
        return orderRequestDao.findAll();
    }

    @Override
    public OrderRequest getOrderRequestById(Long id) {
        return orderRequestDao.findById(id).orElseThrow(()-> new OrderRequestNotFoundException(id));
    }

    @Override
    public OrderRequest saveOrderRequest(OrderRequest orderRequest) {
        return orderRequestDao.save(orderRequest);
    }

    @Override
    public List<OrderRequest> getAllOrderRequestsForWarehouse(Long warehouse_id) {
        return orderRequestDao.findAllByWarehouse_Id(warehouse_id).orElseThrow(() -> new NoOrderRequestsSentForWarehouseException(warehouse_id));
    }
}
