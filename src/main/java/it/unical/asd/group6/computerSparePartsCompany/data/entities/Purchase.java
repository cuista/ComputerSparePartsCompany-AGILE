package it.unical.asd.group6.computerSparePartsCompany.data.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "PURCHASE")
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID")
    private Long id;

    @Column(name = "DATE")
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "CUSTOMER", referencedColumnName="ID")
    private Customer customer;

    @OneToMany(mappedBy = "purchase", fetch = FetchType.EAGER)
    private List<Product> products=new ArrayList<>();

    @Column(name = "TOTAL_PRICE")
    private Double totalPrice;

    public Purchase() {}

    public void addProducts(Product p){
        this.products.add(p);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer buyer) {
        this.customer = buyer;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Purchase purchase = (Purchase) o;
        return Objects.equals(id, purchase.id) &&
                Objects.equals(date, purchase.date) &&
                Objects.equals(customer, purchase.customer) &&
                Objects.equals(products, purchase.products) &&
                Objects.equals(totalPrice,purchase.totalPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, customer, products, totalPrice);
    }
}
