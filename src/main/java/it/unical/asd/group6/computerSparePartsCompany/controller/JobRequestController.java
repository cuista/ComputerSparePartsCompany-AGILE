package it.unical.asd.group6.computerSparePartsCompany.controller;

import it.unical.asd.group6.computerSparePartsCompany.core.services.implemented.CustomerServiceImpl;
import it.unical.asd.group6.computerSparePartsCompany.core.services.implemented.EmployeeServiceImpl;
import it.unical.asd.group6.computerSparePartsCompany.core.services.implemented.FAQServiceImpl;
import it.unical.asd.group6.computerSparePartsCompany.core.services.implemented.JobRequestServiceImpl;
import it.unical.asd.group6.computerSparePartsCompany.data.dto.FAQDTO;
import it.unical.asd.group6.computerSparePartsCompany.data.dto.JobRequestDTO;
import it.unical.asd.group6.computerSparePartsCompany.data.entities.FAQ;
import it.unical.asd.group6.computerSparePartsCompany.data.entities.JobRequest;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/job-request")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class JobRequestController {

    @Autowired
    private JobRequestServiceImpl jobRequestService;

    @Autowired
    CustomerServiceImpl customerService;

    @Autowired
    EmployeeServiceImpl employeeService;

    @GetMapping("/get-all") //** e
    public ResponseEntity<List<JobRequestDTO>>getAll(@RequestParam String username, @RequestParam String password) {
        if (!employeeService.checkLogin(username, password)){
            throw new ResponseStatusException(HttpStatus.FORBIDDEN);
        }
        return ResponseEntity.ok(jobRequestService.getAll());
    }

    @GetMapping("/get-by-username")
    public ResponseEntity<JobRequestDTO>getByUsername(@RequestParam String username) {
        if(jobRequestService.getByUsername(username) != null)
            return ResponseEntity.ok(jobRequestService.getByUsername(username));
        return null;
    }

    @GetMapping("/exists-by-username")
    public ResponseEntity<Boolean>existsByUsername(@RequestParam String username) {
        return ResponseEntity.ok(jobRequestService.existsUsername(username));
    }

    @GetMapping("/get-all-by-title")
    public ResponseEntity<List<JobRequestDTO>>getAllByTitle(@RequestParam String title) {
        return ResponseEntity.ok(jobRequestService.getAllByTitle(title));
    }

    @GetMapping("/get-all-by-position")
    public ResponseEntity<List<JobRequestDTO>>getAllByPosition(@RequestParam String position) {
        return ResponseEntity.ok(jobRequestService.getAllByPosition(position));
    }

    @GetMapping("/get-all-by-email")
    public ResponseEntity<List<JobRequestDTO>>getAllByEmail(@RequestParam String email) {
        return ResponseEntity.ok(jobRequestService.getAllByEmail(email));
    }

    @PostMapping("/insert") //** c
    public ResponseEntity<Boolean>insert(@RequestParam String title, @RequestParam String position,
                                         @RequestParam String date, @RequestParam String description,
                                         @RequestParam String email, @RequestParam String username, @RequestParam String password) {
        if(!customerService.checkLogin(username,password)) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN);
        }
        jobRequestService.insert(title, position, date, description, email, username);
        return ResponseEntity.ok(true);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Boolean>delete(@RequestParam String username, @RequestParam String usernameE, @RequestParam String password) {
        if (!employeeService.checkLogin(usernameE, password)){
            throw new ResponseStatusException(HttpStatus.FORBIDDEN);
        }
        JobRequestDTO jobRequestDTO = jobRequestService.getByUsername(username);
        jobRequestService.delete(jobRequestDTO);
        return ResponseEntity.ok(true);
    }





}
