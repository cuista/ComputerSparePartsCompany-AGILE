package it.unical.asd.group6.computerSparePartsCompany.core.services.implemented;

import it.unical.asd.group6.computerSparePartsCompany.data.dao.ProductDao;
import it.unical.asd.group6.computerSparePartsCompany.data.entities.Product;
import it.unical.asd.group6.computerSparePartsCompany.core.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
