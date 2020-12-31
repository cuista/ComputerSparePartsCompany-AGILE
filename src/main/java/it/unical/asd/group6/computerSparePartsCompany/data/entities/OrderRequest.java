package it.unical.asd.group6.computerSparePartsCompany.data.entities;

import javax.persistence.*;
import java.util.List;
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
    private ProductionHouse productionHouse;

    @ManyToOne
    @JoinColumn(name = "WAREHOUSE_ID", referencedColumnName = "ID")
    private Warehouse warehouse;

    @OneToMany(mappedBy = "orderRequest", fetch = FetchType.EAGER)
    private List<Product> products;

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

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderRequest that = (OrderRequest) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(productionHouse, that.productionHouse) &&
                Objects.equals(warehouse, that.warehouse) &&
                Objects.equals(products, that.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, productionHouse, warehouse, products);
    }

    @Override
    public String toString() {
        return "OrderRequest{" +
                "id=" + id +
                ", productionHouse=" + productionHouse +
                ", warehouse=" + warehouse +
                ", products=" + products +
                '}';
    }
}
