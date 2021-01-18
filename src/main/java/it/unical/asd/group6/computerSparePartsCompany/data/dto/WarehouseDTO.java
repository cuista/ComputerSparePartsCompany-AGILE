package it.unical.asd.group6.computerSparePartsCompany.data.dto;

import it.unical.asd.group6.computerSparePartsCompany.data.entities.OrderRequest;
import it.unical.asd.group6.computerSparePartsCompany.data.entities.Product;
import it.unical.asd.group6.computerSparePartsCompany.data.entities.Purchase;
import it.unical.asd.group6.computerSparePartsCompany.data.entities.PurchaseNotice;

import java.util.ArrayList;
import java.util.List;

public class WarehouseDTO {

    private Long id;

    private String street;

    private String province;

    private String city;

    private String region;

    private String openingHours;

    private List<Product> products = new ArrayList<>();

    private List<PurchaseNotice> purchaseNotices=new ArrayList<>();

    private List<Purchase> purchases= new ArrayList<>();

    private List<OrderRequest> orderRequestsSent = new ArrayList<>();

    public WarehouseDTO(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getOpeningHours() {
        return openingHours;
    }

    public void setOpeningHours(String openingHours) {
        this.openingHours = openingHours;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public List<PurchaseNotice> getPurchaseNotices() {
        return purchaseNotices;
    }

    public void setPurchaseNotices(List<PurchaseNotice> purchaseNotices) {
        this.purchaseNotices = purchaseNotices;
    }

    public List<Purchase> getPurchases() {
        return purchases;
    }

    public void setPurchases(List<Purchase> purchases) {
        this.purchases = purchases;
    }

    public List<OrderRequest> getOrderRequestsSent() {
        return orderRequestsSent;
    }

    public void setOrderRequestsSent(List<OrderRequest> orderRequestsSent) {
        this.orderRequestsSent = orderRequestsSent;
    }
}
