package it.unical.asd.group6.computerSparePartsCompany.core.service;

import it.unical.asd.group6.computerSparePartsCompany.data.entities.Category;

import java.util.List;

public interface CategoryService {
    Category getCategoryById(Long idCategory);

    List<Category> getAllCategories();
}
