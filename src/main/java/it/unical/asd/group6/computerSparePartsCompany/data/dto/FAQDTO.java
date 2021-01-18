package it.unical.asd.group6.computerSparePartsCompany.data.dto;

import java.io.Serializable;

public class FAQDTO implements Serializable {

    private Long ID;

    private String title;

    private String description;

    public FAQDTO(){}

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

    public FAQDTO(Long ID, String title, String description) {
        this.ID = ID;
        this.title = title;
        this.description = description;
    }
}
