package it.unical.asd.group6.computerSparePartsCompany.controller;
import it.unical.asd.group6.computerSparePartsCompany.core.services.implemented.ErrorMessageServiceImpl;
import it.unical.asd.group6.computerSparePartsCompany.data.dto.ErrorMessageDTO;
import it.unical.asd.group6.computerSparePartsCompany.data.entities.ErrorMessage;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/error-message")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ErrorMessageController {

    @Autowired
    private ErrorMessageServiceImpl errorMessageService;

    @GetMapping("/get-all")
    public ResponseEntity<List<ErrorMessageDTO>> getAll()
    {
        return ResponseEntity.ok(errorMessageService.getAll());
    }

    @GetMapping("/get-by-username")
    public ResponseEntity<ErrorMessageDTO>getByUsername(@RequestParam String username)
    {
        return ResponseEntity.ok(errorMessageService.getByUsername(username));
    }

    @PostMapping("/insert")
    public ResponseEntity<Boolean>insert(@RequestParam String title,@RequestParam String description,@RequestParam String email,@RequestParam String username)
    {
        errorMessageService.insert(title, description, email, username);
        return ResponseEntity.ok(true);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Boolean>delete(@RequestParam String username)
    {
        errorMessageService.remove(username);
        return ResponseEntity.ok(true);
    }


}
