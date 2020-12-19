package it.unical.asd.group6.computerSparePartsCompany;

import it.unical.asd.group6.computerSparePartsCompany.data.entities.Product;
import it.unical.asd.group6.computerSparePartsCompany.core.services.implemented.ProductServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductTest extends AbstractComputerSparePartsCompanyTest{

    @Autowired
    ProductServiceImpl productService;

    // SERVICE TESTs
    @Test
    public void testServiceFindAll(){
        Integer size = productService.getAllProduct().size();
        System.out.println(size);
        assert(size != 0);
    }

    @Test
    public void testServiceFindAllByBrand(){
        List<Product> products = productService.getAllProductByBrand("NVIDIA");
        assert(products == null);
    }

    @Test
    public void testServiceFindAllByBrandAndModel(){
        List<Product> products = productService.getAllProductByBrandAndModel("cursus", "gravida");
        System.out.println(products);
        assert(products.size() != 0);
    }

    @Test
    public void testServiceFindAllByPrice(){
        List<Product> products = productService.getAllProductByPriceIsLessThan(250.0);
        for(Product p: products)
            System.out.println(p.getPrice());
        assert(products.size() != 0);
    }

    // DAO TESTs
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
        Optional<List<Product>> products=productDao.findAllByPrice(71);

        assert(products.get().size()==1);
        assert(products.get().get(0).getBrand().equals("cursus"));
        assert(products.get().get(0).getModel().equals("gravida"));
    }

    @Test
    public void testFindAllByPriceIsLessThan_OK(){
        Optional<List<Product>> products=productDao.findAllByPriceIsLessThan(100.0);

        assert(products.get().size()==3);
    }

}
