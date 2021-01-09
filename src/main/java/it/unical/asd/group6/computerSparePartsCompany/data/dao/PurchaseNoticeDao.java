package it.unical.asd.group6.computerSparePartsCompany.data.dao;

import it.unical.asd.group6.computerSparePartsCompany.data.entities.Customer;
import it.unical.asd.group6.computerSparePartsCompany.data.entities.PurchaseNotice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface PurchaseNoticeDao extends JpaRepository<PurchaseNotice,Long> {

    Optional<List<PurchaseNotice>> findAllByWarehouseId(Long warehouseId);

    Optional<List<PurchaseNotice>> findAllByCustomerId(Long customerId);

    Optional<List<PurchaseNotice>> findAllByQuantityGreaterThan(Integer quantity);

    List<PurchaseNotice> findAll();

    List<PurchaseNotice> findAllByCustomer(Customer c);

    @Query("SELECT p FROM PurchaseNotice p WHERE ((:username) is null or p.customer.username=:username) " +
            "and ((:date) is null or p.collectionDate=:date)")
    List<PurchaseNotice>getByFilters(@Param("username") String username, @Param("date")LocalDate date);
}
