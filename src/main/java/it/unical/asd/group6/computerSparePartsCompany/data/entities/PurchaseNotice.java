package it.unical.asd.group6.computerSparePartsCompany.data.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "PURCHASE_NOTICE")
public class PurchaseNotice {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "COLLECTION_DATE")
    private LocalDate collectionDate;

    @ManyToOne
    @JoinColumn(name = "CUSTOMER_ID", referencedColumnName = "ID")
    private Customer customerId;

    @ManyToOne
    @JoinColumn(name = "WAREHOUSE_ID", referencedColumnName = "ID")
    private Warehouse warehouseId;

    @Column(name = "PRODUCT_BRAND")
    private String productBrand;

    @Column(name = "PRODUCT_MODEL")
    private String productModel;

    @Column(name = "QUANTITY")
    private Long quantity;

    public PurchaseNotice() {}

    public PurchaseNotice(Long id, LocalDate collectionDate, Customer customerId, Warehouse warehouseId, String productBrand, String productModel, Long quantity) {
        this.id = id;
        this.collectionDate = collectionDate;
        this.customerId = customerId;
        this.warehouseId = warehouseId;
        this.productBrand = productBrand;
        this.productModel = productModel;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getCollectionDate() {
        return collectionDate;
    }

    public void setCollectionDate(LocalDate collectionDate) {
        this.collectionDate = collectionDate;
    }

    public Customer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Customer customerId) {
        this.customerId = customerId;
    }

    public Warehouse getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Warehouse warehouseId) {
        this.warehouseId = warehouseId;
    }

    public void setProductBrand(String productBrand) {
        this.productBrand = productBrand;
    }

    public void setProductModel(String productModel) {
        this.productModel = productModel;
    }

    public String getProductBrand() {
        return productBrand;
    }

    public String getProductModel() {
        return productModel;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PurchaseNotice notice = (PurchaseNotice) o;
        return Objects.equals(id, notice.id) &&
                Objects.equals(collectionDate, notice.collectionDate) &&
                Objects.equals(customerId, notice.customerId) &&
                Objects.equals(warehouseId, notice.warehouseId) &&
                Objects.equals(productBrand, notice.productBrand) &&
                Objects.equals(productModel, notice.productModel) &&
                Objects.equals(quantity, notice.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, collectionDate, customerId, warehouseId, productBrand, productModel, quantity);
    }
}
