package it.unical.asd.group6.computerSparePartsCompany.core.services;

import it.unical.asd.group6.computerSparePartsCompany.data.entities.Customer;
import it.unical.asd.group6.computerSparePartsCompany.data.entities.Review;

import java.util.List;

public interface ReviewService {
    List<Review> getAll();
    List<Review> getAllByCustomer(Customer c);
    List<Review> getAllByBrandAndModel(String brand,String model);

}
