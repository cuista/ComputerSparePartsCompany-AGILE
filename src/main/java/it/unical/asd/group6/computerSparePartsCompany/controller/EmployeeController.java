package it.unical.asd.group6.computerSparePartsCompany.controller;

import it.unical.asd.group6.computerSparePartsCompany.core.services.implemented.EmployeeServiceImpl;
import it.unical.asd.group6.computerSparePartsCompany.data.dto.EmployeeDTO;
import it.unical.asd.group6.computerSparePartsCompany.data.entities.Customer;
import it.unical.asd.group6.computerSparePartsCompany.data.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

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

    @GetMapping("/by-username") //** e
    public ResponseEntity<Optional<EmployeeDTO>> getEmployeeByUsername(@RequestParam String username, @RequestParam String password) {
        if (!employeeService.checkLogin(username, password)){
            throw new ResponseStatusException(HttpStatus.FORBIDDEN);
        }
        return ResponseEntity.ok(employeeService.getEmployeeByUsername(username));
    }

    @PutMapping("/{username}")
    public ResponseEntity<EmployeeDTO> updateEmployee(@RequestBody EmployeeDTO newEmployee, @PathVariable String username) {

        Optional<EmployeeDTO> optionalEmployee = employeeService.getEmployeeByUsername(username);

        if (!optionalEmployee.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        employeeService.updateEmployeeInfos(optionalEmployee.get(), newEmployee);
        return new ResponseEntity<>(HttpStatus.OK);

    }


    @GetMapping("/report-totalpurchases") //** e
    public ResponseEntity<Integer> getTotalPurchases(@RequestParam String username, @RequestParam String password){
        if (!employeeService.checkLogin(username, password)){
            throw new ResponseStatusException(HttpStatus.FORBIDDEN);
        }
        return ResponseEntity.ok(employeeService.getReportTotalPurchases());
    }

    @GetMapping("/report-totalamount") //** e
    public ResponseEntity<Double> getTotalAmount(@RequestParam String username, @RequestParam String password){
        if (!employeeService.checkLogin(username, password)){
            throw new ResponseStatusException(HttpStatus.FORBIDDEN);
        }
        return ResponseEntity.ok(employeeService.getReportTotalAmountSpent());
    }

    @GetMapping("/report-favoritecategory") //** e
    public ResponseEntity<String> getFavoriteCategory(@RequestParam String username, @RequestParam String password){
        if (!employeeService.checkLogin(username, password)){
            throw new ResponseStatusException(HttpStatus.FORBIDDEN);
        }
        return ResponseEntity.ok(employeeService.getReportFavoriteCategory());
    }

    @PostMapping("/change-password")
    public ResponseEntity<Boolean> changePassword(@RequestParam String username,@RequestParam String password,@RequestParam String oldPassword)
    {
        if(oldPassword.equals(employeeService.getEmployeeByUsername(username).get().getPassword()))
            return ResponseEntity.ok(employeeService.updateEmployee(username,password));
        else
            return ResponseEntity.ok(false);
    }
}
