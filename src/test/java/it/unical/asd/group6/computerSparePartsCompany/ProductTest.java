package it.unical.asd.group6.computerSparePartsCompany;

import it.unical.asd.group6.computerSparePartsCompany.data.entities.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductTest extends AbstractComputerSparePartsCompanyTest{

    @Test
    public void testFindAll_WithProductsByBrandAndModelWithoutDuplicates_OK(){
        List<Product> products= productDao.findAll();

        List<Product> productsNoDuplicates=products.stream().distinct().collect(Collectors.toList());

        for (Product pr: productsNoDuplicates){
            System.out.println(pr.getBrand() + " " + pr.getModel() + " " + pr.getImageUrl());
        }
    }

}
