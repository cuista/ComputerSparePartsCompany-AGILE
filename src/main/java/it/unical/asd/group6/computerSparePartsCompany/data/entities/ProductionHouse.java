package it.unical.asd.group6.computerSparePartsCompany.data.entities;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table (name="PRODUCTION_HOUSE")
public class ProductionHouse {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @OneToMany(mappedBy = "productionHouse", fetch = FetchType.EAGER)
    private List<OrderRequest> orderRequests;

    public ProductionHouse() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<OrderRequest> getOrderRequests() {
        return orderRequests;
    }

    public void setOrderRequests(List<OrderRequest> orderRequests) {
        this.orderRequests = orderRequests;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductionHouse that = (ProductionHouse) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(orderRequests, that.orderRequests);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, orderRequests);
    }

    @Override
    public String toString() {
        return "ProductionHouse{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", orderRequests=" + orderRequests +
                '}';
    }
}
