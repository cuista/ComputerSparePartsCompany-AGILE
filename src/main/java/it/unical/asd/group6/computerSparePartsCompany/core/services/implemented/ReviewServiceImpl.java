package it.unical.asd.group6.computerSparePartsCompany.core.services.implemented;

import it.unical.asd.group6.computerSparePartsCompany.core.services.ReviewService;
import it.unical.asd.group6.computerSparePartsCompany.data.dao.PurchaseNoticeDao;
import it.unical.asd.group6.computerSparePartsCompany.data.dao.ReviewDao;
import it.unical.asd.group6.computerSparePartsCompany.data.entities.Customer;
import it.unical.asd.group6.computerSparePartsCompany.data.entities.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
