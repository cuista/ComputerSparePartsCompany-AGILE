package it.unical.asd.group6.computerSparePartsCompany.data.dao;

import it.unical.asd.group6.computerSparePartsCompany.data.entities.JobRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface JobRequestDAO extends JpaRepository<JobRequest,Long> {

    @Query("SELECT q FROM JobRequest q")
    Optional<List<JobRequest>>getAll();
    Optional<List<JobRequest>>getAllByTitle(String title);
    Optional<List<JobRequest>>getAllByPosition(String position);
    Optional<List<JobRequest>>getAllByEmail(String email);
    Optional<JobRequest>getByUsername(String username);

}
