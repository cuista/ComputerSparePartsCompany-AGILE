package it.unical.asd.group6.computerSparePartsCompany.core.service.implementation;

import it.unical.asd.group6.computerSparePartsCompany.core.service.CategoryService;
import it.unical.asd.group6.computerSparePartsCompany.data.dao.CategoryDao;
import it.unical.asd.group6.computerSparePartsCompany.data.entities.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryDao categoryDao;

    @Override
    public Category getCategoryById(Long idCategory) {
        return  categoryDao.findCategoryById(idCategory);
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryDao.findAll();
    }
}
