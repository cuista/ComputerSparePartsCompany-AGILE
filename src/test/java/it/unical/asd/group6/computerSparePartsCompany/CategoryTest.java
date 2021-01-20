package it.unical.asd.group6.computerSparePartsCompany;

import it.unical.asd.group6.computerSparePartsCompany.data.entities.Category;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

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

    @Test
    public void testGetAllName() {
        categoryNames.sort((o1,o2)-> {return o1.compareTo(o2);});

        List<String> categoriesFromGetAllName=categoriesDao.getAllName();
        categoriesFromGetAllName.sort((o1,o2)-> {return o1.compareTo(o2);});

        Assert.assertEquals(categoriesDao.getAllName(),categoryNames);
        assert (categoriesDao.getAllName().size() == 11);
    }

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
