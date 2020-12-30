package it.unical.asd.group6.computerSparePartsCompany.core.services;

import it.unical.asd.group6.computerSparePartsCompany.data.entities.Category;
import it.unical.asd.group6.computerSparePartsCompany.data.entities.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

public interface ProductService {
    List<Product> getAllProduct();

    List<Product> getAllProductByBrand(String brand);

    List<Product> getAllProductByBrandAndModel(String brand, String model);

    List<Product> getAllProductByPriceIsLessThan(Double price);

    List<Product> getProductsByModel(String model);

    List<Product> getProductsByCategory(String category);

    List<Product> getProductsInPriceRange(Double p1, Double p2);

    List<Product> getProductDistinct();

    List<Product> getProductDistinctByCategory(String category);

    Boolean addProduct(Product p);

    @Transactional
    Boolean deleteProduct(String brand, String model);

    @Transactional
    void updateProductAll(Long id, Double price, String desc, String url, Category cat);

    @Transactional
    void updateProductPrice(Long id, Double price);

    @Transactional
    void updateProductDescription(Long id, String desc);

    @Transactional
    void updateProductUrl(Long id, String url);

    @Transactional
    void updateProductCategory(Long id, Category cat);

    List<Product> distinctProductByCategory(Category category, double min, double max);

    List<Product> distinctProductByCategoryAndBrandCollection(Category category, Collection<String> brands, double min, double max);

    Product getById(String id);
}
