package it.unical.asd.group6.computerSparePartsCompany.data.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name="EMPLOYEE")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID")
    private Long id;

    @Column(name="USERNAME")
    private String username;
    @Column(name="PASSWORD")
    private String password;
    @Column(name="FIRSTNAME")
    private String firstname;
    @Column(name="LASTNAME")
    private String lastname;
    @Column(name="HIRING_DATE")
    private LocalDate hiringDate;
    @Column(name="EMAIL")
    private String email;
    @Column(name="TELEPHONE_NUMBER")
    private String telephoneNumber;

    //TODO private Long idWarehouse; and add its get, set, equeals, hash & toString

    public Employee() {}

    public Employee(LocalDate hiringDate, String username, String password, String email, String telephone_number, String firstname, String lastname) {
        this.username = username;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.hiringDate = hiringDate;
        this.email = email;
        this.telephoneNumber = telephone_number;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public LocalDate getHiringDate() {
        return hiringDate;
    }

    public void setHiringDate(LocalDate hiringDate) {
        this.hiringDate = hiringDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephone_number) {
        this.telephoneNumber = telephone_number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(id, employee.id) &&
                Objects.equals(username, employee.username) &&
                Objects.equals(password, employee.password) &&
                Objects.equals(firstname, employee.firstname) &&
                Objects.equals(lastname, employee.lastname) &&
                Objects.equals(hiringDate, employee.hiringDate) &&
                Objects.equals(email, employee.email) &&
                Objects.equals(telephoneNumber, employee.telephoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, firstname, lastname, hiringDate, email, telephoneNumber);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", hiringDate=" + hiringDate +
                ", email='" + email + '\'' +
                ", telephone_number='" + telephoneNumber + '\'' +
                '}';
    }
}