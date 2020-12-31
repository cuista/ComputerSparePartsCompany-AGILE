package it.unical.asd.group6.computerSparePartsCompany.data.dao;

import it.unical.asd.group6.computerSparePartsCompany.data.entities.OrderRequest;
import it.unical.asd.group6.computerSparePartsCompany.data.entities.ProductionHouse;
import it.unical.asd.group6.computerSparePartsCompany.data.entities.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRequestDao extends JpaRepository<OrderRequest,Long>, JpaSpecificationExecutor<OrderRequest> {

    Optional<List<OrderRequest>> findAllByProductionHouse(ProductionHouse productionHouse);
    Optional<List<OrderRequest>> findAllByWarehouse(Warehouse warehouse);
    Optional<List<OrderRequest>> findAllByProductionHouseAndWarehouse(ProductionHouse productionHouse,Warehouse warehouse);

}