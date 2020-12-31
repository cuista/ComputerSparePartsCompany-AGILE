package it.unical.asd.group6.computerSparePartsCompany.data.dao;

import it.unical.asd.group6.computerSparePartsCompany.data.entities.Customer;
import it.unical.asd.group6.computerSparePartsCompany.data.entities.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ReviewDao extends JpaRepository<Review,Long> {

    List<Review> findAll();
    Review findAllByText(String text);
    List<Review>findAllByCustomer(Customer c);
    List<Review>findAllByBrandAndModel(String brand,String model);
    Optional<Review> findAllByCustomerAndTitleAndText(Customer c, String title, String text);
    Optional<Review> findAllByCustomerAndTitleAndTextAndBrandAndModel(Customer c, String title, String text,String brand,String model);

}
