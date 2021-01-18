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
    ErrorMessageServiceImpl errorMessageService;

    @Autowired
    ModelMapper mapper;

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
        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setDescription(description);
        errorMessage.setEmail(email);
        errorMessage.setTitle(title);
        errorMessage.setUsername(username);
        errorMessageService.insert(errorMessage);
        return ResponseEntity.ok(true);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Boolean>delete(@RequestParam String username)
    {
        ErrorMessage errorMessage = mapper.map(errorMessageService.getByUsername(username),ErrorMessage.class);
        errorMessageService.remove(errorMessage);
        return ResponseEntity.ok(true);
    }


}
