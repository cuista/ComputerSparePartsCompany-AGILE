package it.unical.asd.group6.computerSparePartsCompany.data.dao;

import it.unical.asd.group6.computerSparePartsCompany.data.entities.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface WarehouseDao extends JpaRepository<Warehouse,Long> {

    Optional<List<Warehouse>> findAllByOpeningHours(String opening_hour);

    Optional<List<Warehouse>> findAllByRegion(String region);

    Optional<List<Warehouse>> findAllByCity(String city);


}
