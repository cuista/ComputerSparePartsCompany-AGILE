package it.unical.asd.group6.computerSparePartsCompany.data.dao;

import it.unical.asd.group6.computerSparePartsCompany.data.entities.Category;
import it.unical.asd.group6.computerSparePartsCompany.data.entities.FAQ;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FAQDao extends JpaRepository<FAQ,Long> {

    Optional<FAQ>getByTitle(String title);
    Optional<FAQ>getByDescription(String description);
    Optional<FAQ>getById(Long ID);
    @Query("SELECT q FROM FAQ q")
    Optional<List<FAQ>>getAll();


}
