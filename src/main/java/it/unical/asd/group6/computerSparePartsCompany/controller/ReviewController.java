package it.unical.asd.group6.computerSparePartsCompany.controller;

import it.unical.asd.group6.computerSparePartsCompany.core.services.implemented.CustomerServiceImpl;
import it.unical.asd.group6.computerSparePartsCompany.core.services.implemented.ReviewServiceImpl;
import it.unical.asd.group6.computerSparePartsCompany.data.entities.Customer;
import it.unical.asd.group6.computerSparePartsCompany.data.entities.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/review")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ReviewController {

    @Autowired
    ReviewServiceImpl reviewService;

    @Autowired
    CustomerServiceImpl customerService;

    @GetMapping("/prova")
    public ResponseEntity<Boolean>stampa()
    {
        return ResponseEntity.ok(true);
    }

    @GetMapping("/byText")
    public ResponseEntity<Review>get(@RequestParam String text)
    {
        Review r = reviewService.getByTesto(text);
        return ResponseEntity.ok(r);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Review>>getAll()
    {
        return ResponseEntity.ok(reviewService.getAll());
    }

    @GetMapping("/all-by-customer")
    public ResponseEntity<List<Review>>getAllByCustomer(@RequestParam String username)
    {
        return ResponseEntity.ok(reviewService.getAllByCustomer(customerService.getCustomerByUsername(username).get()));
    }

    @GetMapping("/all-by-brand-and-model")
    public ResponseEntity<List<Review>>getAllByCustomer(@RequestParam String brand,@RequestParam String model)
    {
        return ResponseEntity.ok(reviewService.getAllByBrandAndModel(brand,model));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Boolean>delete(@RequestParam String username,@RequestParam String title,@RequestParam String text,@RequestParam String brand,@RequestParam String model)
    {
        /*questo perchè non possono esistere due recensioni dello stesso utente che abbiamo stesso titolo e testo per uno stesso prodotto*/
        /*questo deve essere completato*/
        Customer c = customerService.getCustomerByUsername(username).get();
        Optional<Review>r = reviewService.getAllByCustomerAndTitleAndTextAndBrandAndModel(c,title,text,brand,model);
        if(r.isPresent())
        {
            reviewService.delete(r.get());
            return ResponseEntity.ok(true);
        }
        return ResponseEntity.ok(false);
    }

    @GetMapping("/by-brand-and-model")
    public ResponseEntity<List<Review>> getAllByBrandAndModel(@RequestParam String brand,@RequestParam String model)
    {
        return ResponseEntity.ok(reviewService.getAllByBrandAndModel(brand,model));
    }

    @PostMapping("/add")
    public ResponseEntity<Boolean> add(@RequestParam String username, @RequestParam String brand,@RequestParam String model, @RequestParam String title, @RequestParam String text,@RequestParam String rate)
    {
        /*un utente u non può aggiungere due recensioni allo stesso prodotto*/
        /*il concetto di recensione si estende alla descrizione totale di tutti gli acquisti e non di un singolo*/
        Customer c = customerService.getCustomerByUsername(username).get(); /*esiste sicuramente*/
        /*se non esiste gia una recensione per quel prodotto allora */
        Optional<Review> r = reviewService.getByCustomerAndBrandAndModel(c,brand,model);
        if(r.isPresent())
            return ResponseEntity.ok(false); /*ha gia messo una recensione per quel prodotto*/
        else
        {
            Review review = new Review();
            review.setBrand(brand);
            review.setCustomer(c);
            review.setModel(model);
            review.setTitle(title);
            review.setText(text);
            review.setRate(Long.parseLong(rate));
            reviewService.addReview(review);
        }
        return ResponseEntity.ok(true);
    }

    @DeleteMapping("/delete-all")
    public ResponseEntity<Boolean> deleteAll()
    {
        List<Review> reviews = reviewService.getAll();
        for(int i = 0; i<reviews.size(); i++)
        {
            reviewService.delete(reviews.get(i));
        }
        return ResponseEntity.ok(true);
    }


}
