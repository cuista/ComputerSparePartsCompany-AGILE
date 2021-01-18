package it.unical.asd.group6.computerSparePartsCompany.data.dto;

import it.unical.asd.group6.computerSparePartsCompany.data.entities.ErrorMessage;

import java.io.Serializable;

public class ErrorMessageDTO implements Serializable {

    private Long ID;

    private String title;

    private String description;

    private String username;

    private String email;

    public ErrorMessageDTO(){}

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ErrorMessageDTO(Long ID, String title, String description, String username) {
        this.ID = ID;
        this.title = title;
        this.description = description;
        this.username = username;
    }
}
