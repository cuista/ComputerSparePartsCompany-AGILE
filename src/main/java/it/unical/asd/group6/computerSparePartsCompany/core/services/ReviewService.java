package it.unical.asd.group6.computerSparePartsCompany.core.services;

import it.unical.asd.group6.computerSparePartsCompany.data.dto.ReviewDTO;
import it.unical.asd.group6.computerSparePartsCompany.data.entities.Customer;
import it.unical.asd.group6.computerSparePartsCompany.data.entities.Review;

import java.util.List;
import java.util.Optional;

public interface ReviewService {

    List<ReviewDTO> getAll();

    List<ReviewDTO> getAllByCustomer(Customer c);

    List<ReviewDTO> getAllByBrandAndModel(String brand,String model);

    Boolean delete(Review r);

    Optional<Review>getAllByCustomerAndTitleAndText(Customer c,String title,String text);

    Optional<Review>getAllByCustomerAndTitleAndTextAndBrandAndModel(Customer c,String title,String text,String brand,String model);

    Boolean insert(Review r);

    Optional<Review>getByCustomerAndBrandAndModel(Customer c,String brand,String model);

    List<ReviewDTO>findByFilters(String username,Long rate,String brand,String model);

    List<Review> getAllAsEntity();
}
