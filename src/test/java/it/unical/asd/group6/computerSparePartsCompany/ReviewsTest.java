package it.unical.asd.group6.computerSparePartsCompany;

import it.unical.asd.group6.computerSparePartsCompany.core.services.implemented.CustomerServiceImpl;
import it.unical.asd.group6.computerSparePartsCompany.core.services.implemented.ProductServiceImpl;
import it.unical.asd.group6.computerSparePartsCompany.core.services.implemented.ReviewServiceImpl;
import it.unical.asd.group6.computerSparePartsCompany.data.entities.Customer;
import it.unical.asd.group6.computerSparePartsCompany.data.entities.Product;
import it.unical.asd.group6.computerSparePartsCompany.data.entities.Review;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ReviewsTest extends AbstractComputerSparePartsCompanyTest {

    @Autowired
    ReviewServiceImpl reviewService;

    @Autowired
    CustomerServiceImpl customerService;

    @Autowired
    ProductServiceImpl productService;

    @Test
    public void testAddReviews(){
        Review r = new Review();
        r.setText("Bellissima merda");
        r.setTitle("balla");
        r.setRate(Long.parseLong("4"));
        Customer c = customerService.getCustomerByUsername("Marti").get();
        r.setCustomer(c);
        r.setBrand("Nvidia");
        r.setModel("Ciccio");
        assert (reviewService.addReview(r));
    }
}
