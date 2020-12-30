package it.unical.asd.group6.computerSparePartsCompany.core.services.implemented;

import it.unical.asd.group6.computerSparePartsCompany.data.dao.ProductDao;
import it.unical.asd.group6.computerSparePartsCompany.data.entities.Category;
import it.unical.asd.group6.computerSparePartsCompany.data.entities.Product;
import it.unical.asd.group6.computerSparePartsCompany.core.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductDao productDao;

    @Override
    public List<Product> getAllProduct(){
        return productDao.findAll();
    }

    @Override
    public List<Product> getAllProductByBrand(String brand){
        Optional<List<Product>> productOptional = productDao.findAllByBrand(brand);
        return productOptional.orElse(null);
    }

    @Override
    public List<Product> getAllProductByBrandAndModel(String brand, String model){
        Optional<List<Product>> productOptional = productDao.findAllByBrandAndModel(brand, model);
        return productOptional.orElse(null);
    }

    @Override
    public List<Product> getAllProductByPriceIsLessThan(Double price){
        Optional<List<Product>> productOptional = productDao.findAllByPriceIsLessThan(price);
        return productOptional.orElse(null);
    }

    @Override
    public List<Product> getProductsByModel(String model){
        Optional<List<Product>> productOptional = productDao.findAllByModel(model);
        return productOptional.orElse(null);
    }

    @Override
    public List<Product> getProductsByCategory(String category){
        /*Optional<List<Product>> productOptional = productDao.findAllByCategory(category);
        return productOptional.orElse(null);*/
        return null;
    }

    @Override
    public List<Product> getProductsInPriceRange(Double p1, Double p2) {
        Optional<List<Product>> products = productDao.findAllByPriceBetween(p1,p2);
        return products.orElse(null);
    }

    @Override
    public List<Product> getProductDistinct() {
        List<Product> products = productDao.findAll().stream().distinct().collect(Collectors.toList());
        if(products.isEmpty()) {
            return null;
        }
        return products;
    }

    @Override
    public List<Product> getProductDistinctByCategory(String category) {
        /*List<Product> products = productDao.findAllByCategory(category).get().stream().distinct().collect(Collectors.toList());
        if(products.isEmpty()) {
            return null;
        }
        return products;*/
        return null;
    }

    @Override
    public Boolean addProduct(Product p) {
        Optional<List<Product>> productOptional = productDao.findAllByBrandAndModel(p.getBrand(), p.getModel());
        if (!productOptional.isPresent()){
            productDao.save(p);
            return true;
        }
        else{
            List<Product> products = productOptional.get();
            if(p.equals(products.get(0))){
                productDao.save(p);
                return true;
            }else
                return false;
        }

    }

    @Override
    @Transactional
    public Boolean deleteProduct(String brand, String model){
        productDao.deleteAllByBrandAndModel(brand, model);
        Optional<List<Product>> productOptional = productDao.findAllByBrandAndModel(brand, model);
        return !productOptional.isPresent();
    }

    @Override
    @Transactional
    public void updateProductAll(Long id, Double price, String desc, String url, Category cat){
        productDao.updateProductAll(id, desc, price, url, cat);
    }

    @Override
    @Transactional
    public void updateProductPrice(Long id, Double price){
        productDao.updateProductPrice(id, price);
    }

    @Override
    @Transactional
    public void updateProductDescription(Long id, String desc){
        productDao.updateProductDescription(id, desc);
    }

    @Override
    @Transactional
    public void updateProductUrl(Long id, String url){
        productDao.updateProductURL(id, url);
    }

    @Override
    @Transactional
    public void updateProductCategory(Long id, Category cat){
        productDao.updateProductCategory(id, cat);
    }

    @Override
    public List<Product> distinctProductByCategory(Category category, double min, double max) {
        List<Product> temp = productDao.findAllByCategoryIdAndPriceBetween(category.getId(), min, max);
        return  temp.stream().distinct().collect(Collectors.toList());
    }

    @Override
    public List<Product> distinctProductByCategoryAndBrandCollection(Category category, Collection<String> brands, double min, double max) {
        List<Product> temp = productDao.findAllByCategoryIdAndBrandInAndPriceBetween(category.getId(), brands, min, max);
        return  temp.stream().distinct().collect(Collectors.toList());
    }

    @Override
    public Product getById(String id)
    {
        return productDao.findById(id);
    }
}
