package it.unical.asd.group6.computerSparePartsCompany.data.dao;

import it.unical.asd.group6.computerSparePartsCompany.data.entities.ProductionHouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductionHouseDao extends JpaRepository<ProductionHouse,Long>, JpaSpecificationExecutor<ProductionHouse> {
    Optional<ProductionHouse> findByName(String name);

    @Query("SELECT DISTINCT h.name FROM ProductionHouse h")
    List<String> getNames();
}
