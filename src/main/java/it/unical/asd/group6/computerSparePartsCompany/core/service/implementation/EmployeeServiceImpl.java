package it.unical.asd.group6.computerSparePartsCompany.core.service.implementation;

import it.unical.asd.group6.computerSparePartsCompany.core.service.EmployeeService;
import it.unical.asd.group6.computerSparePartsCompany.data.dao.EmployeeDao;
import it.unical.asd.group6.computerSparePartsCompany.data.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeDao employeeDao;

    /*
    Ritorna TRUE se l'employee, con le rispettive credenziali, è presente nel db
     */
    @Override
    public boolean checkLogin(String username, String password) {
        Optional<Employee> opt = employeeDao.findEmployeeByUsernameAndPassword(username, password);
        return opt.isPresent();
    }

    @Override
    public Optional<Employee> getEmployeeByUsername(String username)
    {
        Optional<Employee> employee = employeeDao.findEmployeeByUsername(username);
        return employee;
    }

    @Override
    public void updateEmployeeInfos(Employee employee) {
        employeeDao.save(employee);
    }
}
