package it.unical.asd.group6.computerSparePartsCompany.data.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
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

    //@Lob
    @Column(name="DESCRIPTION")
    private String description;

    @Column(name = "IMAGE_URL")
    private String imageUrl;

    @ManyToOne
    @JoinColumn(name = "PURCHASE_ID", referencedColumnName = "ID" , nullable = true)
    @JsonManagedReference
    private Purchase purchase;

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
        return purchase;
    }

    public void setPurchaseId(Purchase purchaseId) {
        this.purchase = purchaseId;
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

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Purchase getPurchase() {
        return purchase;
    }

    public void setPurchase(Purchase purchase) {
        this.purchase = purchase;
    }

    public OrderRequest getOrderRequest() {
        return orderRequest;
    }

    public void setOrderRequest(OrderRequest orderRequest) {
        this.orderRequest = orderRequest;
    }

    @Override
    public boolean equals(Object o) { //(MANUEL) HO ELIMINATO L'ID POICHE' CHIAVE PRIMARE SEMPRE DIVERSA---> L'EQUALS DAVA SEMPRE FALSO
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(price, product.price) &&
                Objects.equals(brand, product.brand) &&
                Objects.equals(model, product.model) &&
                Objects.equals(description, product.description) &&
                Objects.equals(purchase, product.purchase) &&
                Objects.equals(orderRequest, product.orderRequest) &&
                Objects.equals(warehouse, product.warehouse) &&
                Objects.equals(category, product.category) &&
                Objects.equals(imageUrl, product.imageUrl);
    }


    @Override //(MANUEL) HO FATTO LA STESSA COSA QUI NELL'HASHCODE POICHE' NON SI PUO' VIOLARE IL CONTRATTO TRA EQUALS E HASHCODE
    public int hashCode() {
        return Objects.hash(price, brand, model, description, purchase, orderRequest, warehouse, category, imageUrl);
    }
}
