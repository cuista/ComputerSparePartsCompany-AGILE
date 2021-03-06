package it.unical.asd.group6.computerSparePartsCompany.data.dao;

import it.unical.asd.group6.computerSparePartsCompany.data.entities.Category;
import it.unical.asd.group6.computerSparePartsCompany.data.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductDao extends JpaRepository<Product,Long>, JpaSpecificationExecutor<Product> {

    Optional<Product> findById(Long id);

    Optional<List<Product>> findAllByBrand(String brand);

    Optional<List<Product>> findAllByBrandAndModel(String brand, String model);

    Optional<List<Product>> findAllByPrice(Double price);

    Optional<List<Product>> findAllByPriceIsLessThan(Double price);

    Optional<List<Product>> findAllByModel(String model);

    Optional<List<Product>> findAllByPriceBetween(Double p1, Double p2);

    Optional<Product> findProductByBrandAndModel(String brand, String model);

    @Query(value = "Select p from Product p where p.purchase.id=:id")
    Optional<List<Product>> productsByPurchase(@Param("id") Long id);

    Optional<List<Product>> findAllByPurchase_IdIsNotNull();

    @Transactional
    void deleteAllByBrandAndModel(String brand, String model);

    @Modifying
    @Transactional
    @Query("UPDATE Product p SET p.price =:price where p.id=:id")
    void updateProductPrice(@Param("id")Long id, @Param("price") Double price);

    @Modifying
    @Transactional
    @Query("UPDATE Product p SET p.description =:description where p.id=:id")
    void updateProductDescription(@Param("id")Long id, @Param("description") String description);

    @Modifying
    @Transactional
    @Query("UPDATE Product p SET p.imageUrl =:url where p.id=:id")
    void updateProductURL(@Param("id")Long id, @Param("url") String url);

    @Modifying
    @Transactional
    @Query("UPDATE Product p SET p.category =:category where p.id=:id")
    void updateProductCategory(@Param("id")Long id, @Param("category") Category category);

    @Modifying
    @Transactional
    @Query("UPDATE Product p SET p.description =:description, p.price =:price, p.imageUrl =:url, p.category =:category where p.id=:id")
    void updateProductAll(@Param("id")Long id, @Param("description") String description, @Param("price") Double price, @Param("url") String url, @Param("category") Category category);

    @Query("SELECT p FROM Product p WHERE ((:categories) is null or p.category IN (:categories))"
            + " and ((:brand) is null or p.brand IN (:brand)) and ((:model) is null"
            + " or p.model IN (:model)) and (p.price >= :min and p.price <= :max)")
    List<Product> findProductByBrandInAndModelInAndPriceBetween(
            @Param("categories") Collection<Category> categories,
            @Param("brand") Collection<String> brands, @Param("model") Collection<String> models,
            @Param("min") Double min,@Param("max") Double max);

    List<Product> findAllByCategoryIdAndPriceBetween(Long category, Double min, Double max);

    List<Product> findAllByCategoryIdAndBrandInAndPriceBetween(Long category, Collection<String> brands, double min, double max);

    @Query("SELECT DISTINCT p.brand FROM Product p")
    List<String> getAllBrands();

    @Query("SELECT DISTINCT p.brand FROM Product p where p.category =:c")
    List<String> getAllBrandsByCategory(@Param("c") Category category);


    @Query("SELECT p FROM Product p WHERE ((:c) is null or p.category=:c) " +
            "and ((:brand) is null or p.brand=:brand) " +
            "and (((:min) is null or (:max) is null) or (p.price >= :min and p.price <= :max))")
    List<Product> findByFilters(@Param("c") Category c, @Param("brand") String brand,@Param("min") Double priceMin,@Param("max")Double priceMax);

    @Query(nativeQuery=true, value="SELECT * FROM PRODUCT WHERE LCASE (BRAND) LIKE ?1 OR LCASE (MODEL) LIKE ?1 OR LCASE (DESCRIPTION) LIKE ?1")
    List<Product> findProductByBrandOrModelOrDescription(String regex);
}
