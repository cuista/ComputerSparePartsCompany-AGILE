package it.unical.asd.group6.computerSparePartsCompany.controller;

import it.unical.asd.group6.computerSparePartsCompany.core.services.implemented.FAQServiceImpl;
import it.unical.asd.group6.computerSparePartsCompany.data.dto.FAQDTO;
import it.unical.asd.group6.computerSparePartsCompany.data.entities.FAQ;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/faq")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class FAQController {

    @Autowired
    private FAQServiceImpl faqService;


    @PostMapping("/insert")
    public ResponseEntity<Boolean>insert(@RequestParam String title, @RequestParam String text)
    {
        return ResponseEntity.ok(faqService.insert(title, text));
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<FAQDTO>>getAll()
    {
        return ResponseEntity.ok(faqService.getAll());
    }

    @GetMapping("/get-by-title")
    public ResponseEntity<FAQ>getAllByTitle(@RequestParam String title)
    {
        return ResponseEntity.ok(faqService.getByTitle(title));
    }

    @GetMapping("/get-by-description")
    public ResponseEntity<FAQDTO>getAllByDescription(@RequestParam String description)
    {
        return ResponseEntity.ok(faqService.getByDescription(description));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Boolean>delete(@RequestParam String title)
    {
        FAQ faq = faqService.getByTitle(title);
        return ResponseEntity.ok(faqService.delete(faq));
    }

    @DeleteMapping("/delete-all")
    public ResponseEntity<Boolean>deleteAll()
    {
        faqService.deleteAll();
        return ResponseEntity.ok(true);
    }


}
