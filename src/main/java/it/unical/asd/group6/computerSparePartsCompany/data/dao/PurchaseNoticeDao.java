package it.unical.asd.group6.computerSparePartsCompany.data.dao;

import it.unical.asd.group6.computerSparePartsCompany.data.entities.PurchaseNotice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PurchaseNoticeDao extends JpaRepository<PurchaseNotice,Long>, JpaSpecificationExecutor<PurchaseNotice> {

    //ordinati per non farli tornare in maniera ordinata (potrebbe tornare utile a employee?)
    List<PurchaseNotice> findAll();
}
