package it.unical.asd.group6.computerSparePartsCompany.core.services;

import it.unical.asd.group6.computerSparePartsCompany.data.entities.Product;

import java.util.List;
import java.util.Optional;

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

    List<Product> getProductByBrandAndModel(String brand, String model);

    Product getProductById(Long id);

    Optional<List<Product>> getAllProductsForAPurchase(Long id);

    Optional<List<Product>> getAllPurchasedProducts();
}
