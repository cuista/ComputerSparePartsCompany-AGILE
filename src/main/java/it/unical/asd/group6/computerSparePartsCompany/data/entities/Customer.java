package it.unical.asd.group6.computerSparePartsCompany.data.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "CUSTOMER")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "SURNAME")
    private String surname;

    @Column(name = "PHONE_NUMBER") //FIXARE EVENTUALMENTE LENGTH
    private String phoneNumber;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "USERNAME")
    private String username;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "VAT_ID") //FIXARE EVENTUALMENTE LA LENGTH
    private Long VATIdentificationNumber;

    //TODO a (LIST?) of purchases; and add its get, set, equeals, hash & toString

    public Customer(){}

    public Customer(Long id, String name, String surname, String phoneNumber, String email, String username, String password, Long VATIdentificationNumber) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.username = username;
        this.password = password;
        this.VATIdentificationNumber = VATIdentificationNumber;
    }

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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getVATIdentificationNumber() {
        return VATIdentificationNumber;
    }

    public void setVATIdentificationNumber(Long VATIdentificationNumber) {
        this.VATIdentificationNumber = VATIdentificationNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(id, customer.id) &&
                Objects.equals(name, customer.name) &&
                Objects.equals(surname, customer.surname) &&
                Objects.equals(phoneNumber, customer.phoneNumber) &&
                Objects.equals(email, customer.email) &&
                Objects.equals(username, customer.username) &&
                Objects.equals(password, customer.password) &&
                Objects.equals(VATIdentificationNumber, customer.VATIdentificationNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, phoneNumber, email, username, password, VATIdentificationNumber);
    }


}
