package it.unical.asd.group6.computerSparePartsCompany.core.services;

import it.unical.asd.group6.computerSparePartsCompany.data.entities.Customer;
import it.unical.asd.group6.computerSparePartsCompany.data.entities.Review;

import java.util.List;
import java.util.Optional;

public interface ReviewService {
    List<Review> getAll();
    List<Review> getAllByCustomer(Customer c);
    List<Review> getAllByBrandAndModel(String brand,String model);
    Boolean delete(Review r);
    Optional<Review>getAllByCustomerAndTitleAndText(Customer c,String title,String text);
    Optional<Review>getAllByCustomerAndTitleAndTextAndBrandAndModel(Customer c,String title,String text,String brand,String model);
    Boolean insert(String username,Review r);
}
