package it.unical.asd.group6.computerSparePartsCompany.core.exception.orderrequest;

public class NoOrderRequestsSentForWarehouseException extends OrderRequestException{

    public NoOrderRequestsSentForWarehouseException(Long id){
        super(String.format("No order requests found for warehouse %s", String.valueOf(id)));
    }

}
