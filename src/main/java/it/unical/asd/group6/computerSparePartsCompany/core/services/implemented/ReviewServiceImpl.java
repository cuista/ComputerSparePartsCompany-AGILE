package it.unical.asd.group6.computerSparePartsCompany.core.services.implemented;

import it.unical.asd.group6.computerSparePartsCompany.core.services.ReviewService;
import it.unical.asd.group6.computerSparePartsCompany.data.dao.PurchaseNoticeDao;
import it.unical.asd.group6.computerSparePartsCompany.data.dao.ReviewDao;
import it.unical.asd.group6.computerSparePartsCompany.data.dto.CategoryDTO;
import it.unical.asd.group6.computerSparePartsCompany.data.dto.ReviewDTO;
import it.unical.asd.group6.computerSparePartsCompany.data.entities.Customer;
import it.unical.asd.group6.computerSparePartsCompany.data.entities.Product;
import it.unical.asd.group6.computerSparePartsCompany.data.entities.Review;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    ReviewDao reviewDao;

    @Autowired
    ModelMapper modelMapper;

    public Boolean addReview(Review r){
        reviewDao.save(r);
        return true;
    }

    public Review getByTesto(String testo) {
        return reviewDao.findAllByText(testo);
    }

    @Override
    public List<ReviewDTO> getAll() {
        List<Review> reviews = reviewDao.findAll();
        List<ReviewDTO> reviewDTOS = reviews.stream().map(cat -> modelMapper.map(cat, ReviewDTO.class)).collect(Collectors.toList());
        return reviewDTOS;
    }

    @Override
    public List<ReviewDTO> getAllByCustomer(Customer c) {
        List<Review> reviews = reviewDao.findAllByCustomer(c);
        List<ReviewDTO> reviewDTOS = reviews.stream().map(cat -> modelMapper.map(cat, ReviewDTO.class)).collect(Collectors.toList());
        return reviewDTOS;
    }

    @Override
    public List<ReviewDTO> getAllByBrandAndModel(String brand, String model) {
        List<Review> reviews = reviewDao.findAllByBrandAndModel(brand,model);
        List<ReviewDTO> reviewDTOS = reviews.stream().map(cat -> modelMapper.map(cat, ReviewDTO.class)).collect(Collectors.toList());
        return reviewDTOS;
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
    public Optional<Review> getByCustomerAndBrandAndModel(Customer c,String brand,String model) {
        return reviewDao.findByCustomerAndBrandAndModel(c,brand,model);
    }

    @Override
    public List<ReviewDTO> findByFilters(String username, Long rate,String brand,String model) {
        List<Review> reviews =  reviewDao.findByFilters(username,rate,brand, model);
        List<ReviewDTO> reviewDTOS = reviews.stream().map(cat -> modelMapper.map(cat, ReviewDTO.class)).collect(Collectors.toList());
        return reviewDTOS.stream().distinct().collect(Collectors.toList());
    }

    @Override
    public List<Review> getAllAsEntity() {
        return reviewDao.findAll();
    }


}
