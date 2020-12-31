package it.unical.asd.group6.computerSparePartsCompany.data.dao;

import it.unical.asd.group6.computerSparePartsCompany.data.entities.Customer;
import it.unical.asd.group6.computerSparePartsCompany.data.entities.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewDao extends JpaRepository<Review,Long> {

    List<Review> findAll();
    Review findAllByText(String text);
    List<Review>findAllByCustomer(Customer c);
    List<Review>findAllByBrandAndModel(String brand,String model);

}
