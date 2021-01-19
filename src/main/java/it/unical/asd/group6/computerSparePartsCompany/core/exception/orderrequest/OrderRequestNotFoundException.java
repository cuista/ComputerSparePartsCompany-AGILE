package it.unical.asd.group6.computerSparePartsCompany.core.exception.orderrequest;

public class OrderRequestNotFoundException extends OrderRequestException{

    public OrderRequestNotFoundException(Long id){
        super(String.format("Order request with id %s not found", String.valueOf(id)));
    }

}
