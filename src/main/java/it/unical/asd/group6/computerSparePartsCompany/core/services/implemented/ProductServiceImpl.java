package it.unical.asd.group6.computerSparePartsCompany.core.services.implemented;

import it.unical.asd.group6.computerSparePartsCompany.data.dao.ProductDao;
import it.unical.asd.group6.computerSparePartsCompany.data.entities.Product;
import it.unical.asd.group6.computerSparePartsCompany.core.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        Optional<List<Product>> productOptional = productDao.findAllByCategory(category);
        return productOptional.orElse(null);
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
        List<Product> products = productDao.findAllByCategory(category).get().stream().distinct().collect(Collectors.toList());
        if(products.isEmpty()) {
            return null;
        }
        return products;
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
    public List<Product> getProductByBrandAndModel(String brand, String model) {
        return null;
    }

    @Override
    public Product getProductById(Long id) {

        Optional<Product> product=productDao.findById(id);

        if (!product.isPresent()){
            return null;
        }

        return product.get();
    }

    @Override
    public Optional<List<Product>> getAllProductsForAPurchase(Long id) {

        Optional<List<Product>> productsByPurchase= productDao.productsByPurchase(id);


        if (!productsByPurchase.isPresent()){
            return null;
        }

        return productsByPurchase;
    }

    @Override
    public Optional<List<Product>> getAllPurchasedProducts() {
        return productDao.findAllByPurchase_IdIsNotNull();
    }

    @Transactional
    public Boolean deleteProduct(String brand, String model){
        productDao.deleteAllByBrandAndModel(brand, model);
        Optional<List<Product>> productOptional = productDao.findAllByBrandAndModel(brand, model);
        return !productOptional.isPresent();
    }






}
