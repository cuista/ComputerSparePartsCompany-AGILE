package it.unical.asd.group6.computerSparePartsCompany.controller;

import it.unical.asd.group6.computerSparePartsCompany.core.service.EmployeeService;
import it.unical.asd.group6.computerSparePartsCompany.data.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/employee")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/login")
    public ResponseEntity<Boolean> doLogin(
            @RequestParam("username") String username, @RequestParam("password") String password) {
        return ResponseEntity.ok(employeeService.checkLogin(username,password));
    }

    @GetMapping("/by-username")
    public ResponseEntity<Optional<Employee>> getCustomerByUsername(String username)
    {
        return ResponseEntity.ok(employeeService.getEmployeeByUsername(username));
    }

    @PutMapping("/{username}")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee newEmployee, @PathVariable String username){

        Optional<Employee> optionalEmployee = employeeService.getEmployeeByUsername(username);

        if (!optionalEmployee.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Employee employee = optionalEmployee.get();

        employee.setPassword(newEmployee.getPassword());
        employee.setUsername(newEmployee.getUsername());
        employee.setFirstname(newEmployee.getFirstname());
        employee.setLastname(newEmployee.getLastname());
        employee.setTelephoneNumber(newEmployee.getTelephoneNumber());
        employee.setHiringDate(newEmployee.getHiringDate());
        employee.setEmail(newEmployee.getEmail());
        employeeService.updateEmployeeInfos(employee);
        return new ResponseEntity<>(HttpStatus.OK);

    }

}
