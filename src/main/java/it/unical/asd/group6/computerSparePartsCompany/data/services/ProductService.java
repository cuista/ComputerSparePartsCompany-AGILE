package it.unical.asd.group6.computerSparePartsCompany.data.services;

import it.unical.asd.group6.computerSparePartsCompany.data.entities.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProduct();

    List<Product> getAllProductByBrand(String brand);

    List<Product> getAllProductByBrandAndModel(String brand, String model);

    List<Product> getAllProductByPriceIsLessThan(Double price);
}
