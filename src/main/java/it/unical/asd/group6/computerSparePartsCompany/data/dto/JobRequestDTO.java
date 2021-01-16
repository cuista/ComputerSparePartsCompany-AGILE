package it.unical.asd.group6.computerSparePartsCompany.data.dto;

import java.io.Serializable;
import java.time.LocalDate;

public class JobRequestDTO implements Serializable {

    private Long ID;
    private String title;
    private String position;
    private String email;
    private String description;
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    private LocalDate localDate;

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    public JobRequestDTO(Long ID, String title, String position, String email, String description, LocalDate localDate) {
        this.ID = ID;
        this.title = title;
        this.position = position;
        this.email = email;
        this.description = description;
        this.localDate = localDate;
    }

    public JobRequestDTO(){}
}
