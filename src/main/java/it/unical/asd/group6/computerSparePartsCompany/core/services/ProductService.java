package it.unical.asd.group6.computerSparePartsCompany.core.services;

import it.unical.asd.group6.computerSparePartsCompany.data.dto.ProductDTO;
import it.unical.asd.group6.computerSparePartsCompany.data.entities.Category;
import it.unical.asd.group6.computerSparePartsCompany.data.entities.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<ProductDTO> getAllProduct();

    List<ProductDTO> getAllProductByBrand(String brand);

    List<ProductDTO> getAllProductByBrandAndModel(String brand, String model);

    List<ProductDTO> getAllProductByPriceIsLessThan(Double price);

    List<ProductDTO> getProductsByModel(String model);

    List<ProductDTO> getProductsByCategory(String category);

    List<ProductDTO> getProductsInPriceRange(Double p1, Double p2);

    List<ProductDTO> getProductDistinct();

    List<ProductDTO> getProductDistinctByCategory(String category);

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

    List<ProductDTO> distinctProductFiltered(Collection<Category> categories, Collection<String> brands, Collection<String> models, Double min, Double max);

    Optional<Product> getById(Long id);

    List<String> getAllBrands();

    List<String> getAllBrandsForCategory(Category category);

    List<ProductDTO> getProductsByFilters(Category c,String brand,Double min,Double max);

    List<ProductDTO> getProductByRegex(String s);

    List<ProductDTO> getProductByBrandAndModel(String brand, String model);

    Product getProductById(Long id);

    List<ProductDTO> getAllProductsForAPurchase(Long id);

    List<ProductDTO> getAllPurchasedProducts();

    List<Product> getAllEntityProductByBrandAndModel(String brand, String model);
}
