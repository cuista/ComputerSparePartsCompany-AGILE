package it.unical.asd.group6.computerSparePartsCompany.data.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Objects;

// The name Order for this entity gave many problems with Spring Boot
@Entity
@Table (name = "ORDER_REQUEST")
public class OrderRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "PRODUCTION_HOUSE_ID", referencedColumnName = "ID")
    @JsonManagedReference
    private ProductionHouse productionHouse;

    @ManyToOne
    @JoinColumn(name = "WAREHOUSE_ID", referencedColumnName = "ID")
    @JsonManagedReference
    private Warehouse warehouse;

    @Column(name = "PRODUCT_BRAND")
    private String productBrand;

    @Column(name = "PRODUCT_MODEL")
    private String productModel;

    @Column(name = "PRODUCT_QUANTITY")
    private Integer productQuantity;

    public OrderRequest() {}

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderRequest that = (OrderRequest) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(productionHouse, that.productionHouse) &&
                Objects.equals(warehouse, that.warehouse) &&
                Objects.equals(productBrand, that.productBrand) &&
                Objects.equals(productModel, that.productModel) &&
                Objects.equals(productQuantity, that.productQuantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, productionHouse, warehouse, productBrand, productModel, productQuantity);
    }

    @Override
    public String toString() {
        return "OrderRequest{" +
                "id=" + id +
                ", productionHouse=" + productionHouse +
                ", warehouse=" + warehouse +
                ", productBrand='" + productBrand + '\'' +
                ", productModel='" + productModel + '\'' +
                ", productQuantity=" + productQuantity +
                '}';
    }


}
