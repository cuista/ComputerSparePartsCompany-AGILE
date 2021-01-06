package it.unical.asd.group6.computerSparePartsCompany.controller;

import it.unical.asd.group6.computerSparePartsCompany.core.services.implemented.EmployeeServiceImpl;
import it.unical.asd.group6.computerSparePartsCompany.data.entities.Customer;
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
    private EmployeeServiceImpl employeeService;

    @GetMapping("/login")
    public ResponseEntity<Boolean> doLogin(
            @RequestParam("username") String username, @RequestParam("password") String password) {
        return ResponseEntity.ok(employeeService.checkLogin(username,password));
    }

    @GetMapping("/by-username")
    public ResponseEntity<Optional<Employee>> getEmployeeByUsername(String username)
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


    @GetMapping("/report-totalpurchases")
    public ResponseEntity<Integer> getTotalPurchases(){
        return ResponseEntity.ok(employeeService.getReportTotalPurchases());
    }

    @GetMapping("/report-totalamount")
    public ResponseEntity<Double> getTotalAmount(){
        return ResponseEntity.ok(employeeService.getReportTotalAmountSpent());
    }

    @GetMapping("/report-favoritecategory")
    public ResponseEntity<String> getFavoriteCategory(){
        return ResponseEntity.ok(employeeService.getReportFavoriteCategory());
    }

    @PostMapping("/change-password")
    public ResponseEntity<Boolean> changePassword(@RequestParam String username,@RequestParam String password,@RequestParam String oldPassword)
    {
        if(oldPassword.equals(employeeService.getEmployeeByUsername(username).get().getPassword()))
            return ResponseEntity.ok(employeeService.updateEmployee(username,password));
        else
            return ResponseEntity.ok(false);    }
}
