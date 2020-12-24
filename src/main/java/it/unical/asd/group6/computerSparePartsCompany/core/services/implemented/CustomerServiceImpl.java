package it.unical.asd.group6.computerSparePartsCompany.core.services.implemented;

import it.unical.asd.group6.computerSparePartsCompany.data.dao.CustomerDao;
import it.unical.asd.group6.computerSparePartsCompany.data.entities.Customer;
import it.unical.asd.group6.computerSparePartsCompany.core.services.CustomerService;
import it.unical.asd.group6.computerSparePartsCompany.data.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerDao customerDao;

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

    @Transactional
    public Boolean deleteCustomer(String username){
        customerDao.deleteByUsername(username);
        Optional<Customer> customerOptional = customerDao.findCustomerByUsername(username);
        return !customerOptional.isPresent();
    }}
