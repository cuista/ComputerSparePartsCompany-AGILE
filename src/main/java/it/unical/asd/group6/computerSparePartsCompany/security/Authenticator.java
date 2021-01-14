package it.unical.asd.group6.computerSparePartsCompany.security;

import it.unical.asd.group6.computerSparePartsCompany.core.services.implemented.EmployeeServiceImpl;
import it.unical.asd.group6.computerSparePartsCompany.data.dao.EmployeeDao;
import it.unical.asd.group6.computerSparePartsCompany.data.dto.EmployeeDTO;
import it.unical.asd.group6.computerSparePartsCompany.data.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.Optional;
/*
public class Authenticator implements AuthenticationProvider {

    @Autowired
    EmployeeServiceImpl employeeService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getPrincipal().toString();
        String password = authentication.getCredentials().toString();
        Optional<EmployeeDTO> employee = employeeService.getEmployeeByUsername(username);
        //Optional<Employee> employee = employeeDao.findEmployeeByUsernameAndPassword(username,password);
        if(!employee.isPresent()) {
            return null;
        }
        return new UsernamePasswordAuthenticationToken(
                employee.get().getUsername(),employee.get().getPassword(), employee.get().getAuthority());
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return false;
    }
}
*/