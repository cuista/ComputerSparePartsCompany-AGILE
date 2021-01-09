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

    @Test
    public void testAddProduct1(){
        Product prod1 = new Product();
        prod1.setBrand("NVidia GEForce");
        prod1.setModel("GTX 1080 Ti");
        prod1.setPrice(181.46);
        prod1.setDescription("Nvidia graphic card");
        prod1.setImageUrl("https://images-na.ssl-images-amazon.com/images/I/71sN1G2-16L._AC_SX466_.jpg");
        assert (productService.addProduct(prod1));
    }

    @Test
    public void testAddProduct2(){
        Product prod1 = new Product();
        prod1.setBrand("NVidia GEForce");
        prod1.setModel("GTX 1080 Ti");
        prod1.setPrice(181.47);
        prod1.setDescription("Nvidia graphic card");
        prod1.setImageUrl("https://images-na.ssl-images-amazon.com/images/I/71sN1G2-16L._AC_SX466_.jpg");
        assert (!productService.addProduct(prod1));
    }

    @Test
    public void testAddProduct3(){
        Product prod1 = new Product();
        prod1.setBrand("NVidia GEForce");
        prod1.setModel("GTX 1090 Ti");
        prod1.setPrice(181.46);
        prod1.setDescription("Nvidia graphic card");
        prod1.setImageUrl("https://images-na.ssl-images-amazon.com/images/I/71sN1G2-16L._AC_SX466_.jpg");
        assert (productService.addProduct(prod1));
    }

    @Test
    public void testDeleteProducts1(){
        assert (productService.deleteProduct("NVidia GEForce", "GTX 1080 Ti"));
    }


}
