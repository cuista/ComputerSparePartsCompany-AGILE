package it.unical.asd.group6.computerSparePartsCompany.core.services.implemented;

import it.unical.asd.group6.computerSparePartsCompany.core.services.ReviewService;
import it.unical.asd.group6.computerSparePartsCompany.data.dao.PurchaseNoticeDao;
import it.unical.asd.group6.computerSparePartsCompany.data.dao.ReviewDao;
import it.unical.asd.group6.computerSparePartsCompany.data.entities.Customer;
import it.unical.asd.group6.computerSparePartsCompany.data.entities.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    ReviewDao reviewDao;

    public Boolean addReview(Review r){
        reviewDao.save(r);
        return true;
    }

    public Review getByTesto(String testo)
    {
        return reviewDao.findAllByText(testo);
    }

    @Override
    public List<Review> getAll() {
        return reviewDao.findAll();
    }

    @Override
    public List<Review> getAllByCustomer(Customer c) {
        return reviewDao.findAllByCustomer(c);
    }

    @Override
    public List<Review> getAllByBrandAndModel(String brand, String model) {
        return reviewDao.findAllByBrandAndModel(brand,model);
    }

    @Override
    public Boolean delete(Review r) {
        reviewDao.delete(r);
        return true;
    }

    @Override
    public Optional<Review> getAllByCustomerAndTitleAndText(Customer c, String title, String text) {
        return reviewDao.findAllByCustomerAndTitleAndText(c,title,text);
    }

    @Override
    public Optional<Review> getAllByCustomerAndTitleAndTextAndBrandAndModel(Customer c, String title, String text, String brand, String model) {
        return reviewDao.findAllByCustomerAndTitleAndTextAndBrandAndModel(c,title,text,brand,model);
    }

    @Override
    public Boolean insert(Review r) {
        reviewDao.save(r);
        return true;
    }

    @Override
    public Optional<Review> getByCustomerAndBrandAndModel(Customer c,String brand,String model)
    {
        return reviewDao.findByCustomerAndBrandAndModel(c,brand,model);
    }


}
