package it.unical.asd.group6.computerSparePartsCompany.data.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name="PRODUCT")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID")
    private Long id;

    @Column(name="PRICE")
    private Double price;

    @Column(name="BRAND")
    private String brand;

    @Column(name="MODEL")
    private String model;

    @Lob
    @Column(name="DESCRIPTION")
    private String description;

    @ManyToOne
    @JoinColumn(name = "PURCHASE_ID", referencedColumnName = "ID" , nullable = true)
    private Purchase purchaseId;

    @ManyToOne
    @JoinColumn(name = "ORDER_ID", referencedColumnName = "ID", nullable = true)
    private OrderRequest orderRequest;

    @ManyToOne
    @JoinColumn(name = "WAREHOUSE_ID", referencedColumnName = "ID")
    private Warehouse warehouse;

    @ManyToOne
    @JoinColumn(name = "CATEGORY_ID", referencedColumnName = "ID")
    private Category category;

    public Product() {}

    public Product(Long id, Double price, String brand, String model, String description, Purchase purchase, OrderRequest orderRequest, Warehouse warehouse, Category category) {
        this.id = id;
        this.price = price;
        this.brand = brand;
        this.model = model;
        this.description = description;
        this.purchaseId = purchase;
        this.orderRequest = orderRequest;
        this.warehouse = warehouse;
        this.category = category;
    }

    //TODO Collegare le altre classi, ES: @OneToMany(mappedBy = "purchase_id", fetch = FetchType.EAGER) private List<Product> products;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Purchase getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(Purchase purchaseId) {
        this.purchaseId = purchaseId;
    }

    public OrderRequest getOrder() {
        return orderRequest;
    }

    public void setOrder(OrderRequest order) {
        this.orderRequest = order;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id) &&
                Objects.equals(price, product.price) &&
                Objects.equals(brand, product.brand) &&
                Objects.equals(model, product.model) &&
                Objects.equals(description, product.description) &&
                Objects.equals(purchaseId, product.purchaseId) &&
                Objects.equals(orderRequest, product.orderRequest) &&
                Objects.equals(warehouse, product.warehouse) &&
                Objects.equals(category, product.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, price, brand, model, description, purchaseId, orderRequest, warehouse, category);
    }
}
