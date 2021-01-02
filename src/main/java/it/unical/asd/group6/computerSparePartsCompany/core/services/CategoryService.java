package it.unical.asd.group6.computerSparePartsCompany.core.services;

import it.unical.asd.group6.computerSparePartsCompany.data.entities.Category;

import java.util.List;

public interface CategoryService {
    Category getCategoryById(Long idCategory);

    List<Category> getAllCategories();

    Category getCategoryByName(String category);

    List<Category> getCategoryByList(List<String> category);
}
