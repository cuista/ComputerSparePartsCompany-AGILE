package it.unical.asd.group6.computerSparePartsCompany.core.services.implemented;

import it.unical.asd.group6.computerSparePartsCompany.core.services.CategoryService;
import it.unical.asd.group6.computerSparePartsCompany.data.dao.CategoryDao;
import it.unical.asd.group6.computerSparePartsCompany.data.dto.CategoryDTO;
import it.unical.asd.group6.computerSparePartsCompany.data.entities.Category;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryDao categoryDao;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public CategoryDTO getCategoryById(Long idCategory) {
        Category category = categoryDao.findCategoryById(idCategory);
        CategoryDTO categoryDTO = modelMapper.map(category,CategoryDTO.class);
        return categoryDTO;
    }

    @Override
    public Category getCategoryByName(String category) {
        return categoryDao.findCategoryByCategoryName(category);
    }

    @Override
    public List<Category> getCategoryByList(List<String> category) {
        return categoryDao.findCategoryByCategoryNameIn(category);
    }

    @Override
    public List<CategoryDTO> getAllCategories() {
        List<Category> categories = categoryDao.findAll();
        List<CategoryDTO> categoryDTOS = categories.stream().map(cat -> modelMapper.map(cat, CategoryDTO.class)).collect(Collectors.toList());
        return categoryDTOS;
    }

    @Override
    public List<String>getAllName()
    {
        return categoryDao.getAllName();
    }
}
