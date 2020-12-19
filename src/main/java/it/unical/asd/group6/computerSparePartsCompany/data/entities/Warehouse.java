package it.unical.asd.group6.computerSparePartsCompany.data.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "WAREHOUSE")
public class Warehouse {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID")
    private Long id;

    @Column(name = "STREET")
    private String street;

    @Column(name = "PROVINCE")
    private String province;

    @Column(name = "CITY")
    private String city;

    @Column(name = "REGION")
    private String region;

    @Column(name = "OPENING_HOURS")
    private String openingHours;

    @OneToMany(mappedBy = "warehouse")
    @LazyCollection(LazyCollectionOption.FALSE) //INSERITO A CAUSA DEL FETCHING DI TIPO EAGER (NON SE NE POSSONO AVERE DUE IN CONTEMPORANEA)
    //FORSE PERO' SI PUO' RIMUOVERE SE CI RENDIAMO CONTO CHE FUNZIONA COMUNQUE ---> DA VEDERE AL MOMENTO DEL RETRIEVE DI INFO DAL SITO
    private List<Product> products=new ArrayList<>();

    @OneToMany(mappedBy = "warehouse", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<PurchaseNotice> purchaseNotices=new ArrayList<>();

    public Warehouse(){}

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

    public void addPurchaseNotice(PurchaseNotice pn){
        this.purchaseNotices.add(pn);
    }

    @Override
    public String toString() {
        return "Warehouse{" +
                "id=" + id +
                ", street='" + street + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", region='" + region + '\'' +
                ", openingHours='" + openingHours + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Warehouse warehouse = (Warehouse) o;
        return Objects.equals(id, warehouse.id) &&
                Objects.equals(street, warehouse.street) &&
                Objects.equals(province, warehouse.province) &&
                Objects.equals(city, warehouse.city) &&
                Objects.equals(region, warehouse.region) &&
                Objects.equals(openingHours, warehouse.openingHours) &&
                Objects.equals(products, warehouse.products) &&
                Objects.equals(purchaseNotices, warehouse.purchaseNotices);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, street, province, city, region, openingHours, products, purchaseNotices);
    }
}
