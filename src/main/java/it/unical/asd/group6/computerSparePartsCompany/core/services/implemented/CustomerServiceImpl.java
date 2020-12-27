package it.unical.asd.group6.computerSparePartsCompany.core.services.implemented;

import it.unical.asd.group6.computerSparePartsCompany.data.dao.CategoryDao;
import it.unical.asd.group6.computerSparePartsCompany.data.dao.CustomerDao;
import it.unical.asd.group6.computerSparePartsCompany.data.entities.Category;
import it.unical.asd.group6.computerSparePartsCompany.data.entities.Customer;
import it.unical.asd.group6.computerSparePartsCompany.core.services.CustomerService;
import it.unical.asd.group6.computerSparePartsCompany.data.entities.Product;
import it.unical.asd.group6.computerSparePartsCompany.data.entities.Purchase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerDao customerDao;

    @Autowired
    CategoryDao categoryDao;

    @Override
    public Boolean registerNewCustomer(Customer customer) {
        if (true){
            customerDao.save(customer);
            return true;
        }else
            return false;

    }

    private boolean checkPresenceInDatabase(Customer customer) {
        List<Customer> customers = customerDao.findAll();
        for (Customer c: customers){
            if (c.getEmail().equals(customer.getEmail()) || c.getUsername().equals(customer.getUsername()))
                return true;
        }
        return false;
    }

    @Override
    public Boolean checkLogin(String username, String password) {
        Optional<Customer> opt = customerDao.findCustomerByUsernameAndPassword(username, password);
        return opt.isPresent();
    }

    @Override
    public List<Customer> getAllCustomer() {
        return customerDao.findAll();
    }

    @Override
    public Customer deleteUser(Customer customer) {
        customerDao.delete(customer);
        return customer;
    }

    @Override
    public Boolean searchByUsername(String username) {
        Optional<Customer> customer = customerDao.findCustomerByUsername(username);
        return customer.isPresent();
    }

    @Override
    public Boolean searchByEmail(String email) {
        Optional<Customer> customer = customerDao.findCustomerByEmail(email);
        return customer.isPresent();
    }

    @Override
    public Optional<Customer> getCustomerByUsername(String username)
    {
        Optional<Customer> customer = customerDao.findCustomerByUsername(username);
        return customer;
    }

    @Override
    public Integer getReportTotalPurchases(String username) {
        int totalPurchases;
        Optional<Customer> optCust = customerDao.findCustomerByUsername(username);
        if (optCust.isPresent()){
            Customer customer = optCust.get();
            totalPurchases = customer.getPurchases().size();
            return totalPurchases;
        }
        return 0;
    }

    @Override
    public Double getReportTotalAmountSpent(String username) {
        double sum = 0.0;
        Optional<Customer> optCust = customerDao.findCustomerByUsername(username);
        if (optCust.isPresent()){
            Customer customer = optCust.get();
            List<Purchase> purchases = customer.getPurchases();
            for(Purchase p: purchases){
                sum += p.getTotalPrice();
            }
            return sum;
        }
        return 0.0;
    }

    @Override
    public Long getReportFavoriteCategory(String username) {
        Optional<Customer> optCust = customerDao.findCustomerByUsername(username);
        if (optCust.isPresent()){
            Customer customer = optCust.get();
            List<Purchase> purchases = customer.getPurchases();
            HashMap<Long, Integer> countCategory = initializeHashMapCategory();
                for(Purchase p: purchases){
                    List<Product> products = p.getProducts();
                    for(Product pr: products){
                        countCategory.put(pr.getCategory().getId(), countCategory.get(pr.getCategory().getId()) + 1);
                }
            }
            return countCategory.entrySet().stream().max((entry1, entry2) -> entry1.getValue() > entry2.getValue() ? 1 : -1).get().getKey();
        }
        return null;
    }

    private HashMap<Long, Integer> initializeHashMapCategory() {
        HashMap<Long, Integer> hm = new HashMap<Long, Integer>();
        List<Category> categories = categoryDao.findAll();
        for(Category c: categories)
            hm.put(c.getId(), 0);
        return hm;
    }


    @Transactional
    public Boolean deleteCustomer(String username){
        customerDao.deleteByUsername(username);
        Optional<Customer> customerOptional = customerDao.findCustomerByUsername(username);
        return !customerOptional.isPresent();
    }}
