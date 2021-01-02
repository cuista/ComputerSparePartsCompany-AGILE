package it.unical.asd.group6.computerSparePartsCompany.core.services.implemented;

import it.unical.asd.group6.computerSparePartsCompany.core.services.CategoryService;
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

    @Override
    public Category getCategoryByName(String category) {
        return categoryDao.findCategoryByCategoryName(category);
    }

    @Override
    public List<Category> getCategoryByList(List<String> category) {
        return categoryDao.findCategoryByCategoryNameIn(category);
    }
}
