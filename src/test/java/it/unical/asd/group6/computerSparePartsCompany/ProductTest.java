package it.unical.asd.group6.computerSparePartsCompany;

import it.unical.asd.group6.computerSparePartsCompany.data.entities.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductTest extends AbstractComputerSparePartsCompanyTest{

    @Test
    public void testFindAllByBrand_OK(){
        Optional<List<Product>> products=productDao.findAllByBrand("cursus");

        assert(products.get().size()==5);
    }

    @Test
    public void testFindAllByBrandAndModel_OK(){
        Optional<List<Product>> products=productDao.findAllByBrandAndModel("cursus","gravida");

        assert(products.get().size()==3);
    }

    @Test
    public void testFindAllByPrice_OK(){
        Optional<List<Product>> products=productDao.findAllByPrice(71.00);

        assert(products.get().size()==1);
        assert(products.get().get(0).getBrand().equals("cursus"));
        assert(products.get().get(0).getModel().equals("gravida"));
    }

    @Test
    public void testFindAllByPriceIsLessThan_OK(){
        Optional<List<Product>> products=productDao.findAllByPriceIsLessThan(100.00);

        assert(products.get().size()==3);
    }

}
