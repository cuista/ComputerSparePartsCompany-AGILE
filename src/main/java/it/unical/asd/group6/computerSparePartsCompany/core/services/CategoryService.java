package it.unical.asd.group6.computerSparePartsCompany.core.services;

import it.unical.asd.group6.computerSparePartsCompany.data.entities.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    Category getCategoryById(Long idCategory);

    List<Category> getAllCategories();
}
