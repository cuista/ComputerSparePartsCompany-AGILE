package it.unical.asd.group6.computerSparePartsCompany.data.dao;

import it.unical.asd.group6.computerSparePartsCompany.data.entities.ErrorMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ErrorMessageDAO extends JpaRepository<ErrorMessage,Long> {

    @Query("SELECT q FROM ErrorMessage q")
    Optional<List<ErrorMessage>>getAll();
    Optional<ErrorMessage> getAllByUsername(String username);

}
