package it.unical.asd.group6.computerSparePartsCompany.data.dto;

import it.unical.asd.group6.computerSparePartsCompany.data.entities.ProductionHouse;
import it.unical.asd.group6.computerSparePartsCompany.data.entities.Warehouse;

import java.io.Serializable;

public class OrderRequestDTO implements Serializable {

    private Long id;

    private ProductionHouse productionHouse;

    private Warehouse warehouse;

    private String productBrand;

    private String productModel;

    private Integer productQuantity;

    public OrderRequestDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProductionHouse getProductionHouse() {
        return productionHouse;
    }

    public void setProductionHouse(ProductionHouse productionHouse) {
        this.productionHouse = productionHouse;
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

    public Integer getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(Integer productQuantity) {
        this.productQuantity = productQuantity;
    }
}
