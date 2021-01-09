package it.unical.asd.group6.computerSparePartsCompany.core.services;

import it.unical.asd.group6.computerSparePartsCompany.data.dto.CategoryDTO;
import it.unical.asd.group6.computerSparePartsCompany.data.entities.Category;

import java.util.List;

public interface CategoryService {
    CategoryDTO getCategoryById(Long idCategory);

    List<CategoryDTO> getAllCategories();

    Category getCategoryByName(String category);

    List<Category> getCategoryByList(List<String> category);
    List<String>getAllName();
}
