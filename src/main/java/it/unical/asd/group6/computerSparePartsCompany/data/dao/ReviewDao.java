package it.unical.asd.group6.computerSparePartsCompany.data.dao;

import it.unical.asd.group6.computerSparePartsCompany.data.entities.Category;
import it.unical.asd.group6.computerSparePartsCompany.data.entities.Customer;
import it.unical.asd.group6.computerSparePartsCompany.data.entities.Product;
import it.unical.asd.group6.computerSparePartsCompany.data.entities.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ReviewDao extends JpaRepository<Review,Long> {

    List<Review> findAll();
    Review findAllByText(String text);
    List<Review>findAllByCustomer(Customer c);
    List<Review>findAllByBrandAndModel(String brand,String model);
    Optional<Review> findAllByCustomerAndTitleAndText(Customer c, String title, String text);
    Optional<Review> findAllByCustomerAndTitleAndTextAndBrandAndModel(Customer c, String title, String text,String brand,String model);
    Optional<Review> findByCustomerAndBrandAndModel(Customer c,String brand,String model);
    @Query("SELECT p FROM Review p WHERE ((:username) is null or p.customer.username=:username) " +
            "and ((:rate) is null or p.rate=:rate) and ((:brand) is null or p.brand=:brand) and ((:model) is null or p.model=:model)")
    List<Review> findByFilters(@Param("username") String username, @Param("rate") Long rate,@Param("brand") String brand,@Param("model") String model);


}
