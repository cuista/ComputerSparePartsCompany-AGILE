package it.unical.asd.group6.computerSparePartsCompany;

import it.unical.asd.group6.computerSparePartsCompany.data.entities.Category;
import it.unical.asd.group6.computerSparePartsCompany.data.entities.Product;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductTest extends AbstractComputerSparePartsCompanyTest{

    /*
    DAO TESTS
     */

    @Test
    public void testGetAllBrands_OK(){

        List<String> products = productDao.getAllBrands();

        assert products.contains("NVidia GEForce");
        assert products.contains("Sandisk");
        assert products.contains("Intel");
    }

    @Test
    public void testFindById_OK(){

        Optional<Product> product = productDao.findById(58L);
        assert product.isPresent();
        assert product.get().getBrand().equals("NVidia GEForce");
        assert product.get().getModel().equals("GTX 1080 Ti");
        assert product.get().getPrice().equals(181.46);
    }

    @Test
    public void testFindAllByBrand_OK(){

        Optional<List<Product>> products = productDao.findAllByBrand("NVidia GEForce");

        assert products.isPresent();
        assert products.get().size() == 10;

    }

    @Test
    public void testFindAllByBrandAndModel_OK(){

        Optional<List<Product>> products = productDao.findAllByBrandAndModel("NVidia GEForce","GTX 1080 Ti");

        assert products.isPresent();
        assert products.get().size() == 10;

    }

    @Test
    public void testFindAllByPrice_OK(){

        Optional<List<Product>> products = productDao.findAllByPrice(306.57);

        assert products.isPresent();
        assert products.get().size() == 10;

    }

    @Test
    public void testFindAllByPriceIsLessThan_OK(){

        Optional<List<Product>> products = productDao.findAllByPriceIsLessThan(700.00);

        assert products.isPresent();
        assert products.get().size() == 20;

    }

    @Test
    public void testFindAllByModel_OK(){

        Optional<List<Product>> products = productDao.findAllByModel("SATA III");

        assert products.isPresent();
        assert products.get().size() == 10;

    }

    @Test
    public void testFindProductByBrandInAndModelInAndPriceBetween_OK() {

        Collection<Category> categories = new ArrayList<>();

        categories.add(categoriesDao.findCategoryByCategoryName("Graphic Card"));

        Collection<String> brands = new ArrayList<>();

        brands.add("Sandisk");
        brands.add("Nvidia GEForce");

        Collection<String> models = new ArrayList<>();

        models.add("GTX 1080 Ti");
        models.add("SATA III");

        List<Product> products = productDao.findProductByBrandInAndModelInAndPriceBetween(categories, brands, models, 100.00, 900.00);

        assert products.isEmpty();
    }

    @Test
    public void testFindAllByCategoryIdAndPriceBetween_OK(){

        List<Product> products = productDao.findAllByCategoryIdAndPriceBetween(49L,100.00,200.00);

        System.out.println(products.size());

       assert !products.isEmpty();
       assert products.size()==9;
    }

    @Test
    public void testFindAllByCategoryIdAndBrandInAndPriceBetween_OK(){

        List<String> brands = new ArrayList<>();

        brands.add("Sandisk");

        List<Product> products = productDao.findAllByCategoryIdAndBrandInAndPriceBetween(55L,brands,100.00,900.00);

        assert !products.isEmpty();
        assert products.size()==10;
    }

    @Test
    public void testGetAllBrandsByCategory_OK(){

        Category category = categoriesDao.findCategoryById(48L);

        List<String> brands = productDao.getAllBrandsByCategory(category);

        System.out.println(brands.size());

    }

    @Test
    public void testFindByFilters_OK(){

        Category category=categoriesDao.findCategoryById(55L);

        String brand = "Sandisk";

        List<Product> product = productDao.findByFilters(category,brand,100.00,900.00);

        assert !product.isEmpty();
        assert product.size()==10;

    }

    @Test
    public void testUpdateProductPrice_OK(){

        productDao.updateProductPrice(60L,666.66);

        Optional<Product> product=productDao.findById(60L);

        assert product.get().getPrice().equals(666.66);
    }

    @Test
    public void testUpdateProductDescription_OK(){
        productDao.updateProductDescription(61L,"Best product in the world");

        Optional<Product> product=productDao.findById(61L);

        assert product.get().getDescription().equals("Best product in the world");

    }

    @Test
    public void testUpdateProductURL_OK(){

        productDao.updateProductURL(62L, "PROF CI METTA 3O E NON SE NE PARLI PIU'");

        Optional<Product> product=productDao.findById(62L);

        assert product.get().getImageUrl().equals("PROF CI METTA 3O E NON SE NE PARLI PIU'");

    }


    @Test
    public void testUpdateProductCategory_OK(){

        productDao.updateProductCategory(63L, categoriesDao.findCategoryByCategoryName("Graphic Card"));

        Optional<Product> product=productDao.findById(63L);

        assert product.get().getCategory().getCategoryName().equals("Graphic Card");

    }

    @Test
    public void testUpdateProductAll_OK(){

        productDao.updateProductAll(64L,"Descr1",698.00,"www.ciccioweloveyou.com", categoriesDao.findCategoryByCategoryName("Graphic Card"));

        Optional<Product> product=productDao.findById(64L);

        assert product.get().getId().equals(64L);
        assert product.get().getDescription().equals("Descr1");
        assert product.get().getImageUrl().equals("www.ciccioweloveyou.com");
        assert product.get().getCategory().getCategoryName().equals("Graphic Card");
        assert product.get().getPrice().equals(698.00);

    }

    @Ignore
    @Test //TODO VEDERE DOPO IL RIEMPIMENTO DI MARIADB
    public void testDeleteAllByBrandAndModel_OK(){

        productDao.deleteAllByBrandAndModel("Sandisk","SATA III");
        Optional<List<Product>> products = productDao.findAllByBrandAndModel("Sandisk","SATA III");

        assert !products.isPresent();

    }


    @Ignore
    @Test //TODO VEDERE DOPO IL RIEMPIMENTO DI MARIADB
    public void testFindProductByBrandOrModelOrDescription_OK(){

        assert true;

    }


    @Ignore
    @Test //TODO VEDERE DOPO IL RIEMPIMENTO DI MARIADB
    public void testProductsByPurchase_OK() {

        assert true;

    }


    @Ignore
    @Test //TODO VEDERE DOPO IL RIEMPIMENTO DI MARIADB
    public void testFindAllByPurchase_IdIsNotNull_OK(){

        assert true;

    }



}
