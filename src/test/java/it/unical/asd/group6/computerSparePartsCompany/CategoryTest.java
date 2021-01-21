package it.unical.asd.group6.computerSparePartsCompany;

import it.unical.asd.group6.computerSparePartsCompany.data.dto.CategoryDTO;
import it.unical.asd.group6.computerSparePartsCompany.data.entities.Category;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryTest extends AbstractComputerSparePartsCompanyTest {

    private List<String> categoryNames = Arrays.asList("dummy_category",
            "CPU",
            "Graphic Card",
            "RAM memory",
            "Monitor",
            "Case",
            "Motherboard",
            "Power Supply",
            "HDD-SDD",
            "Optical Drives",
            "Input and Output Devices");

    //SERVICE TESTs

    @Test
    public void testGetCategoryById() {
        assert (categoryService.getCategoryById(48L).getCategoryName().equals("CPU"));
    }
    @Test
    public void testGetAllName() {
        assert (categoriesDao.getAllName().size() == 11);
    }

    @Test
    public void testGetCategoryByName() {
        assert(categoryService.getCategoryByName("CPU").getId()==48L);
    }

    @Test
    public void testGetCategoryByList() {
        assert(categoryService.getCategoryByList(categoryNames).size()==11);
    }


    @Test
    public void testGetAllCategories() {
        assert(categoryService.getAllCategories().size()==11);
    }


    //DAO TESTs

    @Test
    public void testFindCategoryById(){
        assert(categoriesDao.findCategoryById(48L).getCategoryName().equals("CPU"));
    }

    @Test
    public void testFindCategoryByCategoryName(){
        assert(categoriesDao.findCategoryByCategoryName("CPU").getCategoryName().equals("CPU"));
    }

    @Test
    public void testFindCategoryByCategoryNameIn(){
        assert(categoriesDao.findCategoryByCategoryNameIn(categoryNames).size()==11);
    }

}
