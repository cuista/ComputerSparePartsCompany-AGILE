package it.unical.asd.group6.computerSparePartsCompany.data.dao;

import it.unical.asd.group6.computerSparePartsCompany.data.entities.ProductionHouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductionHouseDao extends JpaRepository<ProductionHouse,Long>, JpaSpecificationExecutor<ProductionHouse> {
    Optional<ProductionHouse> findByName(String name);
}
