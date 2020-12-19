package it.unical.asd.group6.computerSparePartsCompany.data.dao;

import it.unical.asd.group6.computerSparePartsCompany.data.entities.PurchaseNotice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PurchaseNoticeDao extends JpaRepository<PurchaseNotice,Long> {

    Optional<List<PurchaseNotice>> findAllByWarehouseId(long warehouseId);

    Optional<List<PurchaseNotice>> findAllByCustomerId(Long customerId);

    Optional<List<PurchaseNotice>> findAllByQuantityGreaterThan(Integer quantity);
}
