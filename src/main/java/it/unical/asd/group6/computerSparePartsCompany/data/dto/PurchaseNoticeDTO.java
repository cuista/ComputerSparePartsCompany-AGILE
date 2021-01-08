package it.unical.asd.group6.computerSparePartsCompany.data.dto;

import it.unical.asd.group6.computerSparePartsCompany.data.entities.Customer;
import it.unical.asd.group6.computerSparePartsCompany.data.entities.Warehouse;

import java.io.Serializable;
import java.time.LocalDate;

public class PurchaseNoticeDTO implements Serializable {

    private LocalDate localDate;

    private Customer customer;

    private Warehouse warehouse;

    private String productBrand;

    private String productModel;

    private Integer quantity;

    public PurchaseNoticeDTO(){}

    public PurchaseNoticeDTO(LocalDate localDate, Customer customer, Warehouse warehouse, String productBrand, String productModel, Integer quantity) {
        this.localDate = localDate;
        this.customer = customer;
        this.warehouse = warehouse;
        this.productBrand = productBrand;
        this.productModel = productModel;
        this.quantity = quantity;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    public String getProductBrand() {
        return productBrand;
    }

    public void setProductBrand(String productBrand) {
        this.productBrand = productBrand;
    }

    public String getProductModel() {
        return productModel;
    }

    public void setProductModel(String productModel) {
        this.productModel = productModel;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
