package it.unical.asd.group6.computerSparePartsCompany.core.services.implemented;

import it.unical.asd.group6.computerSparePartsCompany.data.dao.CustomerDao;
import it.unical.asd.group6.computerSparePartsCompany.data.entities.Customer;
import it.unical.asd.group6.computerSparePartsCompany.core.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerDao customerDao;

    @Override
    public Boolean registerNewCustomer(Customer customer) {
        if (!checkPresenceInDatabase(customer)){
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
}
