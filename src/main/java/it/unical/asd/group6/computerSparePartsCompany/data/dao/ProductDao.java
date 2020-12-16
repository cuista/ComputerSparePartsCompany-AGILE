package it.unical.asd.group6.computerSparePartsCompany.data.dao;

import it.unical.asd.group6.computerSparePartsCompany.data.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductDao extends JpaRepository<Product,Long>, JpaSpecificationExecutor<Product> {

    Optional<List<Product>> findAllByBrand(String brand);

    Optional<List<Product>> findAllByBrandAndModel(String brand, String model);

    Optional<List<Product>> findAllByPrice(Integer price);

    Optional<List<Product>> findAllByPriceIsLessThan(Integer price);

    Optional<List<Product>> findAllByModel(String model);

    Optional<List<Product>> findAllByCategory(String category);

    Optional<List<Product>> findAllByPriceBetween(Double p1, Double p2);

    //FIXME QUERY DI ESEMPIO: CHIEDERE AD ANDREA E GIANFRANCO
}
