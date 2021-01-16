package it.unical.asd.group6.computerSparePartsCompany.controller;

import it.unical.asd.group6.computerSparePartsCompany.core.services.implemented.EmployeeServiceImpl;
import it.unical.asd.group6.computerSparePartsCompany.data.dto.EmployeeDTO;
import it.unical.asd.group6.computerSparePartsCompany.data.entities.Employee;
import it.unical.asd.group6.computerSparePartsCompany.security.EmployeeUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
//@CrossOrigin(origins = "*", allowedHeaders = "*")
@CrossOrigin
public class EmployeeController {

    @Autowired
    private EmployeeServiceImpl employeeService;

    @Autowired
    private EmployeeUserServiceImpl employeeUserService;

    //@Autowired
    //private AuthenticationManager authenticationManager;

    @RequestMapping("/login")
    public HttpStatus doLogin(@RequestParam String username) {
        if(employeeService.getEmployeeByUsername(username) == null) {
            return HttpStatus.FORBIDDEN;
        }
        System.out.println("loggato");
        return HttpStatus.OK;
    }

    /*@GetMapping("/login")
    public ResponseEntity<Boolean> doLogin(
            @RequestParam("username") String username, @RequestParam("password") String password) {
        return ResponseEntity.ok(employeeService.checkLogin(username,password));
    }*/

    @GetMapping("/all")
    public ResponseEntity<List<EmployeeDTO>> employeeList() {
        return ResponseEntity.ok(employeeService.getAll());
    }

    @GetMapping("/by-username")
    public ResponseEntity<Optional<EmployeeDTO>> getEmployeeByUsername(String username) {
        System.out.println(employeeService.getEmployeeByUsername(username).toString());
        return ResponseEntity.ok(employeeService.getEmployeeByUsername(username));
    }

    @PutMapping("/{username}")
    public ResponseEntity<EmployeeDTO> updateEmployee(@RequestBody Employee newEmployee, @PathVariable String username) {

        Optional<EmployeeDTO> optionalEmployee = employeeService.getEmployeeByUsername(username);

        if (!optionalEmployee.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        EmployeeDTO employee = optionalEmployee.get();

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
            return ResponseEntity.ok(false);
    }
}
