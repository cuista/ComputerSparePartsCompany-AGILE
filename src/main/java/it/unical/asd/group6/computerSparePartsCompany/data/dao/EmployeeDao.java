package it.unical.asd.group6.computerSparePartsCompany.data.dao;

import it.unical.asd.group6.computerSparePartsCompany.data.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeDao extends JpaRepository<Employee,Long>, JpaSpecificationExecutor<Employee> {

    Optional<List<Employee>> findAllByHiringDateIsLessThan(LocalDate date1);

    Optional<Employee> findEmployeeByTelephoneNumberEquals(String number);

    Optional<Employee> findEmployeeByUsernameAndPassword(String username, String password);
    //QUERY DI ESEMPIO: CHIEDERE AD ANDREA E GIANFRANCO
}