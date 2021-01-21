package it.unical.asd.group6.computerSparePartsCompany.data.dto;

import java.io.Serializable;

public class CustomerDTO implements Serializable {

    private Long id;

    private String name;

    private String surname;

    private String phoneNumber;

    private String email;

    private String username;

    private String password;

    private Long VATIdentificationNumber;

    public CustomerDTO(){}

    public CustomerDTO(Long id, String name, String surname, String phoneNumber, String email, String username, String password, Long VATIdentificationNumber) {
        this.id=id;
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
}
