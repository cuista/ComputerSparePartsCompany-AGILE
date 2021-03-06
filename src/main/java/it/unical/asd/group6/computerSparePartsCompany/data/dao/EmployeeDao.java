package it.unical.asd.group6.computerSparePartsCompany.data.dao;

import it.unical.asd.group6.computerSparePartsCompany.data.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeDao extends JpaRepository<Employee,Long>, JpaSpecificationExecutor<Employee> {

    Optional<List<Employee>> findAllByHiringDateIsLessThan(LocalDate date1);

    Optional<Employee> findEmployeeByTelephoneNumberEquals(String number);

    Optional<Employee> findEmployeeByUsernameAndPassword(String username, String password);

    Optional<Employee> findEmployeeByUsername(String username);

    @Transactional
    @Modifying
    @Query("UPDATE Employee e SET e.password =:password where e.username=:username")
    void updateEmployeePassword(@Param("username")String username,@Param("password") String password);
}