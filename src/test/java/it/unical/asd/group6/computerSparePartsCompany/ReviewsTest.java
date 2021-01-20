package it.unical.asd.group6.computerSparePartsCompany;

import it.unical.asd.group6.computerSparePartsCompany.core.services.implemented.CustomerServiceImpl;
import it.unical.asd.group6.computerSparePartsCompany.core.services.implemented.ProductServiceImpl;
import it.unical.asd.group6.computerSparePartsCompany.core.services.implemented.ReviewServiceImpl;
import it.unical.asd.group6.computerSparePartsCompany.data.entities.Customer;
import it.unical.asd.group6.computerSparePartsCompany.data.entities.Product;
import it.unical.asd.group6.computerSparePartsCompany.data.entities.Review;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

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
    public void testFindAll_OK(){

        List<Review> reviews = reviewDao.findAll();

        assert reviews.size() == 4;

    }

    @Test
    public void testFindAllByText_OK(){

        Review review = reviewDao.findAllByText("Oggetto meraviglioso");

        assert review!=null;

    }

    @Test
    public void testFindAllByCustomer_OK(){

        Optional<Customer> c=customerDao.findCustomerById(12L);

        List<Review> reviews = reviewDao.findAllByCustomer(c.get());

        assert reviews.size()==1;
        Review review=reviews.get(0);
        assert review.getTitle().equals("Bello");
        assert review.getText().equals("Ma_non_balla");

    }

    @Test
    public void testFindAllByBrandAndModel_OK(){

        List<Review> reviews =  reviewDao.findAllByBrandAndModel("Samsung","Curve Monitor");

        assert reviews.size()==1;
        Review review = reviews.get(0);
        assert review.getTitle().equals("Interessante");
        assert review.getText().equals("Economico ma interessante");

    }

    @Test
    public void testFindAllByCustomerAndTitleAndText_OK(){

        Optional<Customer> c = customerDao.findCustomerById(13L);

        Optional<Review> reviews = reviewDao.findAllByCustomerAndTitleAndText(c.get(),"Meraviglioso","Oggetto meraviglioso");

        assert reviews.isPresent();
    }

    @Test
    public void testfFindAllByCustomerAndTitleAndTextAndBrandAndModel_OK(){

        Optional<Customer> c = customerDao.findCustomerById(14L);

        Optional<Review> reviews = reviewDao.findAllByCustomerAndTitleAndTextAndBrandAndModel(c.get(),"Di media qualita'","Oggetto di media qualita'","NVidia","RTX 3090");

        assert reviews.isPresent();

    }

    @Test
    public void testFindByCustomerAndBrandAndModel_OK(){

        Optional<Customer> c = customerDao.findCustomerById(15L);

        Optional<Review> reviews = reviewDao.findByCustomerAndBrandAndModel(c.get(),"Samsung","Curve Monitor");

        assert reviews.isPresent();
    }

    @Test
    public void testFindByFilters_OK(){

        List<Review> review = reviewDao.findByFilters("Tilly",4L,"Sandisk","Extreme_Pro_64GB_SD_card");

        assert !review.isEmpty();

    }
}
