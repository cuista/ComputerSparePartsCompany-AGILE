package it.unical.asd.group6.computerSparePartsCompany.data.services.implemented;

import it.unical.asd.group6.computerSparePartsCompany.data.dao.CustomerDao;
import it.unical.asd.group6.computerSparePartsCompany.data.entities.Customer;
import it.unical.asd.group6.computerSparePartsCompany.data.exception.UserNotFoundException;
import it.unical.asd.group6.computerSparePartsCompany.data.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerDao customerDao;

    @Override
    public Customer registerNewCustomer(Customer customer) {
        customerDao.save(customer);
        return customer;
    }

    @Override
    public boolean checkLogin(String username, String password) {
        Optional<Customer> opt = customerDao.findCustomerByUsernameAndPassword(username, password);
        if(opt.isPresent())
            return true;
        else throw new UserNotFoundException(username);
    }
}
