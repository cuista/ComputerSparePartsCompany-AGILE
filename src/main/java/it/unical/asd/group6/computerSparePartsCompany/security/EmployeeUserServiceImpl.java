package it.unical.asd.group6.computerSparePartsCompany.security;

import it.unical.asd.group6.computerSparePartsCompany.data.dao.EmployeeDao;
import it.unical.asd.group6.computerSparePartsCompany.data.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeUserServiceImpl implements UserDetailsService {

    @Autowired
    EmployeeDao employeeDao;

    @Override
    public UserDetails loadUserByUsername(String s) {
        System.out.println("Load user by username " + s);
        Optional<Employee> employee = this.employeeDao.findEmployeeByUsername(s);
        EmployeeUser employeeUser = new EmployeeUser(employee.get());
        System.out.println("employee user un e pw: " + employeeUser.getUsername() + " " + employeeUser.getPassword());
        return employeeUser;
    }
 }
