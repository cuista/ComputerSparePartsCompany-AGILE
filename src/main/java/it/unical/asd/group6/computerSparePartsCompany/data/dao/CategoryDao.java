package it.unical.asd.group6.computerSparePartsCompany.data.dao;

import it.unical.asd.group6.computerSparePartsCompany.data.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryDao extends JpaRepository<Category,Long> {
    Category findCategoryById(Long idCategory);

    Category findCategoryByCategoryName(String category);

    List<Category> findCategoryByCategoryNameIn(List<String> category);

    @Query("select distinct categoryName from Category")
    List<String> getAllName();
}
