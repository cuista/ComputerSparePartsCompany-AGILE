package it.unical.asd.group6.computerSparePartsCompany.data.dto;

import java.io.Serializable;

public class CategoryDTO implements Serializable {

    private String CategoryName;

    public CategoryDTO() {
        //empty
    }

    public CategoryDTO(String categoryName) {
        CategoryName = categoryName;
    }

    public String getCategoryName() {
        return CategoryName;
    }

    public void setCategoryName(String categoryName) {
        CategoryName = categoryName;
    }
}
